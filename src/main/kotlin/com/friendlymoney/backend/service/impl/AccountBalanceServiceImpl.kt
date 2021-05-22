package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.entity.AccountBalanceEntity
import com.friendlymoney.backend.repository.AccountBalanceRepository
import com.friendlymoney.backend.service.AccountBalanceService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountBalanceServiceImpl(
        private val accountBalanceRepository: AccountBalanceRepository
): AccountBalanceService {

    override fun getBalanceMapByAccountId(accountId: Int): Map<String, Int> {
        val balanceEntities = accountBalanceRepository.findAllByAccountId(accountId)

        return balanceEntities.associateBy({it.currencyCode}, {it.balance})
    }

    override fun saveAccountBalance(accountId: Int, balanceMap: Map<String, Int>) {
        for ((currencyCode, balance) in balanceMap) {
            val entity = AccountBalanceEntity(
                    currencyCode = currencyCode,
                    balance = balance,
                    accountId = accountId
            )

            accountBalanceRepository.save(entity)
        }
    }
}