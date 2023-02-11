package com.ccf.reservation.service;


import com.ccf.reservation.model.Reservation;
import com.ccf.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void makeReservation(Integer salonId,LocalDateTime reservationTime){
        List<Reservation> reservationsForSalon = this.reservationRepository.findAllBySalonId(salonId);
        boolean isReservationTimeFree = reservationsForSalon.stream().noneMatch(reservation -> reservation.getReservationTime().equals(reservationTime));

        if(isReservationTimeFree){
            Reservation reservation = new Reservation(salonId,reservationTime);
            this.reservationRepository.save(reservation);
            log.info("Reservation for salon {} at time {} was created",salonId,reservationTime);
        }else{
            throw new IllegalArgumentException("Reservation for this date and time already exists. Try another date or time");
        }
    }

    public List<Reservation> getAllReservations(Integer salonId){
        return this.reservationRepository.findAllBySalonId(salonId);
    }
}
