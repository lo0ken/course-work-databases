package com.friendlymoney.backend.controller.request

data class SaveTagRequest(
        val kind: Int,
        val tag: String,
)