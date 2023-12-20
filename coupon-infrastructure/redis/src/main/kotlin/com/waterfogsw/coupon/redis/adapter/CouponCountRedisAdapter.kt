package com.waterfogsw.coupon.redis.adapter

import com.waterfogsw.coupon.usecase.port.CouponCountRepository
import org.springframework.stereotype.Component

@Component
class CouponCountRedisAdapter (
    private val redisHandler: RedisHandler
): CouponCountRepository {

    companion object {
        private const val COUPON_COUNT_KEY = "coupon_count"
    }

    override fun increment(): Long {
        return redisHandler.increment(COUPON_COUNT_KEY)
            ?: throw IllegalStateException("Redis increment failed")
    }

    override fun get(): Long {
        return redisHandler.get(COUPON_COUNT_KEY)
            ?: throw IllegalStateException("Redis get failed")
    }

}
