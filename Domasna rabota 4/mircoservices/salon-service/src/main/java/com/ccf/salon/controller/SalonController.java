package com.ccf.salon.controller;

import com.ccf.salon.model.Salon;
import com.ccf.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
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
                            @RequestParam String address,
                            HttpServletResponse response) throws IOException {
        salonService.createSalon(name,address);
        response.sendRedirect("http://localhost:8080/api/salon/allSalons");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Salon> getAllSalons() {
        return salonService.getAllSalons();
    }



    @GetMapping("/allSalons")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView showAllSalons(){
        ModelAndView modelAndView = new ModelAndView();
        List<Salon> salons = this.salonService.getAllSalons();
        modelAndView.setViewName("salons");
        modelAndView.addObject("salons",salons);
        return modelAndView;
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create-salon");
        return modelAndView;
    }

    @PostMapping("/{salonId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@PathVariable Integer salonId,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime reservationTime){
        this.salonService.createReservation(salonId,reservationTime);
    }

}
