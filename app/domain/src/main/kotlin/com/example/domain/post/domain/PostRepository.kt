package com.example.domain.post.domain

import com.example.domain.post.command.SearchConditionCommand
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface PostRepository {
    fun findById(id: Long): Post
    fun search(page: Pageable, condition: SearchConditionCommand): Page<Post>
    fun update(post: Post): Long
    fun save(post: Post): Long
    fun delete(id: Long): Long
}