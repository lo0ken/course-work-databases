package com.friendlymoney.backend.service

import com.friendlymoney.backend.controller.request.SaveAccountRequest
import com.friendlymoney.backend.dto.Account

interface AccountService {

    fun getAll(): List<Account>

    fun getByKey(key: String): Account

    fun createAccount(saveAccountRequest: SaveAccountRequest): Account

    fun deleteByKey(key: String)
}