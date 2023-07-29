package com.example.persistence.jpa.entity

import com.example.domain.post.domain.Content
import com.example.domain.post.domain.Post
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment

@Entity
@Table(name = "post")
class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Comment("포스팅 ID")
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "category", nullable = false)
    var category: String,

    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "image_id", nullable = true)
    val imageId: Long?,

    @Column(name = "view_count", nullable = false)
    var viewCount: Long = 0
) : BaseEntity() {
    fun toPost(): Post {
        return Post(
            id = this.id!!,
            content = Content(
                title = this.title,
                content = this.content,
                imageId = this.imageId
            ),
            category = this.category,
            createdBy = this.createdBy!!,
            viewCount = this.viewCount,
        )
    }

    companion object {
        fun of(post: Post): PostEntity {
            return PostEntity(
                title = post.content.title,
                content = post.content.content,
                category = post.category,
                imageId = post.content.imageId,
                viewCount = post.viewCount,
            )
        }
    }
}
