package com.waterfogsw.coupon.persistence.adapter.jpa.entity

import com.example.coupon.domain.Coupon
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "coupon")
class CouponJpaEntity(
    id: UUID,
    userId: UUID,
    createdAt: LocalDateTime,
) {

    @Id
    @Column(name = "id", nullable = false)
    var id: UUID = id
        private set

    @Column(name = "user_id", nullable = false)
    var userId: UUID = userId
        private set

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = createdAt
        private set

    companion object {
        fun from(coupon: Coupon): CouponJpaEntity {
            return CouponJpaEntity(
                id = coupon.id,
                userId = coupon.userId,
                createdAt = coupon.createdAt,
            )
        }
    }

}
