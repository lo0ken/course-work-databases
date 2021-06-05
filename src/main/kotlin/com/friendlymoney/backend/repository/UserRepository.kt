package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?
}