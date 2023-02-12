package com.ccf.reservation.controller;

import com.ccf.reservation.model.Reservation;
import com.ccf.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping("/{salonId}")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAllReservationsForSalon(@PathVariable Integer salonId){
        ModelAndView modelAndView = new ModelAndView();
        List<Reservation> reservations = this.reservationService.getAllReservations(salonId);
        modelAndView.addObject("reservations",reservations);
        modelAndView.setViewName("reservations");
        return modelAndView;
    }

    @PostMapping("/{salonId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeReservationForSalon(@PathVariable Integer salonId,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime reservationTime,
                                        HttpServletResponse response) throws IOException {
        this.reservationService.makeReservation(salonId,reservationTime);
        response.sendRedirect("http://localhost:8080/api/salon/allSalons");
    }


}
