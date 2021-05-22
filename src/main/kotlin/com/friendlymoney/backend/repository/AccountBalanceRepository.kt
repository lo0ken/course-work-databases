package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.AccountBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountBalanceRepository: JpaRepository<AccountBalanceEntity, Int> {

    fun findAllByAccountId(accountId: Int): List<AccountBalanceEntity>

    fun findByAccountIdAndCurrencyCode(accountId: Int, currencyCode: String): AccountBalanceEntity?
}