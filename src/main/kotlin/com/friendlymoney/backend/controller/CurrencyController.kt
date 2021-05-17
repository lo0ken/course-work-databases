package com.friendlymoney.backend.controller

import com.friendlymoney.backend.dto.Currency
import com.friendlymoney.backend.service.CurrencyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/currencies")
class CurrencyController(
        private val currencyService: CurrencyService) {

    @GetMapping
    fun getAll(): List<Currency> {
        return currencyService.getAll()
    }
}