package com.waterfogsw.coupon.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.waterfogsw.coupon.api.adapter.dto.IssueCouponRequest
import io.kotest.core.extensions.install
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.testcontainers.DockerComposeContainerExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.io.File
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class CouponIssueIntegrationTest(
    @Autowired
    private val mockMvc: MockMvc,
    @Autowired
    private val objectMapper: ObjectMapper
) : DescribeSpec({

    install(DockerComposeContainerExtension(File("src/test/resources/compose-test.yaml")))

    describe("쿠폰 발급 통합 테스트") {
        it("쿠폰 발급 테스트") {
            // given
            val request = IssueCouponRequest(userId = UUID.randomUUID())

            // when
            val result = mockMvc.post("/api/v1/coupons") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }

            // then
            result.andExpect {
                status { isOk() }
            }
        }

        it("단일 유저 중복 쿠폰 발급 테스트") {
            // given
            val request = IssueCouponRequest(userId = UUID.randomUUID())

            // when
            mockMvc.post("/api/v1/coupons") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }.andExpect { status { isOk() } }

            //then
            mockMvc.post("/api/v1/coupons") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(request)
            }.andExpect { status { isBadRequest() } }

        }
    }
})
