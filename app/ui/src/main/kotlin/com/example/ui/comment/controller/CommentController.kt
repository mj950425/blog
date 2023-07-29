package com.example.ui.comment.controller

import com.example.domain.comment.application.CommentCommandService
import com.example.domain.comment.application.CommentQueryService
import com.example.ui.dto.CreateCommentRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comments")
class CommentController(
    val commentCommandService: CommentCommandService
) {
    @PostMapping
    fun create(@RequestBody request: CreateCommentRequest) {
        commentCommandService.create(request.toCommand())
    }
}