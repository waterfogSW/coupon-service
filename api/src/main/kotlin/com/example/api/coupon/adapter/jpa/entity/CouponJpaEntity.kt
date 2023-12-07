package com.example.api.coupon.adapter.jpa.entity

import com.example.api.coupon.domain.Coupon
import jakarta.persistence.*

@Entity
class CouponJpaEntity(
    id: Long? = null,
    userId: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set

    @Column(nullable = false)
    var userId: Long = userId
        private set

    companion object {
        fun from(coupon: Coupon): CouponJpaEntity = CouponJpaEntity(
            id = coupon.id,
            userId = coupon.userId
        )
    }
}
