package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.entity.TransactionEntity
import com.friendlymoney.backend.entity.TransactionToTagEntity
import com.friendlymoney.backend.repository.AccountRepository
import com.friendlymoney.backend.repository.TagRepository
import com.friendlymoney.backend.repository.TransactionRepository
import com.friendlymoney.backend.repository.TransactionToTagRepository
import com.friendlymoney.backend.service.TransactionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.ZoneId

@Service
@Transactional
class TransactionServiceImpl(
        private val accountRepository: AccountRepository,
        private val tagRepository: TagRepository,
        private val transactionRepository: TransactionRepository,
        private val transactionToTagRepository: TransactionToTagRepository
): TransactionService {

    override fun save(saveTransactionRequest: SaveTransactionRequest) {

        val savedTransaction = transactionRepository.save(TransactionEntity(
                key = saveTransactionRequest.id,
                amount = saveTransactionRequest.amount,
                note = saveTransactionRequest.note,
                date = LocalDate.ofInstant(saveTransactionRequest.date, ZoneId.systemDefault()),
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
    }
}