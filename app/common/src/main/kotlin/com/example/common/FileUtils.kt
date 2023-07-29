package com.example.common

import org.springframework.util.StringUtils

object FileUtils {
    const val baseDir = "/Users/mrt/Desktop/dev/study/blog-images/"

    fun getExtension(originalFilename: String): String {
        return StringUtils.getFilenameExtension(originalFilename) ?: throw IllegalArgumentException()
    }
}