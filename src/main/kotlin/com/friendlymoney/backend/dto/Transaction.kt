package com.friendlymoney.backend.dto

data class Transaction (
        val _id: String,
        val kind: Int,
        val currency: String,
        val amount: Int,
        val accountId: String,
        val date: String,
        val note: String?,
        var tags: Set<String>? = emptySet(),
        var linkedAccountId: String?,
        val linkedAmount: Int?,
        val linkedCurrency: String?
)