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


    @Query(
            "select distinct t.* from transaction t " +
                    "join account acc on t.account_id = acc.id " +
                    "join transaction_tag tt on t.id = tt.transaction_id " +
                    "join tag on tt.tag_id = tag.id " +
                    "where acc.user_id = :userId " +
                    "and t.date >= :startDate " +
                    "and t.date <= :endDate",
            nativeQuery = true
    )
    fun findFiltered(@Param("startDate") startDate: LocalDate,
                     @Param("endDate") endDate: LocalDate,
                     userId: Int
    ): List<TransactionEntity>
}