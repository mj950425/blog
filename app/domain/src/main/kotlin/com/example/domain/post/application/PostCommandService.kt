package com.example.domain.post.application

import com.example.domain.post.command.CreatePostCommand
import com.example.domain.post.command.PostUpdateCommand
import com.example.domain.post.domain.PostRepository
import com.example.domain.post.toPost
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostCommandService(
    private val postRepository: PostRepository,
) {
    fun createPost(createPostCommand: CreatePostCommand): Long {
        val createdBy = "민준"
        return postRepository.save(createPostCommand.toPost(createdBy))
    }

    fun updatePost(postUpdateCommand: PostUpdateCommand): Long {
        val post = postRepository.findById(postUpdateCommand.postId)
        post.update(postUpdateCommand)
        return postRepository.update(post)
    }

    fun deletePost(id: Long): Long {
        return postRepository.delete(id)
    }
}
