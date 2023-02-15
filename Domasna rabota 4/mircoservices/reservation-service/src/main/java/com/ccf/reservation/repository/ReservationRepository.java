package com.ccf.reservation.repository;

import com.ccf.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    List<Reservation> findAllBySalonId(Integer salonId);
}
