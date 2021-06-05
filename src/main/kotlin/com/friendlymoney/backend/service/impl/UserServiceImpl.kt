package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SignUpRequest
import com.friendlymoney.backend.dto.User
import com.friendlymoney.backend.entity.UserEntity
import com.friendlymoney.backend.enums.RoleEnum
import com.friendlymoney.backend.mapper.UserMapper
import com.friendlymoney.backend.repository.RoleRepository
import com.friendlymoney.backend.repository.UserRepository
import com.friendlymoney.backend.service.UserService
import lombok.extern.slf4j.Slf4j
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Slf4j
@Service
class UserServiceImpl(
        private val userRepository: UserRepository,
        private val roleRepository: RoleRepository,
        private val passwordEncoder: BCryptPasswordEncoder): UserService {

    override fun getCurrentUserId(): Int {
        val username = SecurityContextHolder.getContext().authentication.name!!

        return userRepository.findByUsername(username)?.id!!
    }

    override fun findByUserName(username: String): User? {
        val user = userRepository.findByUsername(username)

        if (user != null) {
            return UserMapper.USER_MAPPER.convertToDto(user)
        }
        return null
    }

    override fun register(signUpRequest: SignUpRequest): User {
        val userRole = roleRepository.findByName(RoleEnum.USER.name)

        val userEntity = UserEntity(
                username = signUpRequest.username,
                password = passwordEncoder.encode(signUpRequest.password),
                phone = signUpRequest.phone,
                email = signUpRequest.email,
                roles = Collections.singletonList(userRole)
        )

        val newUser = userRepository.save(userEntity)
        return UserMapper.USER_MAPPER.convertToDto(newUser)
    }
}