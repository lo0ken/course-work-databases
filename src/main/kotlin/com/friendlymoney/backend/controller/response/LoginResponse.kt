package com.friendlymoney.backend.controller.response

import com.friendlymoney.backend.dto.User

data class LoginResponse(
        val user: User,
        val token: String
)