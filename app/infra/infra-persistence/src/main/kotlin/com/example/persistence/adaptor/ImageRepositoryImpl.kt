package com.example.persistence.adaptor

import com.example.domain.image.domain.ImageRepository
import com.example.domain.post.domain.Image
import com.example.persistence.jpa.entity.ImageEntity
import com.example.persistence.jpa.repository.ImageJpaRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrElse

@Repository
class ImageRepositoryImpl(val imageJpaRepository: ImageJpaRepository) : ImageRepository {
    override fun save(image: Image): Long {
        return imageJpaRepository.save(
            ImageEntity(
                filename = image.filename,
                originalFilename = image.originalFilename
            )
        ).id!!
    }

    override fun findByFilename(filename: String): Image {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Image {
        return imageJpaRepository.findById(id).getOrElse { throw IllegalArgumentException() }.toImage()
    }
}