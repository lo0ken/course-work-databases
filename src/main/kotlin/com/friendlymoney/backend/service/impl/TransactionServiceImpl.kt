package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.entity.TransactionEntity
import com.friendlymoney.backend.entity.TransactionToTagEntity
import com.friendlymoney.backend.repository.AccountRepository
import com.friendlymoney.backend.repository.TagRepository
import com.friendlymoney.backend.repository.TransactionRepository
import com.friendlymoney.backend.repository.TransactionToTagRepository
import com.friendlymoney.backend.service.AccountBalanceService
import com.friendlymoney.backend.service.TransactionService
import com.friendlymoney.backend.util.LocalDateUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TransactionServiceImpl(
        private val accountBalanceService: AccountBalanceService,
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
}