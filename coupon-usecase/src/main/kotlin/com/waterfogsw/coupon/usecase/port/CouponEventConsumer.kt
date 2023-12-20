package com.waterfogsw.coupon.usecase.port

import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent

interface CouponEventConsumer {

    fun receiveCreateEvent(event: CouponCreateEvent)
}
