package com.ccf.salon.service;

import com.ccf.salon.dto.Reservation;
import com.ccf.salon.model.Salon;
import com.ccf.salon.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalonService {

    private final SalonRepository salonRepository;
    private final WebClient webClient;

    public void createSalon(String name, String address) {
        Salon salon = new Salon(name, address);

        this.salonRepository.save(salon);
        log.info("Salon {} is created", salon.getId());
    }

    public List<Salon> getAllSalons() {

        return salonRepository.findAll();
    }


    public void createReservation(Integer salonId, LocalDateTime reservationTime) {
        webClient.post()
                .uri("http://localhost:8081/api/reservation/",
                        uriBuilder -> uriBuilder.queryParam("reservationTime",reservationTime).pathSegment("{salonId}").build(salonId))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
