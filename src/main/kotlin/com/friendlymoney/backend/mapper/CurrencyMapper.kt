package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.Currency
import com.friendlymoney.backend.entity.CurrencyEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface CurrencyMapper {
    companion object {
        val CURRENCY_MAPPER: CurrencyMapper = Mappers.getMapper(CurrencyMapper::class.java)
    }

    fun convertToDto(entity: CurrencyEntity): Currency
    fun convertToEntity(dto: Currency): CurrencyEntity
}