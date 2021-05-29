package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.dto.Transaction
import com.friendlymoney.backend.entity.TransactionEntity
import com.friendlymoney.backend.entity.TransactionToTagEntity
import com.friendlymoney.backend.mapper.TransactionMapper.Companion.TRANSACTION_MAPPER
import com.friendlymoney.backend.repository.AccountRepository
import com.friendlymoney.backend.repository.TagRepository
import com.friendlymoney.backend.repository.TransactionRepository
import com.friendlymoney.backend.repository.TransactionToTagRepository
import com.friendlymoney.backend.service.AccountBalanceService
import com.friendlymoney.backend.service.TransactionService
import com.friendlymoney.backend.util.LocalDateUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class TransactionServiceImpl(
        private val accountBalanceService: AccountBalanceService,
        private val accountRepository: AccountRepository,
        private val tagRepository: TagRepository,
        private val transactionRepository: TransactionRepository,
        private val transactionToTagRepository: TransactionToTagRepository
): TransactionService {

    override fun findByKey(key: String): Transaction {
        val entity = transactionRepository.findByKey(key)
        return entityToDto(entity!!)
    }

    override fun findRecent(limit: Int): List<Transaction> {
        val pageable = PageRequest.of(0, limit, Sort.by("date").descending())

        val entities = transactionRepository.findAllByUserId(1, pageable).content // todo: userId from security

        return entities.map {entityToDto(it) }
    }

    override fun filterByDate(startDate: LocalDate, endDate: LocalDate): List<Transaction> {
        val entities = transactionRepository.findFiltered(startDate, endDate, 1) //todo: userId from Security

        return entities.map { entityToDto(it) }
    }

    private fun entityToDto(transactionEntity: TransactionEntity): Transaction {
        val converted = TRANSACTION_MAPPER.convertToDto(
                transactionEntity,
                accountRepository.findById(transactionEntity.accountId).get().key,
        )

        if (transactionEntity.linkedAccountId != null) {
            converted.linkedAccountId = accountRepository.findById(transactionEntity.linkedAccountId).map {
                it.key
            }.orElse(null)
        }

        converted.tags = tagRepository.findAllByTransactionId(transactionEntity.id!!).map {
            it.name
        }.toSet()

        return converted
    }

    override fun save(saveTransactionRequest: SaveTransactionRequest) {

        val savedTransaction = transactionRepository.save(TransactionEntity(
                id = transactionRepository.findByKey(saveTransactionRequest.id)?.id,
                key = saveTransactionRequest.id,
                amount = saveTransactionRequest.amount,
                note = saveTransactionRequest.note,
                date = LocalDateUtil.longToDate(saveTransactionRequest.date),
                typeId = saveTransactionRequest.kind,
                currencyCode = saveTransactionRequest.currency,
                linkedAmount = saveTransactionRequest.linkedAmount,
                linkedCurrencyCode = saveTransactionRequest.linkedCurrency,
                accountId = accountRepository.findByKey(saveTransactionRequest.accountId)?.id!!,
                linkedAccountId = if (saveTransactionRequest.linkedAccountId != null) accountRepository.findByKey(saveTransactionRequest.linkedAccountId)!!.id else null
        ))

        for (tagName in saveTransactionRequest.tags) {
            transactionToTagRepository.save(TransactionToTagEntity(
                    transactionId = savedTransaction.id!!,
                    tagId = tagRepository.findByNameAndUserId(tagName, 1).id!! // todo: user from security
            ))
        }

        accountBalanceService.mutateBalance(savedTransaction.accountId, savedTransaction.currencyCode, savedTransaction.amount)
    }

    override fun deleteByKey(transactionKey: String) {
        transactionRepository.deleteByKey(transactionKey)
    }
}