package com.example.api.coupon.application.port.out

interface CouponEventProducerPort {

    fun sendCreateEvent(userId: Long)
}
