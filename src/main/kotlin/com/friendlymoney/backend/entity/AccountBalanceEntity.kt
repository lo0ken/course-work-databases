package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "account_balance")
class AccountBalanceEntity (

        @Id
        val id: Int,

        @ManyToOne
        @JoinColumn(name = "account_id")
        val account: AccountEntity,

        @ManyToOne
        @JoinColumn(name = "currency_code")
        val currency: CurrencyEntity,

        val balance: Int
)