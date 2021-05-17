package com.friendlymoney.backend.dto

data class Currency(
        val code: String,
        val name: String,
        val symbol: String,
        val exp: Int,
        val flag: String
)