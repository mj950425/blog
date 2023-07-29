package com.example.domain.post.domain

class Post(
    val id: Long? = null,
    val content: Content,
    val category: String,
    var viewCount: Long,
    val createdBy: String
) {
    init {
    }

    fun increaseViewCount() {
        this.viewCount++
    }
}