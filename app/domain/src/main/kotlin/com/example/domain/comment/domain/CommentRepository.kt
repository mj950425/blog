package com.example.domain.comment.domain

interface CommentRepository {
    fun findById(id: Long): Comment
    fun findAllByPostIdOrderByIdDesc(postId: Long): Comments
    fun save(comment: Comment)
}