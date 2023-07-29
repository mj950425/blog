package com.example.domain.comment.application

import com.example.domain.comment.command.CreateCommentCommand
import com.example.domain.comment.domain.CommentRepository
import com.example.domain.comment.toComment
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentCommandService(
    private val commentRepository: CommentRepository
) {
    fun create(command: CreateCommentCommand) {
        val comment = command.toComment()
        commentRepository.save(comment)
    }
}