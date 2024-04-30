package com.waterfogsw.coupon.usecase.usecase

import java.util.*

fun interface CreateCoupon {

    fun invoke(command: Command): Result

    data class Command(val userId: UUID)

    sealed class Result {
        data object Success : Result()
        data class Failure(val throwable: Throwable) : Result()
    }
}
