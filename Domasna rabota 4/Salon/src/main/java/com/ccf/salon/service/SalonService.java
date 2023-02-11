package com.ccf.salon.service;

import com.ccf.salon.dto.SalonResponse;
import com.ccf.salon.model.Salon;
import com.ccf.salon.dto.SalonRequest;
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

     public void createSalon(SalonRequest salonRequest){
         Salon salon = Salon.builder()
                 .name(salonRequest.getName())
                 .address(salonRequest.getAddress())
                 .build();

         this.salonRepository.save(salon);
         log.info("Salon {} is created", salon.getId());
     }

     public List<SalonResponse> getAllSalons(){
         List<Salon> salons = salonRepository.findAll();

         return salons.stream()
                 .map(this::mapToSalonResponse)
                 .toList();
     }

     private SalonResponse mapToSalonResponse(Salon salon){
         return SalonResponse.builder()
                 .id(salon.getId())
                 .name(salon.getName())
                 .address(salon.getAddress())
                 .build();
     }
}
