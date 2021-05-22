package com.friendlymoney.backend.service

interface AccountBalanceService {

    fun getBalanceMapByAccountId(accountId: Int): Map<String, Int>

    fun saveAccountBalance(accountId: Int, balanceMap: Map<String, Int>)
}