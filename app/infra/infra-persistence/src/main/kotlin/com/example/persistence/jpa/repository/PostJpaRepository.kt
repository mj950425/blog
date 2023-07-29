package com.example.persistence.jpa.repository

import com.example.persistence.jpa.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostJpaRepository : JpaRepository<PostEntity, Long> {
    fun findPostById(id: Long): PostEntity
}