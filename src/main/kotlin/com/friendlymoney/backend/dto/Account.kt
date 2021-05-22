package com.friendlymoney.backend.dto

data class Account(
        val _id: String,
        val name: String,
        val group: String,
        val balance: Map<String, Int>,
        val currencies: Set<String>
)