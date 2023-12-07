package com.example.api.coupon.application.port.out

import com.example.api.coupon.domain.Coupon

interface CouponRepository {

    fun save(coupon: Coupon)
}
