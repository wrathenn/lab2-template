package com.wrathenn.gateway.service.models

import com.wrathenn.util.models.payment.PaymentStatus

data class PaymentDto(
    val status: PaymentStatus,
    val price: Int,
)
