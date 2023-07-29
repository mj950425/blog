package com.example.persistence.jpa.entity

import com.example.domain.event.EventEntry
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "event_entry")
class EventEntryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val type: String,
    val contentType: String,
    val payload: String
) : BaseEntity() {

    fun toDomain(): EventEntry {
        return EventEntry(
            id = this.id,
            type = this.type,
            contentType = this.contentType,
            payload = this.payload
        )
    }
}