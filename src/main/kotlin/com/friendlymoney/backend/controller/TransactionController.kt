package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.dto.Transaction
import com.friendlymoney.backend.service.TransactionService
import com.friendlymoney.backend.util.LocalDateUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(
        private val transactionService: TransactionService
) {

    @GetMapping("/recent")
    fun loadRecent(@RequestParam limit: Int): List<Transaction> {
        return transactionService.findRecent(limit)
    }

    @GetMapping
    fun loadFiltered(
            @RequestParam startDate: Long,
            @RequestParam endDate: Long
    ): List<Transaction> {
        return transactionService.filterByDate(
                LocalDateUtil.longToDate(startDate),
                LocalDateUtil.longToDate(endDate),
        )
    }

    @PostMapping("/save")
    fun save(@RequestBody saveTransactionRequest: SaveTransactionRequest): SaveTransactionRequest {
        transactionService.save(saveTransactionRequest)
        return saveTransactionRequest
    }
}