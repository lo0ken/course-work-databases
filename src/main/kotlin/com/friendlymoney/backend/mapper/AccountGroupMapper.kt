package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.AccountGroup
import com.friendlymoney.backend.entity.AccountGroupEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface AccountGroupMapper {
    companion object {
        val ACCOUNT_GROUP_MAPPER: AccountGroupMapper = Mappers.getMapper(AccountGroupMapper::class.java)
    }

    fun convertToDto(entity: AccountGroupEntity): AccountGroup
    fun convertToEntity(dto: AccountGroup): AccountGroupEntity
}