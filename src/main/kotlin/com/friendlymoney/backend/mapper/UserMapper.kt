package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.User
import com.friendlymoney.backend.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface UserMapper {
    companion object {
        val USER_MAPPER: UserMapper = Mappers.getMapper(UserMapper::class.java)
    }

    fun convertToDto(entity: UserEntity): User
    fun convertToEntity(dto: User): UserEntity
}