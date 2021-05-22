package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SaveAccountRequest
import com.friendlymoney.backend.dto.Account
import com.friendlymoney.backend.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
        private val accountService: AccountService
) {

    @GetMapping
    fun getAll(): List<Account> {
        return accountService.getAll()
    }

    @PostMapping("/save")
    fun save(@RequestBody account: SaveAccountRequest): Account {
        return accountService.createAccount(account)
    }
}