package dians.d3final.service;

import dians.d3final.model.Salon;
import dians.d3final.model.dto.SalonDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface SalonService {

    List<Salon> getAllSalons();

    Salon getSalonByName(String name);

    Optional<Salon> getSalonById(Long id);

    void deleteById(Long id);

    @Transactional
    Optional<Salon> edit(Long id, String name, String address);

    Optional<Salon> edit(Long id, SalonDto salonDto);

    @Transactional
    Optional<Salon> save(String name, String address);

    Optional<Salon> save(SalonDto salonDto);
}
