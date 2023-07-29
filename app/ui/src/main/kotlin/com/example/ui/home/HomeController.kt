package com.example.ui.home

import com.example.domain.post.application.PostQueryService
import com.example.domain.toy.application.ToyService
import com.example.ui.dto.SearchConditionRequest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    val postQueryService: PostQueryService,
    val toyService: ToyService
) {
    @GetMapping("/")
    fun home(model: Model, @PageableDefault(page = 0, size = 5) pageable: Pageable): String {
        val sort = Sort.by(Sort.Order.desc("createdAt"))
        val result =
            postQueryService.searchPosts(
                PageRequest.of(pageable.pageNumber, pageable.pageSize, sort),
                SearchConditionRequest().toCommand()
            )

        model.addAttribute("posts", result.content)
        model.addAttribute("size", pageable.pageSize)
        model.addAttribute("page", pageable.pageNumber + 1)
        model.addAttribute("totalPages", result.totalPages)

        val toy = toyService.getToy()
        model.addAttribute("toy", toy.message)
        return "/page/home"
    }
}