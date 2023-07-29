package com.example.common

import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.services.kms.KmsClient
import software.amazon.awssdk.services.kms.model.DecryptRequest
import java.util.Base64

class CipherDecoder {
    companion object {
        private val kmsClient: KmsClient = KmsClient.builder()
            .build()

        fun decode(profile: String, cipherText: String): String {
            if (profile == "local") return cipherText

            val decodedBytes = Base64.getDecoder().decode(cipherText)
            val sdkBytes = SdkBytes.fromByteArray(decodedBytes)
            val decryptRequest = DecryptRequest.builder()
                .ciphertextBlob(sdkBytes)
                .build()

            val decryptResponse = kmsClient.decrypt(decryptRequest)
            val plainTextBytes = decryptResponse.plaintext().asByteArray()

            return String(plainTextBytes)
        }
    }
}