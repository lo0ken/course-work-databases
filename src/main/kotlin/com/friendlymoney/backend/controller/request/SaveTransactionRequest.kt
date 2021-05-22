package com.friendlymoney.backend.controller.request

import java.time.Instant


data class SaveTransactionRequest(
        val id: String,
        val accountId: String,
        val amount: Int,
        val date: Instant,
        val kind: Int,
        val currency: String,
        val linkedAccountId: String?,
        val linkedAmount: Int?,
        val linkedCurrency: String?,
        val note: String?,
        val tags: List<String> = emptyList()
)