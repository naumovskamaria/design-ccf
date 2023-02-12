package com.ccf.reservation.service;


import com.ccf.reservation.model.Reservation;
import com.ccf.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final WebClient webClient;


    public List<Reservation> getAllReservations(Integer salonId){
        return this.reservationRepository.findAllBySalonId(salonId);
    }


    public void makeReservation(Integer salonId, LocalDateTime reservationTime) {
        List<Reservation> reservations = getAllReservations(salonId);

        boolean isReservationTimeFree = reservations.stream().noneMatch(reservation -> reservation.getReservationTime().equals(reservationTime));

        if(isReservationTimeFree){
            Reservation reservation = new Reservation(salonId,reservationTime);
            this.reservationRepository.save(reservation);
            log.info("Reservation created successfully");
        }else{
            throw new IllegalArgumentException("Can create reservation for this date and time.");
        }
    }
}
