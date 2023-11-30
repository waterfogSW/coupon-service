package com.example.api.domain

import jakarta.persistence.*

@Entity
class Coupon(
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
        const val COUPON_LIMIT: Long = 100
        fun create(userId: Long): Coupon = Coupon(userId = userId)
    }
}
