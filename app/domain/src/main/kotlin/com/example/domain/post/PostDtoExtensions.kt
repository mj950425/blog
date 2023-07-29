package com.example.domain.post

import com.example.domain.post.command.CreatePostCommand
import com.example.domain.post.domain.Content
import com.example.domain.post.domain.Post
import com.example.domain.post.query.PostDetailQuery

fun Post.toDetailQuery(filename: String?): PostDetailQuery {
    return PostDetailQuery(
        id = this.id,
        title = this.content.title,
        content = this.content.content,
        category = this.category,
        viewCount = this.viewCount,
        filename = filename,
        createdBy = this.createdBy
    )
}

fun CreatePostCommand.toPost(createdBy: String): Post {
    return Post(
        content = Content(
            title = this.title,
            content = this.content,
            imageId = this.imageId
        ),
        category = this.category,
        createdBy = createdBy,
        viewCount = 0
    )
}