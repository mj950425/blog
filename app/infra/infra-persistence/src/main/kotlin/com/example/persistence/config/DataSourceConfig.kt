package com.example.persistence.config

import com.example.common.CipherDecoder
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {
    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Value("\${spring.profiles.active}")
    lateinit var profile: String

    @Value("\${spring.datasource.username}")
    lateinit var userName: String

    @Value("\${spring.datasource.password}")
    lateinit var password: String

    @Bean
    @Primary
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .url(CipherDecoder.decode(profile, url))
            .username(CipherDecoder.decode(profile, userName))
            .password(CipherDecoder.decode(profile, password))
            .build()
    }
}