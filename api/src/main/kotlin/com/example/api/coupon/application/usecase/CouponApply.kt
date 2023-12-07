package com.example.api.coupon.application.usecase

import com.example.api.coupon.application.port.out.CouponCountRepository
import com.example.api.coupon.application.port.out.CouponRepository
import com.example.api.coupon.domain.Coupon
import com.example.api.coupon.domain.Coupon.Companion.COUPON_LIMIT
import org.springframework.stereotype.Service

@Service
class CouponApply(
    private val couponCountRepository: CouponCountRepository,
    private val couponRepository: CouponRepository
) : CouponApplyUseCase {
    override fun invoke(userId: Long): CouponApplyUseCase.Result {
        val count: Long = couponCountRepository.increment()

        if (count > COUPON_LIMIT) {
            val throwable: Throwable = RuntimeException("쿠폰이 모두 소진되었습니다.")
            return CouponApplyUseCase.Result.Failure(throwable)
        }

        val coupon: Coupon = Coupon.create(userId)
        couponRepository.save(coupon)
        return CouponApplyUseCase.Result.Success
    }
}
