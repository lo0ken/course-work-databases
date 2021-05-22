package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.service.TransactionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(
        private val transactionService: TransactionService
) {

    @PostMapping("/save")
    fun save(@RequestBody saveTransactionRequest: SaveTransactionRequest) {
        transactionService.save(saveTransactionRequest)
        print(saveTransactionRequest)
    }
}