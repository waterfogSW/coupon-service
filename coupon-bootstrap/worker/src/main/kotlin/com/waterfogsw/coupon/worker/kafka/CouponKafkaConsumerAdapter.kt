package com.waterfogsw.coupon.worker.kafka

import com.waterfogsw.coupon.usecase.port.CouponEventConsumer
import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent
import com.waterfogsw.coupon.usecase.usecase.CreateCouponUseCase
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CouponKafkaConsumerAdapter(
    private val createCouponUseCase: CreateCouponUseCase,
) : CouponEventConsumer {

    @KafkaListener(
        topics = ["\${kafka.consumer.topic.coupon-create}"],
        groupId = "\${kafka.consumer.group-id}"
    )
    override fun receiveCreateEvent(event: CouponCreateEvent) {
        val command: CreateCouponUseCase.Command =
            CreateCouponUseCase.Command(
                userId = event.userId
            )

        createCouponUseCase.invoke(command)
    }
}
