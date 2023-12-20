package com.waterfogsw.coupon.kafka.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka.producer")
data class KafkaProducerProperties(
    val bootstrapServers: String,
    val topic: Topic,
) {
    data class Topic(
        val couponCreate: String,
    )
}
