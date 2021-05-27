package com.friendlymoney.backend.dto

data class Transaction (
        val _id: String,
        val kind: Int,
        val currency: String,
        val amount: Int,
        val accountId: String,
        val date: String
)