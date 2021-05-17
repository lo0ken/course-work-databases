package com.friendlymoney.backend.service

import com.friendlymoney.backend.dto.Currency

interface CurrencyService {

    fun getAll(): List<Currency>
}