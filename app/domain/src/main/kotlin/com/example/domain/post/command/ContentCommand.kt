package com.example.domain.post.command

data class ContentCommand(
    val title: String,
    val content: String,
    val imageId: Long? = null
)
