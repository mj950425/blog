package com.example.domain.post.domain

import com.example.common.FileUtils

class Image(
    val id: Long? = null,
    val filename: String,
    val originalFilename: String
) {
    init {
        require(filename.isNotEmpty()) {
            throw IllegalArgumentException("파일 이름에는 빈 값이 올 수 없습니다.")
        }

        val extension = FileUtils.getExtension(originalFilename)

        require(extension == "png" || extension == "jpg" || extension == "jpeg") {
            throw IllegalArgumentException("확장자가 png 또는 jpg 이어야 합니다.")
        }
    }
}