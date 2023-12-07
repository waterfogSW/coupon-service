package com.example.api.service

import com.example.api.coupon.adapter.jpa.CouponJpaRepository
import com.example.api.coupon.application.usecase.CouponApplyUseCase
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootTest
class CouponApplyUseCaseIntegrationTest(
    private val couponApplyUseCase: CouponApplyUseCase,
    private val couponJpaRepository: CouponJpaRepository,
) : DescribeSpec({


    describe("쿠폰 응모 요청") {

        it("새로운 쿠폰을 생성한다") {
            couponApplyUseCase.invoke(1L)

            val count: Long = couponJpaRepository.count()

            count shouldBe 1
        }

        it("새로운 쿠폰을 생성한다(동시요청)") {
            val threadCount = 1000;
            val executorService: ExecutorService = Executors.newFixedThreadPool(threadCount)
            val latch = CountDownLatch(threadCount)

            repeat(threadCount) {
                executorService.submit {
                    try {
                        couponApplyUseCase.invoke(1L)
                    } finally {
                        latch.countDown()
                    }
                }
            }

            latch.await()

            val count = couponJpaRepository.count()
            count shouldBe 100
        }
    }
})
