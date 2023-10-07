package com.example.domain.post.command

data class PostUpdateCommand(
    val postId: Long,
    val content: ContentCommand,
    val category: String
)