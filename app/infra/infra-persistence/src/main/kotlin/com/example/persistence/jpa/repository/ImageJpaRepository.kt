package com.example.persistence.jpa.repository

import com.example.persistence.jpa.entity.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageJpaRepository : JpaRepository<ImageEntity, Long> {
}