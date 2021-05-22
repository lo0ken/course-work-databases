package com.friendlymoney.backend.controller

import com.friendlymoney.backend.controller.request.SaveTagRequest
import com.friendlymoney.backend.dto.Tag
import com.friendlymoney.backend.service.TagService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class TagController(
        private val tagService: TagService
) {

    @GetMapping
    fun getAllByType(@RequestParam typeId: Int): List<Tag> {
        return tagService.getAllByType(typeId)
    }

    @PostMapping("/save")
    fun save(@RequestBody saveTagRequest: SaveTagRequest) {
        tagService.save(saveTagRequest)
    }
}