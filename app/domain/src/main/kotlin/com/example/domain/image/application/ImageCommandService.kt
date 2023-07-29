package com.example.domain.image.application

import com.example.domain.image.domain.ImageRepository
import com.example.domain.post.command.UploadImageCommand
import com.example.domain.post.domain.Image
import com.example.domain.post.domain.ImageUploader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ImageCommandService(
    val imageUploader: ImageUploader,
    val imageRepository: ImageRepository
) {
    fun uploadImage(command: UploadImageCommand): Long {
        val filename = imageUploader.upload(command)

        val image = Image(
            filename = filename,
            originalFilename = command.originalFilename
        )

        return imageRepository.save(image)
    }
}