package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.Tag
import com.friendlymoney.backend.entity.TagEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface TagMapper {
    companion object {
        val TAG_MAPPER: TagMapper = Mappers.getMapper(TagMapper::class.java)
    }

    fun convertToDto(entity: TagEntity): Tag
}