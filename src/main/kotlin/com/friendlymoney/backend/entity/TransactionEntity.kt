package com.friendlymoney.backend.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "transaction")
class TransactionEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val amount: Int,

    val note: String?,

    val date: LocalDate,

    val typeId: Int,

    val currencyCode: String,

    val accountId: Int,

    val linkedAccountId: Int?,

    val linkedAmount: Int?,

    val linkedCurrencyCode: String?,

    val key: String
)