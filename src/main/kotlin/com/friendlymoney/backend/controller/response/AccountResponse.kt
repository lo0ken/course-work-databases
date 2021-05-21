package com.friendlymoney.backend.controller.response

data class AccountResponse(
        val _id: String,
        val name: String,
        val group: String,
        val balance: Map<String, Int>,
        val currencies: List<String>
)