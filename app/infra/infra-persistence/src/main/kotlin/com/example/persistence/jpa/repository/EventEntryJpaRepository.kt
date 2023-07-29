package com.example.persistence.jpa.repository

import com.example.persistence.jpa.entity.EventEntryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventEntryJpaRepository : JpaRepository<EventEntryEntity, Long> {
}