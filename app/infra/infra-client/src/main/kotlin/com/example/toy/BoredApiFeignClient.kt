package com.example.toy

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "bored-api",
    url = "\${toy.bored-api.host}",
    path = "/api/breeds/image/random"
)
interface BoredApiFeignClient {

    @GetMapping
    fun getNextActivity(): ToyDto
}

data class ToyDto(
    val message: String,
    val status: String
)