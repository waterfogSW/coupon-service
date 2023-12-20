package com.waterfogsw.coupon.api.common.config

import com.waterfogsw.coupon.kafka.common.config.KafkaProducerConfig
import com.waterfogsw.coupon.redis.common.config.RedisConfig
import com.waterfogsw.coupon.usecase.common.config.UseCaseConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    value = [
        KafkaProducerConfig::class,
        RedisConfig::class,
        UseCaseConfig::class
    ]
)
class ApiConfig
