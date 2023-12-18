package org.example.worker.adapter

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CouponEventConsumer {

    @KafkaListener(
        topics = ["\${kafka.consumer.coupon-create-topic}"],
        groupId = "\${kafka.consumer.group-id}"
    )
    fun consumeCouponCreateEvent(userId: Long) {
        println("CouponEventConsumer: consumeCouponCreateEvent: userId=$userId")
    }


}
