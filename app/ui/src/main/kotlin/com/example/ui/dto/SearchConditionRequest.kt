package com.example.ui.dto

import com.example.domain.post.command.SearchConditionCommand

data class SearchConditionRequest(
    val title: String? = null,
) {
    fun toCommand(): SearchConditionCommand {
        return SearchConditionCommand(
            title = this.title,
        )
    }
}
