package com.example.coupon.domain

import com.exapmle.ulid.UlidUtil
import java.time.LocalDateTime
import java.util.*

data class Coupon(
    val id: UUID = UlidUtil.createUlid(),
    val userId: UUID,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    companion object {
        const val LIMIT_COUNT = 100L
        fun create(userId: UUID): Coupon {
            return Coupon(userId = userId)
        }
    }
}
