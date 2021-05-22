package com.friendlymoney.backend.service

import com.friendlymoney.backend.controller.request.SaveTransactionRequest

interface TransactionService {

    fun save(saveTransactionRequest: SaveTransactionRequest)
}