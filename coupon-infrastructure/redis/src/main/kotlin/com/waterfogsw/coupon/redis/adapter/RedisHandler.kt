package com.waterfogsw.coupon.redis.adapter

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisHandler(
    private val redisTemplate: RedisTemplate<String, Any>
) {

    fun <T> get(key: String): T? {
        @Suppress("UNCHECKED_CAST")
        return redisTemplate.opsForValue()[key] as T?
    }

    fun <T> set(key: String, value: T) {
        redisTemplate.opsForValue()[key] = value as String
    }

    fun <T> delete(key: String) {
        redisTemplate.delete(key)
    }

    fun increment(key: String): Long? {
        return redisTemplate.opsForValue().increment(key)
    }
}
