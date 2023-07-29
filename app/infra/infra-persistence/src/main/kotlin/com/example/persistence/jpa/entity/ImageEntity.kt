package com.example.persistence.jpa.entity

import com.example.domain.post.domain.Image
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment

@Entity
@Table(name = "image")
class ImageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Comment("이미지 ID")
    var id: Long? = null,

    @Column(name = "file_name", nullable = false)
    @Comment("파일 이름")
    val filename: String,

    @Column(name = "original_file_name", nullable = false)
    @Comment("원본 파일 이름")
    val originalFilename: String
) {
    fun toImage(): Image {
        return Image(
            this.id,
            this.filename,
            this.originalFilename
        )
    }
}