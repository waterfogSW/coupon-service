package com.waterfogsw.coupon.usecase.port.vo

import java.util.UUID

data class CouponCreateEvent(
    val userId: UUID
)
