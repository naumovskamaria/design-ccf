package dians.d3final.service.impl;

import dians.d3final.model.Reservation;
import dians.d3final.model.Salon;
import dians.d3final.repository.ReservationRepository;
import dians.d3final.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    @Override
//    public Reservation createReservation(Optional<Salon> salon) {
//        Reservation r = new Reservation(salon);
//        return this.reservationRepository.save(r);
//    }
}
