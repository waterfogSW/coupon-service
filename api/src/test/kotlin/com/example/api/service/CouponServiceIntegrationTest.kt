package com.example.api.service

import com.example.api.repository.CouponRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CouponServiceIntegrationTest(
    private val couponService: CouponService,
    private val couponRepository: CouponRepository
) : DescribeSpec({


    describe("쿠폰 응모 요청시") {

        it("새로운 쿠폰을 생성한다") {
            couponService.apply(1L)

            val count: Long = couponRepository.count()

            count shouldBe 1
        }
    }
})
