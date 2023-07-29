package com.example.domain.post.application

import com.example.domain.post.command.CreatePostCommand
import com.example.domain.post.command.UploadImageCommand
import com.example.domain.post.domain.ImageUploader
import com.example.domain.post.domain.Post
import com.example.domain.post.domain.PostRepository
import com.example.domain.post.toPost
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.net.URLEncoder
import java.nio.file.Files
import java.nio.file.Paths
import java.util.UUID

@Service
@Transactional
class PostCommandService(
    private val postRepository: PostRepository,
) {
    fun createPost(createPostCommand: CreatePostCommand): Long {
        val createdBy = "민준"
        return postRepository.save(createPostCommand.toPost(createdBy))
    }

    fun updatePost(post: Post): Long {
        return postRepository.update(post)
    }

    fun deletePost(id: Long): Long {
        return postRepository.delete(id)
    }
}
