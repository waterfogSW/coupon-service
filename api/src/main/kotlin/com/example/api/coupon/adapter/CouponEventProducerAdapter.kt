package com.example.api.coupon.adapter

import com.example.api.common.config.KafkaProducerProperties
import com.example.api.coupon.application.port.out.CouponEventProducerPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CouponEventProducerAdapter(
    private val kafkaTemplate: KafkaTemplate<String, Long>,
    private val kafkaProducerProperties: KafkaProducerProperties,
): CouponEventProducerPort {


    override fun sendCreateEvent(userId: Long) {
        kafkaTemplate.send(kafkaProducerProperties.couponCreateTopic, userId)
    }
}
