package com.ccf.salon.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Integer salonId;
    private LocalDateTime reservationTime;
}
