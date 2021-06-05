package com.friendlymoney.backend.dto

data class User(
        val username: String,
        val password: String,
        val phone: String,
        val email: String,
        val roles: List<Role>,

        val id: Int? = null
)