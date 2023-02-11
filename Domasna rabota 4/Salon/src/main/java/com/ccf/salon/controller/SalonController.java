package com.ccf.salon.controller;

import com.ccf.salon.model.Salon;
import com.ccf.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
