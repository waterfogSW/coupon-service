package com.waterfogsw.coupon.worker.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "kafka.consumer")
data class KafkaConsumerProperties(
    val bootstrapServers: String,
    val groupId: String,
    val topic: Topic,
) {
    data class Topic(
        val couponCreate: String,
    )
}
