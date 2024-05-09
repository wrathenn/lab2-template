package com.wrathenn.gateway.service.clients

import com.wrathenn.util.models.loyalty.Loyalty
import com.wrathenn.util.models.loyalty.LoyaltyReservationCountOperation
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "loyalty-service", url = "\${app.interop.loyalty-client-api}")
interface LoyaltyClient {
    @GetMapping("/loyalties")
    fun getLoyalty(@RequestHeader("X-User-Name") username: String): Loyalty

    @PutMapping("/loyalties/reservationCount")
    fun updateReservationCount(
        @RequestHeader("X-User-Name") username: String,
        @RequestBody loyaltyReservationCountOperation: LoyaltyReservationCountOperation,
    ): Loyalty
}
