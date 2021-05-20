package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.AccountGroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountGroupRepository: JpaRepository<AccountGroupEntity, String> {
}