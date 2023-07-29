package com.example.event

import com.example.domain.event.Event
import com.example.domain.event.EventRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class EventStoreHandler(eventRepository: EventRepository) {
    private val eventRepository: EventRepository

    init {
        this.eventRepository = eventRepository
    }

    @EventListener(Event::class)
    fun handle(event: Event) {
        eventRepository.save(event)
    }
}