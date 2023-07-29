package com.example.domain.comment.application

import com.example.domain.comment.domain.Comment
import com.example.domain.comment.domain.CommentRepository
import com.example.domain.comment.query.CommentQuery
import com.example.domain.comment.toQuery
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentQueryService(
    private val commentRepository: CommentRepository
) {
    fun getById(id: Long): Comment {
        return commentRepository.findById(id)
    }

    fun getAllByPostId(postId: Long): List<CommentQuery> {
        val comments = commentRepository.findAllByPostIdOrderByIdDesc(postId)
        return comments.toQuery()
    }
}