package com.example.api.service

import com.example.api.coupon.application.usecase.CouponApplyUseCase
import io.kotest.core.spec.style.DescribeSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class CouponApplyUseCaseIntegrationTest(
    private val couponApplyUseCase: CouponApplyUseCase,
) : DescribeSpec({


    describe("쿠폰 응모 요청") {

        it("새로운 쿠폰을 생성한다(여러명 응모)") {
            val threadCount = 100;
            val executorService: ExecutorService = Executors.newFixedThreadPool(threadCount)
            val latch = CountDownLatch(threadCount)

            repeat(threadCount) {
                executorService.submit {
                    try {
                        couponApplyUseCase.invoke(it.toLong())
                    } finally {
                        latch.countDown()
                    }
                }
            }

            latch.await()
        }

    }
})
