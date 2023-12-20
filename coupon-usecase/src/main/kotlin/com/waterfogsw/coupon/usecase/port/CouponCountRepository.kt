package com.waterfogsw.coupon.usecase.port

interface CouponCountRepository {

    fun increment(): Long

    fun get(): Long

}
