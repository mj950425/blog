package com.example.domain.image.application

import com.example.domain.image.domain.ImageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ImageQueryService(private val imageRepository: ImageRepository) {
    fun getFilenameById(id: Long): String {
        return imageRepository.findById(id).filename
    }
}