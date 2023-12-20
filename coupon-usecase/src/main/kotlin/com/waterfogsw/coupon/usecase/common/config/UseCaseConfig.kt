package com.waterfogsw.coupon.usecase.common.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.waterfogsw.coupon.usecase"], lazyInit = true)
class UseCaseConfig
