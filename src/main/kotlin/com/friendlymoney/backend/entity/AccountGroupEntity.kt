package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account_group")
class AccountGroupEntity (

    @Id
    val code: String,

    val name: String,
)