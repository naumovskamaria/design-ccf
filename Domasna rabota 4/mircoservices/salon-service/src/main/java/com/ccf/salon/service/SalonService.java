package com.ccf.salon.service;

import com.ccf.salon.model.Salon;
import com.ccf.salon.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalonService {

    private final SalonRepository salonRepository;

     public void createSalon(String name,String address){
         Salon salon = new Salon(name,address);

         this.salonRepository.save(salon);
         log.info("Salon {} is created", salon.getId());
     }

     public List<Salon> getAllSalons(){

         return salonRepository.findAll();
     }

}
