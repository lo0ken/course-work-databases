package com.friendlymoney.backend.service

import com.friendlymoney.backend.controller.request.SignUpRequest
import com.friendlymoney.backend.dto.User

interface UserService {

    fun findByUserName(username: String): User?

    fun register(signUpRequest: SignUpRequest): User
}