package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.dto.Currency
import com.friendlymoney.backend.mapper.CurrencyMapper.Companion.CURRENCY_MAPPER
import com.friendlymoney.backend.repository.CurrencyRepository
import com.friendlymoney.backend.service.CurrencyService
import org.springframework.stereotype.Service

@Service
class CurrencyServiceImpl(
        private val currencyRepository: CurrencyRepository): CurrencyService {

    override fun getAll(): List<Currency> {
        return currencyRepository.findAll()
                .map { CURRENCY_MAPPER.convertToDto(it) }
    }
}