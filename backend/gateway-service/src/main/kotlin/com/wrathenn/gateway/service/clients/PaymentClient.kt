package com.wrathenn.gateway.service.clients

import com.wrathenn.util.models.payment.Payment
import com.wrathenn.util.models.payment.PaymentCreate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*
import java.util.*

@FeignClient(value = "payment-service", url = "\${app.interop.payment-client-api}")
interface PaymentClient {
    @GetMapping("/payments/{paymentUid}")
    fun getPayment(@PathVariable paymentUid: UUID): Payment

    @PostMapping("/payments")
    fun createPayment(@RequestBody paymentCreate: PaymentCreate): Payment

    @PutMapping("/payments/{paymentUid}")
    fun cancelPayment(@PathVariable paymentUid: UUID): Payment
}
