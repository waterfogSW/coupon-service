package com.waterfogsw.coupon.redis.adapter

import com.waterfogsw.coupon.usecase.port.CouponIssuedUserRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class CouponIssuedRedisAdapter(
    private val redisTemplate: RedisTemplate<String, Any>
) : CouponIssuedUserRepository {

    companion object {
        private const val COUPON_ISSUED_USER_KEY = "coupon_issued_user"
    }

    override fun addUser(userId: UUID): Long {
        return redisTemplate
            .opsForSet()
            .add(COUPON_ISSUED_USER_KEY, userId.toString())
            ?: throw IllegalStateException("Redis add failed")
    }
}
