package com.ccf.salon.controller;

import com.ccf.salon.model.Salon;
import com.ccf.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/salon")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSalon(@RequestParam String name,
                            @RequestParam String address){
        salonService.createSalon(name,address);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Salon> getAllSalons(){
        return salonService.getAllSalons();
    }

    @PostMapping("/{salonId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@PathVariable Integer salonId,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime reservationTime){
        this.salonService.createReservation(salonId,reservationTime);
    }

}
