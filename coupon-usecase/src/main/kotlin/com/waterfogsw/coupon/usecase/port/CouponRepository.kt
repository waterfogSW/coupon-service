package com.waterfogsw.coupon.usecase.port

import com.example.coupon.domain.Coupon

interface CouponRepository {

    fun save(coupon: Coupon)
}
