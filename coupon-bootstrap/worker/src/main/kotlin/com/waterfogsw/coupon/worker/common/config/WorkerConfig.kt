package com.waterfogsw.coupon.worker.common.config

import com.waterfogsw.coupon.persistence.common.config.PersistenceConfig
import com.waterfogsw.coupon.usecase.common.config.UseCaseConfig
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    PersistenceConfig::class,
    UseCaseConfig::class,
)
@ConfigurationPropertiesScan(basePackages = ["com.waterfogsw.coupon.worker.common.properties"])
class WorkerConfig
