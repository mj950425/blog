package com.example.domain.post.domain

import com.example.domain.post.command.UploadImageCommand

interface ImageUploader {
    fun upload(command: UploadImageCommand): String
}