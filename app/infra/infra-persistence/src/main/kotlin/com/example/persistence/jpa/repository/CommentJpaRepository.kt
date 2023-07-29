package com.example.persistence.jpa.repository

import com.example.persistence.jpa.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentJpaRepository : JpaRepository<CommentEntity, Long> {
    fun findAllByPostIdOrderByIdDesc(postId: Long): List<CommentEntity>
}