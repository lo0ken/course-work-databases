package com.friendlymoney.backend.service

import com.friendlymoney.backend.controller.request.SaveTagRequest
import com.friendlymoney.backend.dto.Tag

interface TagService {

    fun getAllByType(typeId: Int): List<Tag>

    fun save(saveTagRequest: SaveTagRequest)
}