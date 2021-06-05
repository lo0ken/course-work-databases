package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.Role
import com.friendlymoney.backend.entity.RoleEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface RoleMapper {
    companion object {
        val ROLE_MAPPER: RoleMapper = Mappers.getMapper(RoleMapper::class.java)
    }

    fun convertToDto(entity: RoleEntity): Role
    fun convertToEntity(dto: Role): RoleEntity
}