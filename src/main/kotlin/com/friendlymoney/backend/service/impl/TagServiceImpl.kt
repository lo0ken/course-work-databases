package com.friendlymoney.backend.service.impl

import com.friendlymoney.backend.controller.request.SaveTagRequest
import com.friendlymoney.backend.dto.Tag
import com.friendlymoney.backend.entity.TagEntity
import com.friendlymoney.backend.mapper.TagMapper.Companion.TAG_MAPPER
import com.friendlymoney.backend.repository.TagRepository
import com.friendlymoney.backend.service.TagService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TagServiceImpl(
        private val tagRepository: TagRepository
): TagService {

    override fun getAllByType(typeId: Int): List<Tag> {
        //todo: user from security
        return tagRepository.findAllByTypeIdAndUserId(typeId, 1).map {
            TAG_MAPPER.convertToDto(it)
        }
    }

    override fun save(saveTagRequest: SaveTagRequest) {
        tagRepository.save(TagEntity(
                typeId = saveTagRequest.kind,
                name = saveTagRequest.tag,
                userId = 1 // todo: user from security
        ))
    }
}