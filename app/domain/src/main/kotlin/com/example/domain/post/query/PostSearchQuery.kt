package com.example.domain.post.query

data class PostSearchQuery(
    val id: Long? = null,
    val title: String,
    val content: String,
    val createdBy: String
)