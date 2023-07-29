package com.example.domain.post.command

data class UploadImageCommand(
    val originalFilename: String,
    val extension: String,
    val bytes: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UploadImageCommand) return false

        if (originalFilename != other.originalFilename) return false
        if (extension != other.extension) return false
        if (!bytes.contentEquals(other.bytes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = originalFilename.hashCode()
        result = 31 * result + extension.hashCode()
        result = 31 * result + bytes.contentHashCode()
        return result
    }
}