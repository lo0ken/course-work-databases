package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "account")
class AccountEntity (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        val key: String,

        val name: String,

        @ManyToOne
        @JoinColumn(name = "group_code")
        val group: AccountGroupEntity,

        val userId: Int
)


