package com.friendlymoney.backend.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tag_type")
class TagTypeEntity (

    @Id
    val id: Int,

    val name: String
)