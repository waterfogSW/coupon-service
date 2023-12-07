package com.example.api.coupon.adapter.jpa

import com.example.api.coupon.adapter.jpa.entity.CouponJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CouponJpaRepository : JpaRepository<CouponJpaEntity, Long> {
}
