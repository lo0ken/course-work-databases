package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.TagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TagRepository: JpaRepository<TagEntity, Int> {

    fun findAllByTypeIdAndUserId(typeId: Int, userId: Int): List<TagEntity>

    fun findByNameAndUserId(name: String, userId: Int): TagEntity

    @Query("select tag.* from tag " +
            "join transaction_tag tt on tag.id = tt.tag_id " +
            "where tt.transaction_id = :transactionId" , nativeQuery = true)
    fun findAllByTransactionId(transactionId: Int): List<TagEntity>
}