package com.example.domain.event

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface EventRepository {
    fun save(event: Event)
    fun get(page: Pageable): Page<EventEntry>
}