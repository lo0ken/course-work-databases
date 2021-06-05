package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SignUpRequest
import com.friendlymoney.backend.dto.User
import com.friendlymoney.backend.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
        private val userService: UserService,
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): User {
        return userService.register(signUpRequest);
    }

    @GetMapping("/profile")
    fun profile(): String {
        return "qweqwe";
    }
}