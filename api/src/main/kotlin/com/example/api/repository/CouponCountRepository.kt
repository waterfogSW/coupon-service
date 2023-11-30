package com.example.api.repository

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class CouponCountRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    companion object {
        const val COUPON_COUNT_KEY = "coupon_count"
    }

    fun increment(): Long {
        return redisTemplate
            .opsForValue()
            .increment(COUPON_COUNT_KEY) ?: throw RuntimeException("잘못된 요청입니다.")
    }

}
