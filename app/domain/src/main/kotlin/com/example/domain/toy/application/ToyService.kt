package com.example.domain.toy.application

import com.example.domain.toy.domain.ToyClient
import com.example.domain.toy.query.ToyQuery
import org.springframework.stereotype.Service

@Service
class ToyService(
    private val toyClient: ToyClient
) {

    fun getToy(): ToyQuery {
        return toyClient.getToy()
    }
}