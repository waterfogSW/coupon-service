package com.waterfogsw.coupon.kafka.adapter

import com.waterfogsw.coupon.kafka.common.properties.KafkaProducerProperties
import com.waterfogsw.coupon.usecase.port.CouponEventProducer
import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent
import org.springframework.stereotype.Component

@Component
class CouponKafkaProducerAdapter (
    private val kafkaProducerProperties: KafkaProducerProperties,
    private val kafkaProducerHandler: KafkaProducerHandler
): CouponEventProducer {

    override fun sendCreateEvent(event: CouponCreateEvent) {
        kafkaProducerHandler.send(
            topic = kafkaProducerProperties.topic.couponCreate,
            message = event
        )
    }
}
