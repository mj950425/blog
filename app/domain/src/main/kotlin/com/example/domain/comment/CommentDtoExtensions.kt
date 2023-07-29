package com.example.domain.comment

import com.example.domain.comment.command.CreateCommentCommand
import com.example.domain.comment.domain.Comment
import com.example.domain.comment.domain.Comments
import com.example.domain.comment.query.CommentQuery

fun CreateCommentCommand.toComment(): Comment {
    return Comment(
        author = this.author,
        postId = this.postId,
        content = this.content
    )
}

fun Comments.toQuery(): List<CommentQuery> {
    return this.comments.map {
        CommentQuery(
            id = it.id!!,
            postId = it.postId,
            content = it.content,
            author = it.author
        )
    }
}