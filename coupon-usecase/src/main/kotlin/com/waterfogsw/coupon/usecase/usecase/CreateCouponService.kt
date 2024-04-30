package com.waterfogsw.coupon.usecase.usecase

import com.example.coupon.domain.Coupon
import com.waterfogsw.coupon.usecase.port.CouponRepository
import org.springframework.stereotype.Service

@Service
class CreateCouponService (
    private val couponRepository: CouponRepository
): CreateCoupon {

    override fun invoke(command: CreateCoupon.Command): CreateCoupon.Result {
        val coupon: Coupon = Coupon.create(command.userId)

        couponRepository.save(coupon)

        return CreateCoupon.Result.Success
    }

}
