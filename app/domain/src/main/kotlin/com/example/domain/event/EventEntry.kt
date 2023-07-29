package com.example.domain.event

data class EventEntry(
    val id: Long? = null,
    val type: String,
    val contentType: String,
    val payload: String,
    val createdAt: Long = System.currentTimeMillis()
)