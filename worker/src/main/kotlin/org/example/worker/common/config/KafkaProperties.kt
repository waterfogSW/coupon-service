package org.example.worker.common.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka.consumer")
data class KafkaProperties(
    val bootstrapServers: String,
    val couponCreateTopic: String,
)
