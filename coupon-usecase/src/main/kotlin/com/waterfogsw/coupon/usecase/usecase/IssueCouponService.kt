package com.waterfogsw.coupon.usecase.usecase

import com.example.coupon.domain.Coupon
import com.waterfogsw.coupon.usecase.port.CouponCountRepository
import com.waterfogsw.coupon.usecase.port.CouponEventProducer
import com.waterfogsw.coupon.usecase.port.CouponIssuedUserRepository
import com.waterfogsw.coupon.usecase.port.vo.CouponCreateEvent
import org.springframework.stereotype.Service

@Service
class IssueCouponService(
    private val couponCountRepository: CouponCountRepository,
    private val couponIssuedUserRepository: CouponIssuedUserRepository,
    private val couponEventProducer: CouponEventProducer
) : IssueCoupon {
    override fun invoke(command: IssueCoupon.Command): IssueCoupon.Result {
        val couponCount: Long = couponCountRepository.increment()
        if (couponCount > Coupon.LIMIT_COUNT) {
            return IssueCoupon.Result.Failure(RuntimeException("쿠폰이 모두 소진되었습니다."))
        }

        val addedUserIdCount: Long = couponIssuedUserRepository.addUser(command.userId)
        if (addedUserIdCount != 1L) {
            return IssueCoupon.Result.Failure(RuntimeException("이미 쿠폰을 발급받은 사용자입니다."))
        }

        val event = CouponCreateEvent(userId = command.userId)
        couponEventProducer.sendCreateEvent(event = event)
        return IssueCoupon.Result.Success
    }
}
