package com.waterfogsw.coupon.usecase.usecase

import com.example.coupon.domain.Coupon
import com.waterfogsw.coupon.usecase.port.CouponRepository
import org.springframework.stereotype.Service

@Service
class CreateCoupon (
    private val couponRepository: CouponRepository
): CreateCouponUseCase {

    override fun invoke(command: CreateCouponUseCase.Command): CreateCouponUseCase.Result {
        val coupon: Coupon = Coupon.create(command.userId)

        couponRepository.save(coupon)

        return CreateCouponUseCase.Result.Success
    }

}
