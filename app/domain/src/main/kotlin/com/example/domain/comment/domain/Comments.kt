package com.example.domain.comment.domain

class Comments(
    val comments: List<Comment>
){
    init {
        require(comments.map { it.postId }.distinct().size == 1){ throw IllegalArgumentException("알 수 없는 에러")}
    }
}
