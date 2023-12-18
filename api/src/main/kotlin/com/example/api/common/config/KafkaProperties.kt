package com.example.api.common.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka.producer")
data class KafkaProducerProperties(
    val bootstrapServers: String,
    val couponCreateTopic: String,
)
