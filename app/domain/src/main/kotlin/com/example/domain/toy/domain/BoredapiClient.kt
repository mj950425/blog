package com.example.domain.toy.domain

import com.example.domain.toy.query.ToyQuery

interface ToyClient {
    fun getToy(): ToyQuery
}