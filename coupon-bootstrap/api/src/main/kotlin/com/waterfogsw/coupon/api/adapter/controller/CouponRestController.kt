package com.waterfogsw.coupon.api.adapter.controller

import com.waterfogsw.coupon.api.adapter.dto.IssueCouponRequest
import com.waterfogsw.coupon.usecase.usecase.IssueCouponUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/coupons")
class CouponRestController(
    private val issueCouponUseCase: IssueCouponUseCase
) {

    @PostMapping
    fun issueCoupon(
        @RequestBody
        request: IssueCouponRequest
    ) {
        val command: IssueCouponUseCase.Command =
            IssueCouponUseCase.Command(
                userId = request.userId
            )

        issueCouponUseCase.invoke(command)
    }
}
