package com.example.domain.post.command

data class CreatePostCommand(
    val title: String,
    val content: String,
    val category: String,
    val imageId: Long?
)