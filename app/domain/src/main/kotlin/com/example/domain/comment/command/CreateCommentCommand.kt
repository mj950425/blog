package com.example.domain.comment.command

data class CreateCommentCommand(
    val author: String,
    val postId: Long,
    val content: String
)