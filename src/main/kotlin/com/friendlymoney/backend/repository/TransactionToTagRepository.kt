package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.TransactionToTagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionToTagRepository: JpaRepository<TransactionToTagEntity, Int> {

    fun deleteAllByTransactionId(transactionId: Int)
}