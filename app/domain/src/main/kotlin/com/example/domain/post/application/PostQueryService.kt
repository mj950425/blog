package com.example.domain.post.application

import com.example.domain.image.application.ImageQueryService
import com.example.domain.post.domain.PostRepository
import com.example.domain.post.query.PostDetailQuery
import com.example.domain.post.query.PostSearchQuery
import com.example.domain.post.command.SearchConditionCommand
import com.example.domain.post.toDetailQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PostQueryService(
    private val postRepository: PostRepository,
    private val postCommandService: PostCommandService,
    private val imageQueryService: ImageQueryService
) {
    fun getPostDetail(id: Long): PostDetailQuery {
        val post = postRepository.findById(id)

        val filename = post.content.imageId?.let {
            imageQueryService.getFilenameById(it)
        }

        post.increaseViewCount()

        postCommandService.updatePost(post)

        return post.toDetailQuery(filename)
    }

    fun searchPosts(page: Pageable, condition: SearchConditionCommand): Page<PostSearchQuery> {
        return postRepository.search(page, condition).map {
            PostSearchQuery(
                it.id,
                it.content.title,
                it.content.content.substring(0, it.content.content.length.coerceAtMost(50)),
                it.createdBy
            )
        }
    }
}