package com.example.persistence.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["com.example.persistence.jpa"])
@EnableJpaRepositories(basePackages = ["com.example.persistence.jpa"])
class JpaConfiguration
