package com.example.toy

import com.example.domain.toy.domain.ToyClient
import com.example.domain.toy.query.ToyQuery
import org.springframework.stereotype.Component

@Component
class ToyAdapter(
    private val boredApiFeignClient: BoredApiFeignClient
) : ToyClient {
    override fun getToy(): ToyQuery {
        val res = boredApiFeignClient.getNextActivity()
        return ToyQuery(
            message = res.message,
            status = res.status
        )
    }
}