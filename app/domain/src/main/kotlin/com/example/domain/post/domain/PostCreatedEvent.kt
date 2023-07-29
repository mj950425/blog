package com.example.domain.post.domain

import com.example.domain.event.Event

data class PostCreatedEvent(
    val title: String
) : Event()