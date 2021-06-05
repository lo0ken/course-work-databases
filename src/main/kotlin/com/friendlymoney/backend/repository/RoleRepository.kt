package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<RoleEntity, Int> {
    fun findByName(name: String): RoleEntity
}