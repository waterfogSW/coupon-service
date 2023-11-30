package com.example.api.service

import com.example.api.repository.CouponRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootTest
class CouponServiceIntegrationTest(
    private val couponService: CouponService,
    private val couponRepository: CouponRepository
) : DescribeSpec({


    describe("쿠폰 응모 요청") {

        it("새로운 쿠폰을 생성한다") {
            couponService.apply(1L)

            val count: Long = couponRepository.count()

            count shouldBe 1
        }

        it("새로운 쿠폰을 생성한다(동시요청)") {
            val threadCount = 1000;
            val executorService: ExecutorService = Executors.newFixedThreadPool(threadCount)
            val latch = CountDownLatch(threadCount)

            repeat(threadCount) {
                executorService.submit {
                    try {
                        couponService.apply(1L)
                    } finally {
                        latch.countDown()
                    }
                }
            }

            latch.await()

            val count = couponRepository.count()
            count shouldBe 100
        }
    }
})
