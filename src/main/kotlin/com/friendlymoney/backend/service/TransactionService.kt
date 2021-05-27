package com.friendlymoney.backend.service

import com.friendlymoney.backend.controller.request.SaveTransactionRequest
import com.friendlymoney.backend.dto.Transaction
import java.time.LocalDate

interface TransactionService {

    fun findRecent(limit: Int): List<Transaction>

    fun filterByDate(startDate: LocalDate, endDate: LocalDate): List<Transaction>

    fun save(saveTransactionRequest: SaveTransactionRequest)
}