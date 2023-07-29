package com.example.common

object RegularExpressionUtils {

    private val reg = "^[가-힣]{2,4}$".toRegex()

    fun String.isValidKoreanName(): Boolean {
        return reg.matches(this)
    }
}