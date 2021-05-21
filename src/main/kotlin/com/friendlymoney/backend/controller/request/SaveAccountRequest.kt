package com.friendlymoney.backend.controller.request


data class SaveAccountRequest (
        val id: String,
        val name: String,
        val group: String,
        val balance: Map<String, Int>
)