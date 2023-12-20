package com.waterfogsw.coupon.kafka.adapter

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducerHandler(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    fun <T> send(topic: String, message: T) {
        kafkaTemplate.send(topic, message)
    }

}
