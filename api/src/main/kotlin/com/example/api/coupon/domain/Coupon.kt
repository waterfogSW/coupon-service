package com.example.api.coupon.domain

data class Coupon(
    val id: Long? = null,
    val userId: Long,
) {
    companion object {
        const val COUPON_LIMIT: Long = 100
        fun create(userId: Long): Coupon = Coupon(userId = userId)
    }
}
