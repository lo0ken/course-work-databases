package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "currency")
class CurrencyEntity (

    @Id
    val code: String,

    val name: String,

    val symbol: String,

    val exp: Int,

    val flag: String
)