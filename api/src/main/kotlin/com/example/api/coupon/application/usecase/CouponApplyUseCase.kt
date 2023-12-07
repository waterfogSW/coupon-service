package com.example.api.coupon.application.usecase

fun interface CouponApplyUseCase {

    fun invoke(userId: Long): Result

    sealed class Result {
        data object Success : Result()
        data class Failure(val throwable: Throwable) : Result()
    }
}
