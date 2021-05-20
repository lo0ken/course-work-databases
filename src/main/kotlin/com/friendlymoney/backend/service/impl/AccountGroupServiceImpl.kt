package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.dto.AccountGroup
import com.friendlymoney.backend.mapper.AccountGroupMapper.Companion.ACCOUNT_GROUP_MAPPER
import com.friendlymoney.backend.repository.AccountGroupRepository
import com.friendlymoney.backend.service.AccountGroupService
import org.springframework.stereotype.Service

@Service
class AccountGroupServiceImpl(
        private val accountGroupRepository: AccountGroupRepository): AccountGroupService {

    override fun getAll(): List<AccountGroup> {
        return accountGroupRepository.findAll()
                .map { ACCOUNT_GROUP_MAPPER.convertToDto(it) }
    }
}