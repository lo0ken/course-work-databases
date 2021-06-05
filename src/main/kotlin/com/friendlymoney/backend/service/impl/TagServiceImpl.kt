package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveTagRequest
import com.friendlymoney.backend.dto.Tag
import com.friendlymoney.backend.entity.TagEntity
import com.friendlymoney.backend.mapper.TagMapper.Companion.TAG_MAPPER
import com.friendlymoney.backend.repository.TagRepository
import com.friendlymoney.backend.service.TagService
import com.friendlymoney.backend.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TagServiceImpl(
        private val userService: UserService,
        private val tagRepository: TagRepository
): TagService {

    override fun getAllByType(typeId: Int): List<Tag> {
        return tagRepository.findAllByTypeIdAndUserId(typeId, userService.getCurrentUserId()).map {
            TAG_MAPPER.convertToDto(it)
        }
    }

    override fun save(saveTagRequest: SaveTagRequest) {
        tagRepository.save(TagEntity(
                typeId = saveTagRequest.kind,
                name = saveTagRequest.tag,
                userId = userService.getCurrentUserId()
        ))
    }
}