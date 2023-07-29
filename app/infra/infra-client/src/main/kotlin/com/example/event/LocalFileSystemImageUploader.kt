package com.example.event

import com.example.common.FileUtils.baseDir
import com.example.domain.post.command.UploadImageCommand
import com.example.domain.post.domain.ImageUploader
import org.springframework.stereotype.Service
import java.net.URLEncoder
import java.nio.file.Files
import java.nio.file.Paths
import java.util.UUID

@Service
class LocalFileSystemImageUploader : ImageUploader {
    private val uploadDirectory = Paths.get(baseDir)

    init {
        if (Files.notExists(uploadDirectory)) {
            Files.createDirectories(uploadDirectory)
        }
    }

    override fun upload(command: UploadImageCommand): String {
        val uniqueFilename =
            generateUniqueFilename(command)

        val path = uploadDirectory.resolve(uniqueFilename)
        Files.write(path, command.bytes)

        return uniqueFilename
    }

    private fun generateUniqueFilename(command: UploadImageCommand): String {
        return URLEncoder.encode(UUID.randomUUID().toString().substring(0, 10), "UTF-8") + ".${command.extension}"
    }
}