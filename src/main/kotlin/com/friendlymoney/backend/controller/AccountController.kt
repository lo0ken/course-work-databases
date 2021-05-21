package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SaveAccountRequest
import com.friendlymoney.backend.controller.response.AccountResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController {

    @GetMapping
    fun getAll(): List<AccountResponse> {
        return listOf(AccountResponse(
          _id = "A3243242",
                name = "asasa",
                group = "cash",
                balance = mapOf(Pair("USD", 444)),
                currencies = listOf("USD")
        ))
    }

    @PostMapping("/save")
    fun save(@RequestBody account: SaveAccountRequest) {

        println("qwe")
    }
}