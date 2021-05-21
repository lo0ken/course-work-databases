package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "account")
class AccountEntity (

        @Id
        val id: Int,

        val key: String,

        val name: String,

        @ManyToOne
        @JoinColumn(name = "group_code")
        val group: AccountGroupEntity,

        @OneToMany(mappedBy = "account")
        val balance: List<AccountBalanceEntity>
)


