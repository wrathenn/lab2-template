package com.wrathenn.gateway.service.models

import com.wrathenn.util.models.loyalty.LoyaltyStatus

data class LoyaltyDto(
    val status: LoyaltyStatus,
    val discount: Int,
    val reservationCount: Int,
)

data class LoyaltyShortDto(
    val status: LoyaltyStatus,
    val discount: Int,
)
