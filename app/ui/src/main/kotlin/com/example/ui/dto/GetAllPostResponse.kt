package com.example.ui.dto

import com.example.domain.post.query.PostSearchQuery
import org.springframework.data.domain.Page

data class SearchPostsResponse(
    val posts: List<GetPostResponse> = listOf(GetPostResponse())
) {
    companion object {
        fun of(
            posts: Page<PostSearchQuery>
        ): SearchPostsResponse {
            return SearchPostsResponse(
                posts = posts.content.map {
                    GetPostResponse(
                        id = it.id!!,
                        title = it.title,
                        createdBy = it.createdBy
                    )
                }
            )
        }
    }
}

data class GetPostResponse(
    val id: Long = 3L,
    val title: String = "이것은 제목입니다",
    val createdBy: String = "박재헌"
)
