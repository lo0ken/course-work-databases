package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.TransactionEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface TransactionRepository: JpaRepository<TransactionEntity, Int> {

    @Query("select t from TransactionEntity t join AccountEntity a on t.accountId = a.id where a.userId = :userId")
    fun findAllByUserId(userId: Int, pageable: Pageable): Page<TransactionEntity>

    fun findByKey(key: String): TransactionEntity?


    @Query(value = "select * from getTransactionFiltered(:startDate, :endDate, :userId)", nativeQuery = true)
    fun findFiltered(@Param("startDate") startDate: LocalDate,
                     @Param("endDate") endDate: LocalDate,
                     @Param("userId") userId: Int
    ): List<TransactionEntity>

    fun deleteByKey(key: String)
}