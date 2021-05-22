package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.TagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository: JpaRepository<TagEntity, Int> {

    fun findAllByTypeIdAndUserId(typeId: Int, userId: Int): List<TagEntity>

    fun findByNameAndUserId(name: String, userId: Int): TagEntity
}