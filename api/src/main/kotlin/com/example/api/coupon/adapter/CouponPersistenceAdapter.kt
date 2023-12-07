package com.example.api.coupon.adapter

import com.example.api.coupon.adapter.jpa.CouponJpaRepository
import com.example.api.coupon.adapter.jpa.entity.CouponJpaEntity
import com.example.api.coupon.application.port.out.CouponRepository
import com.example.api.coupon.domain.Coupon
import org.springframework.stereotype.Component

@Component
class CouponPersistenceAdapter(
    private val couponJpaRepository: CouponJpaRepository
): CouponRepository {

    override fun save(coupon: Coupon) {
        val couponJpaEntity: CouponJpaEntity = CouponJpaEntity.from(coupon)
        couponJpaRepository.save(couponJpaEntity)
    }
}
