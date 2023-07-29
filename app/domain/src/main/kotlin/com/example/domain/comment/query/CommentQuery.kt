package com.example.domain.comment.query

data class CommentQuery(
    val id: Long,
    val postId: Long,
    val content: String,
    val author: String
)