package com.example.ui.dto

import com.example.domain.comment.command.CreateCommentCommand

data class CreateCommentRequest(
    val author: String,
    val postId: Long,
    val content: String
) {
    fun toCommand(): CreateCommentCommand {
        return CreateCommentCommand(
            author = this.author,
            postId = this.postId,
            content = this.content
        )
    }
}