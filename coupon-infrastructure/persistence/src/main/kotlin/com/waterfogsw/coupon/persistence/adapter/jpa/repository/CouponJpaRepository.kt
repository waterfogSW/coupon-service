package com.waterfogsw.coupon.persistence.adapter.jpa.repository

import com.waterfogsw.coupon.persistence.adapter.jpa.entity.CouponJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CouponJpaRepository: JpaRepository<CouponJpaEntity, UUID>
