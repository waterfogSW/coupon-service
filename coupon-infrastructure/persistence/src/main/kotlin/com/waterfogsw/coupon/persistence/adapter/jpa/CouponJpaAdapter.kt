package com.waterfogsw.coupon.persistence.adapter.jpa

import com.example.coupon.domain.Coupon
import com.waterfogsw.coupon.persistence.adapter.jpa.entity.CouponJpaEntity
import com.waterfogsw.coupon.persistence.adapter.jpa.repository.CouponJpaRepository
import com.waterfogsw.coupon.usecase.port.CouponRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CouponJpaAdapter(
    private val couponJpaRepository: CouponJpaRepository
) : CouponRepository {

    @Transactional
    override fun save(coupon: Coupon) {
        couponJpaRepository.save(CouponJpaEntity.from(coupon))
    }
}
