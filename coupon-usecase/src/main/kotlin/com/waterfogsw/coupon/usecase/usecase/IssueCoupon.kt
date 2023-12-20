package com.waterfogsw.coupon.usecase.usecase

import com.example.coupon.domain.Coupon
import com.waterfogsw.coupon.usecase.port.CouponCountRepository
import com.waterfogsw.coupon.usecase.port.CouponEventProducer
import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent
import org.springframework.stereotype.Service

@Service
class IssueCoupon(
    private val couponCountRepository: CouponCountRepository,
    private val couponEventProducer: CouponEventProducer
) : IssueCouponUseCase {

    override fun invoke(command: IssueCouponUseCase.Command): IssueCouponUseCase.Result {
        val count: Long = couponCountRepository.increment()

        if (count > Coupon.LIMIT_COUNT) {
            val throwable: Throwable = RuntimeException("쿠폰이 모두 소진되었습니다.")
            return IssueCouponUseCase.Result.Failure(throwable)
        }

        val event = CouponCreateEvent(userId = command.userId)
        couponEventProducer.sendCreateEvent(event = event)

        return IssueCouponUseCase.Result.Success
    }

}
