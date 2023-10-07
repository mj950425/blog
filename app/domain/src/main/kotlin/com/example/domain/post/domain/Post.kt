package com.example.domain.post.domain

import com.example.domain.post.command.PostUpdateCommand

class Post(
    val id: Long? = null,
    var content: Content,
    var category: String,
    var viewCount: Long,
    val createdBy: String
) {
    fun increaseViewCount() {
        this.viewCount++
    }

    fun update(postUpdateCommand: PostUpdateCommand) {
        this.content = Content(
            title = postUpdateCommand.content.title,
            content = postUpdateCommand.content.content,
            imageId = postUpdateCommand.content.imageId
        )
        this.category = postUpdateCommand.category

        validate()
    }

    private fun validate() {
        require(this.content.title.isNotEmpty()) {
            throw IllegalArgumentException("제목은 비어있을 수 없습니다.")
        }

        require(this.content.content.isNotEmpty()) {
            throw IllegalArgumentException("컨텐츠는 비어있을 수 없습니다.")
        }
    }
}