package com.friendlymoney.backend.repository

import com.friendlymoney.backend.entity.CurrencyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CurrencyRepository: JpaRepository<CurrencyEntity, String> {
}