package com.waterfogsw.coupon.api.adapter.controller

import com.waterfogsw.coupon.api.adapter.dto.IssueCouponRequest
import com.waterfogsw.coupon.usecase.usecase.IssueCoupon
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/coupons")
class CouponRestController(
    private val issueCoupon: IssueCoupon
) {

    @PostMapping
    fun issueCoupon(
        @RequestBody
        request: IssueCouponRequest
    ): ResponseEntity<Unit> {
        val command: IssueCoupon.Command =
            IssueCoupon.Command(
                userId = request.userId
            )

        val result = issueCoupon.invoke(command)
        return when (result) {
            is IssueCoupon.Result.Success -> ResponseEntity.ok().build()
            is IssueCoupon.Result.Failure -> ResponseEntity.badRequest().build()
        }
    }
}
