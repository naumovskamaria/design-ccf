package com.ccf.reservation.controller;

import com.ccf.reservation.model.Reservation;
import com.ccf.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    @PostMapping("/{salonId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeReservation(@PathVariable("salonId") Integer salonId,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime reservationTime) {
        this.reservationService.makeReservation(salonId,reservationTime);
    }

    @GetMapping("/{salonId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> getAllReservations(@PathVariable Integer salonId){
        return this.reservationService.getAllReservations(salonId);
    }
}
