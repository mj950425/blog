package com.example.ui.post.controller

import com.example.common.FileUtils
import com.example.domain.comment.application.CommentQueryService
import com.example.domain.image.application.ImageCommandService
import com.example.domain.post.application.PostCommandService
import com.example.domain.post.application.PostQueryService
import com.example.domain.post.command.UploadImageCommand
import com.example.ui.dto.BaseResponse
import com.example.ui.dto.CreatePostRequest
import com.example.ui.dto.PageInfo
import com.example.ui.dto.SearchConditionRequest
import com.example.ui.dto.SearchPostsResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile

@Controller
@RequestMapping("/posts")
class PostController(
    val postCommandService: PostCommandService,
    val postQueryService: PostQueryService,
    val commentQueryService: CommentQueryService,
    val imageCommandService: ImageCommandService
) {

    @GetMapping("/search")
    fun search(
        pageable: Pageable,
        searchConditionRequest: SearchConditionRequest
    ): BaseResponse<SearchPostsResponse> {
        val data = postQueryService.searchPosts(
            pageable,
            searchConditionRequest.toCommand()
        )
        return BaseResponse(
            pageInfo = PageInfo(
                page = data.pageable.pageNumber + 1L,
                pageSize = data.pageable.pageSize.toLong(),
                totalCount = data.totalElements,
            ),
            data = SearchPostsResponse.of(
                postQueryService.searchPosts(
                    pageable,
                    searchConditionRequest.toCommand()
                )
            )
        )
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long, model: Model): String {
        val post = postQueryService.getPostDetail(id)
        val comments = commentQueryService.getAllByPostId(id)

        model.addAttribute("post", post)
        model.addAttribute("comments", comments)

        return "page/post-detail"
    }

    @GetMapping("/createForm")
    fun getCreateForm(model: Model): String {
        model.addAttribute("request", CreatePostRequest("", "", null, ""))
        return "page/create-post"
    }

    @PostMapping
    fun create(@ModelAttribute request: CreatePostRequest): String {
        val id = postCommandService.createPost(request.toCommand())
        return "redirect:/posts/$id"
    }

    @PostMapping("/upload-image")
    @ResponseBody
    fun uploadImage(@RequestParam("file") file: MultipartFile): BaseResponse<Map<String, Long>> {
        val id = imageCommandService.uploadImage(
            UploadImageCommand(
                originalFilename = file.originalFilename!!,
                extension = FileUtils.getExtension(file.originalFilename!!),
                bytes = file.bytes
            )
        )
        return BaseResponse(
            data = mapOf(
                "id" to id
            )
        )
    }
}