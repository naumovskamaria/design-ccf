package com.ccf.reservation.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer salonId;
    private LocalDateTime reservationTime;

    public Reservation(Integer salonId, LocalDateTime reservationTime) {
        this.salonId = salonId;
        this.reservationTime = reservationTime;
    }
}
