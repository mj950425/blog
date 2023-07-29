package com.example.ui.dto

import com.example.domain.post.command.CreatePostCommand

data class CreatePostRequest(
    val title: String,
    val content: String,
    val imageId: Long?,
    val category: String,
) {
    fun toCommand(): CreatePostCommand {
        return CreatePostCommand(
            title = title,
            content = content,
            category = category,
            imageId = imageId
        )
    }
}