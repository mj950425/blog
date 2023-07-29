package com.example.domain.post.query

data class PostDetailQuery(
    val id: Long? = null,
    val title: String,
    val content: String,
    val filename: String?,
    val viewCount: Long,
    val category: String,
    val createdBy: String
)