package com.friendlymoney.backend.service

import com.friendlymoney.backend.dto.AccountGroup

interface AccountGroupService {

    fun getAll(): List<AccountGroup>
}