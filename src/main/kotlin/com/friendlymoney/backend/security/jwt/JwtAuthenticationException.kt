package com.friendlymoney.backend.security.jwt

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class JwtAuthenticationException(msg: String) : AuthenticationException(msg)