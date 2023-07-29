package com.example.persistence.adaptor

import com.example.domain.event.Event
import com.example.domain.event.EventEntry
import com.example.domain.event.EventRepository
import com.example.persistence.exception.PayloadConvertException
import com.example.persistence.jpa.entity.EventEntryEntity
import com.example.persistence.jpa.entity.QEventEntryEntity.eventEntryEntity
import com.example.persistence.jpa.repository.EventEntryJpaRepository
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
class EventEntryRepository(
    private val objectMapper: ObjectMapper,
    private val eventEntryJpaRepository: EventEntryJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : EventRepository {
    override fun save(event: Event) {
        eventEntryJpaRepository.save(
            EventEntryEntity(
                type = event.javaClass.name,
                contentType = "application/json",
                payload = toJson(event)
            )
        )
    }

    override fun get(page: Pageable): Page<EventEntry> {
        val content = jpaQueryFactory.select(eventEntryEntity)
            .from(eventEntryEntity)
            .offset(page.offset)
            .limit(page.pageSize.toLong())
            .fetch().map { it.toDomain() }

        val count = jpaQueryFactory.select(eventEntryEntity.id.countDistinct())
            .from(eventEntryEntity)
            .fetchOne()!!

        return PageableExecutionUtils.getPage(content, page) { count }
    }

    private fun toJson(event: Any): String {
        try {
            return objectMapper.writeValueAsString(event)
        } catch (e: JsonProcessingException) {
            throw PayloadConvertException(e)
        }
    }
}