package com.example.persistence.jpa.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "datetime")
    val createdAt: LocalDateTime? = null

    @Column(name = "created_by", nullable = false, updatable = false)
    var createdBy: String? = "민준"

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, updatable = true, columnDefinition = "datetime")
    var updatedAt: LocalDateTime? = null
}