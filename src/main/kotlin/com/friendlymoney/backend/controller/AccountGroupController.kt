package com.friendlymoney.backend.controller

import com.friendlymoney.backend.dto.AccountGroup
import com.friendlymoney.backend.service.AccountGroupService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accountGroups")
class AccountGroupController(
        private val accountGroupService: AccountGroupService) {

    @GetMapping
    fun getAll(): List<AccountGroup> {
        return accountGroupService.getAll()
    }
}