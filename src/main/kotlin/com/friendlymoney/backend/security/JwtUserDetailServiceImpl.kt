package com.friendlymoney.backend.security

import com.friendlymoney.backend.security.jwt.JwtUserFactory
import com.friendlymoney.backend.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class JwtUserDetailServiceImpl(
        private val userService: UserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findByUserName(username)
                ?: throw UsernameNotFoundException("User with username: $username not found")
        return JwtUserFactory.create(user)
    }
}
