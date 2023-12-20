package com.waterfogsw.coupon.usecase.port

import java.util.*

interface CouponIssuedUserRepository {

    /**
     * 쿠폰 발급 유저 추가
     * @param userId
     * @return 해당 user의 발급된 쿠폰 수
     */
    fun addUser(userId: UUID): Long
}
