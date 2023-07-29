package com.example.persistence.adaptor

import com.example.domain.comment.domain.Comment
import com.example.domain.comment.domain.CommentRepository
import com.example.domain.comment.domain.Comments
import com.example.persistence.jpa.entity.CommentEntity
import com.example.persistence.jpa.repository.CommentJpaRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrElse

@Repository
class CommentRepositoryImpl(
    val commentJpaRepository: CommentJpaRepository
) : CommentRepository {
    override fun findById(id: Long): Comment {
        return commentJpaRepository.findById(id)
            .getOrElse {
                throw EntityNotFoundException("[ID:$id] 존재하지않는 코멘트입니다.")
            }.toDomain()
    }

    override fun findAllByPostIdOrderByIdDesc(postId: Long): Comments {
        return Comments(commentJpaRepository.findAllByPostIdOrderByIdDesc(postId).map { it.toDomain() })
    }

    override fun save(comment: Comment) {
        commentJpaRepository.save(CommentEntity.of(comment))
    }
}