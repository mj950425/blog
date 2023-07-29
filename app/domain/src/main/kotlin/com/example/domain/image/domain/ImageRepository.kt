package com.example.domain.image.domain

import com.example.domain.post.domain.Image

interface ImageRepository {
    fun save(image: Image):Long

    fun findByFilename(filename: String): Image

    fun findById(id:Long): Image
}