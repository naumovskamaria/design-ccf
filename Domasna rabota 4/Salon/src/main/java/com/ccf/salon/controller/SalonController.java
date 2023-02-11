package com.ccf.salon.controller;

import com.ccf.salon.dto.SalonRequest;
import com.ccf.salon.dto.SalonResponse;
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
    public void createSalon(@RequestBody SalonRequest salonRequest){
        salonService.createSalon(salonRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalonResponse> getAllSalons(){
        return salonService.getAllSalons();
    }
}
