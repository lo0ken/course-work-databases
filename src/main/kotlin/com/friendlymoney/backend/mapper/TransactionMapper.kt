package com.friendlymoney.backend.mapper

import com.friendlymoney.backend.dto.Transaction
import com.friendlymoney.backend.entity.TransactionEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

@Mapper
interface TransactionMapper {
    companion object {
        val TRANSACTION_MAPPER: TransactionMapper = Mappers.getMapper(TransactionMapper::class.java)
    }

    @Mappings(
            Mapping(target = "_id", source = "entity.key"),
            Mapping(target = "kind", source = "entity.typeId"),
            Mapping(target = "currency", source = "entity.currencyCode"),
            Mapping(target = "accountId", source = "accountId"),
    )
    fun convertToDto(entity: TransactionEntity, accountId: String): Transaction
}