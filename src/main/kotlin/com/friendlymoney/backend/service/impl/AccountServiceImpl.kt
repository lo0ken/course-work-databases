package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveAccountRequest
import com.friendlymoney.backend.dto.Account
import com.friendlymoney.backend.entity.AccountEntity
import com.friendlymoney.backend.repository.AccountGroupRepository
import com.friendlymoney.backend.repository.AccountRepository
import com.friendlymoney.backend.service.AccountBalanceService
import com.friendlymoney.backend.service.AccountService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountServiceImpl(
        private val accountBalanceService: AccountBalanceService,
        private val accountGroupRepository: AccountGroupRepository,
        private val accountRepository: AccountRepository
): AccountService {

    override fun getAll(): List<Account> {
        val accountEntities = accountRepository.findAllByUserId(
                1 // todo: call security service to get id of current user
        )

        return accountEntities.map {
            val balanceMap = accountBalanceService.getBalanceMapByAccountId(it.id!!)
            Account(
                    _id = it.key,
                    name = it.name,
                    group = it.group.code,
                    balance = balanceMap,
                    currencies = balanceMap.keys
            )
        }
    }

    override fun getByKey(key: String): Account {
        val accountEntity = accountRepository.findByKey(key)
        val balanceMap = accountBalanceService.getBalanceMapByAccountId(accountEntity!!.id!!)
        return Account(
                _id = accountEntity.key,
                name = accountEntity.name,
                group = accountEntity.group.code,
                balance = balanceMap,
                currencies = balanceMap.keys
        )
    }


    override fun createAccount(saveAccountRequest: SaveAccountRequest): Account {
        val accountGroup = accountGroupRepository.findByCode(saveAccountRequest.group)

        val account = AccountEntity(
                id = accountRepository.findByKey(saveAccountRequest.id)?.id,
                key = saveAccountRequest.id,
                name = saveAccountRequest.name,
                group = accountGroup,
                userId = 1 //todo: call security service to get id of current user
        )

        val savedAccount = accountRepository.save(account)

        accountBalanceService.saveAccountBalance(savedAccount.id!!, saveAccountRequest.balance)

        return Account(
                _id = savedAccount.key,
                name = savedAccount.name,
                group = savedAccount.group.code,
                balance = saveAccountRequest.balance,
                currencies = saveAccountRequest.balance.keys
        )
    }

    override fun deleteByKey(key: String) {
        accountRepository.deleteByKey(key)
    }
}