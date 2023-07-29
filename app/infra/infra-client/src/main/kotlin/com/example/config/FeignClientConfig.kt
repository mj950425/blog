package com.example.config

import com.example.toy.BoredApiFeignClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    basePackageClasses = [BoredApiFeignClient::class]
)
class FeignClientConfig {
}