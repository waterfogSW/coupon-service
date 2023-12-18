package com.example.api.coupon.adapter

import com.example.api.common.config.KafkaProperties
import com.example.api.coupon.application.port.out.CouponEventProducerPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CouponEventProducerAdapter(
    private val kafkaTemplate: KafkaTemplate<String, Long>,
    private val kafkaProperties: KafkaProperties,
): CouponEventProducerPort {


    override fun sendCreateEvent(userId: Long) {
        kafkaTemplate.send(kafkaProperties.couponCreateTopic, userId)
    }
}