package com.example.domain.comment.domain

import com.example.common.RegularExpressionUtils.isValidKoreanName

class Comment(
    val id: Long? = null,
    val postId: Long,
    val content: String,
    val author: String
) {


    init {
        require(content.isNotEmpty()) {
            throw IllegalArgumentException("content 는 비어있을 수 없습니다.")
        }
        require(author.isValidKoreanName()) {
            throw IllegalArgumentException("content 는 비어있을 수 없습니다.")
        }
    }
}