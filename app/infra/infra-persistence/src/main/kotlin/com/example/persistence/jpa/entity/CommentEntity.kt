package com.example.persistence.jpa.entity

import com.example.domain.comment.domain.Comment
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "comment")
class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val postId: Long,
    val content: String,
    val author: String
) {
    companion object {
        fun of(comment: Comment): CommentEntity {
            return CommentEntity(
                id = comment.id,
                postId = comment.postId,
                author = comment.author,
                content = comment.content
            )
        }
    }

    fun toDomain(): Comment {
        return Comment(
            id = this.id!!,
            postId = this.postId,
            content = this.content,
            author = this.author
        )
    }
}