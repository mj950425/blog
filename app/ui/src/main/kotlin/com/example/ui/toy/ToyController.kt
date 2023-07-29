package com.example.ui.toy

import com.example.domain.toy.application.ToyService
import com.example.domain.toy.query.ToyQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ToyController(val toyService: ToyService) {
    @GetMapping("/toy")
    fun test(): ToyQuery {
        return toyService.getToy()
    }
}