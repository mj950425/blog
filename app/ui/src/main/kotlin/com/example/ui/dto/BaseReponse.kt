package com.example.ui.dto

data class BaseResponse<T>(
    val pageInfo: PageInfo? = null,
    val data: T? = null,
)

data class PageInfo(
    val page: Long,
    val pageSize: Long,
    val totalCount: Long
)