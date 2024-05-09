package com.wrathenn.gateway.service.clients

import com.wrathenn.util.models.Page
import com.wrathenn.util.models.reservation.Hotel
import com.wrathenn.util.models.reservation.Reservation
import com.wrathenn.util.models.reservation.ReservationCreate
import com.wrathenn.util.models.reservation.ReservationWithHotel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@FeignClient(value = "reservationClient", url = "\${app.interop.reservation-client-api}")
interface ReservationClient {
    @GetMapping("/hotels")
    fun pagedHotels(@RequestParam page: Int, @RequestParam size: Int): Page<Hotel>

    @GetMapping("/hotels/{hotelUid}")
    fun getHotel(@PathVariable hotelUid: UUID): Hotel

    @GetMapping("/hotels/cost")
    fun getHotelCost(
        @RequestParam hotelUid: UUID,
        @RequestParam from: LocalDate,
        @RequestParam to: LocalDate
    ): Int

    @GetMapping("/reservations/{reservationUid}")
    fun getReservation(
        @PathVariable reservationUid: UUID,
    ): ReservationWithHotel

    @GetMapping("/reservations")
    fun getReservations(@RequestHeader("X-User-Name") username: String): List<ReservationWithHotel>

    @PostMapping("/reservations")
    fun createReservation(
        @RequestBody reservationCreate: ReservationCreate
    ): Reservation

    @PutMapping("/reservations/{reservationUid}")
    fun cancelReservation(
        @PathVariable reservationUid: UUID,
    ): Reservation
}
