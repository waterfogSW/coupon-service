package com.waterfogsw.coupon.usecase.port

import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent

interface CouponEventProducer {

    fun sendCreateEvent(event: CouponCreateEvent)

}
