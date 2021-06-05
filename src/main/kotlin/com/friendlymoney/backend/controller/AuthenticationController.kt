package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.LoginRequest
import com.friendlymoney.backend.controller.request.SignUpRequest
import com.friendlymoney.backend.controller.response.LoginResponse
import com.friendlymoney.backend.dto.User
import com.friendlymoney.backend.security.jwt.JwtTokenProvider
import com.friendlymoney.backend.service.UserService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
        private val userService: UserService,
        private val authenticationManager: AuthenticationManager,
        private val jwtTokenProvider: JwtTokenProvider
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password))

        val user = userService. findByUserName(loginRequest.username)!!
        val roles = user.roles
        val token = jwtTokenProvider.createToken(loginRequest.username, roles)

        return LoginResponse(
                user,
                token
        )
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): User {
        return userService.register(signUpRequest);
    }

    @GetMapping("/profile")
    fun profile(): User {
        return userService.findByUserName(SecurityContextHolder.getContext().authentication.name)!!
    }
}