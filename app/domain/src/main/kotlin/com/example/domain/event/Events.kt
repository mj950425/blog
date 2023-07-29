package com.example.domain.event

import org.springframework.context.ApplicationEventPublisher

object Events {
    private var publisher: ApplicationEventPublisher? = null
    fun setPublisher(publisher: ApplicationEventPublisher) {
        Events.publisher = publisher
    }

    fun raise(event: Event) {
        if (publisher != null) {
            publisher!!.publishEvent(event)
        }
    }
}