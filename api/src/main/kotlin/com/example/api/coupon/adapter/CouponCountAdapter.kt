package com.example.api.coupon.adapter

import com.example.api.coupon.application.port.out.CouponCountRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class CouponCountAdapter(
    private val redisTemplate: RedisTemplate<String, String>
) : CouponCountRepository {

    companion object {
        const val COUPON_COUNT_KEY = "coupon_count"
    }

    override fun increment(): Long {
        return redisTemplate
            .opsForValue()
            .increment(COUPON_COUNT_KEY) ?: throw RuntimeException("잘못된 요청입니다.")
    }
}
