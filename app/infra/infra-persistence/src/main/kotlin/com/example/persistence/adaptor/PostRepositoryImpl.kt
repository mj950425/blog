package com.example.persistence.adaptor

import com.example.domain.post.domain.Post
import com.example.domain.post.domain.PostRepository
import com.example.domain.post.command.SearchConditionCommand
import com.example.persistence.jpa.entity.PostEntity
import com.example.persistence.jpa.entity.QPostEntity.postEntity
import com.example.persistence.jpa.repository.PostJpaRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class PostRepositoryImpl(
    private val postJpaRepository: PostJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : PostRepository {
    override fun findById(id: Long): Post {
        return postJpaRepository.findById(id)
            .getOrElse {
                throw EntityNotFoundException("[ID:$id] 포스트가 없습니다.")
            }.toPost()
    }

    override fun search(page: Pageable, condition: SearchConditionCommand): Page<Post> {
        val booleanBuilder = BooleanBuilder()

        condition.title?.let {
            booleanBuilder.and(postEntity.title.contains(it))
        }

        val content = jpaQueryFactory.select(postEntity)
            .from(postEntity)
            .where(booleanBuilder)
            .offset(page.offset)
            .limit(page.pageSize.toLong())
            .orderBy(postEntity.createdAt.desc())
            .fetch().map { it.toPost() }

        val count = jpaQueryFactory.select(postEntity.id.countDistinct())
            .from(postEntity)
            .where(booleanBuilder)
            .fetchOne()!!

        return PageableExecutionUtils.getPage(content, page) { count }
    }

    override fun update(post: Post): Long {
        val updatedPost = postJpaRepository.findPostById(post.id!!).apply {
            this.title = post.content.title
            this.content = post.content.content
            this.category = post.category
            this.viewCount = post.viewCount
        }

        return updatedPost.id!!
    }

    override fun save(post: Post): Long {
        return postJpaRepository.save(PostEntity.of(post)).id!!
    }

    override fun delete(id: Long): Long {
        TODO("Not yet implemented")
    }
}