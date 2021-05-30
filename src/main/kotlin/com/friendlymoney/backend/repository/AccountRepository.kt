package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<AccountEntity, Int> {

    fun findAllByUserId(userId: Int): List<AccountEntity>

    fun findByKey(key: String): AccountEntity?

    fun deleteByKey(key: String)
}