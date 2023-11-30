package com.example.api.service

import com.example.api.domain.Coupon
import com.example.api.repository.CouponRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CouponService(
    private val couponRepository: CouponRepository
) {

    @Transactional
    fun apply(userId: Long) {
        val count: Long = couponRepository.count()

        if (count > Coupon.COUPON_LIMIT) {
            throw RuntimeException("쿠폰이 모두 소진되었습니다.")
        }

        val coupon: Coupon = Coupon.create(userId)
        couponRepository.save(coupon)
    }

}
