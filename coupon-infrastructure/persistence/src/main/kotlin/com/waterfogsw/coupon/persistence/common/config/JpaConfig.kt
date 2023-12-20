package com.waterfogsw.coupon.persistence.common.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = ["com.waterfogsw.coupon.persistence.adapter.jpa.entity"])
@EnableJpaRepositories(basePackages = ["com.waterfogsw.coupon.persistence.adapter.jpa.repository"])
class JpaConfig
