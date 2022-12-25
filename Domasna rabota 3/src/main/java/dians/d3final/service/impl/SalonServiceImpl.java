package dians.d3final.service.impl;

import dians.d3final.model.Salon;
import dians.d3final.model.dto.SalonDto;
import dians.d3final.model.exceptions.ProductNotFoundException;
import dians.d3final.repository.SalonRepository;
import dians.d3final.service.SalonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public List<Salon> getAllSalons() {
        return this.salonRepository.findAll();
    }

    @Override
    public Salon getSalonByName(String name) {
        return this.salonRepository.findByName(name);
    }

    @Override
    public Optional<Salon> getSalonById(Long id) {
        return this.salonRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.salonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Salon> edit(Long id, String name, String address) {

        Salon salon = this.salonRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        salon.setName(name);
        salon.setAddress(address);

        return Optional.of(this.salonRepository.save(salon));
    }

    @Override
    public Optional<Salon> edit(Long id, SalonDto salonDto) {
        Salon salon = this.salonRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        salon.setName(salonDto.getName());
        salon.setAddress(salonDto.getAddress());

        return Optional.of(this.salonRepository.save(salon));
    }

    @Override
    @Transactional
    public Optional<Salon> save(String name, String address) {

        this.salonRepository.deleteByName(name);
        return Optional.of(this.salonRepository.save(new Salon(name,address)));
    }

    @Override
    public Optional<Salon> save(SalonDto salonDto) {

        this.salonRepository.deleteByName(salonDto.getName());
        return Optional.of(this.salonRepository.save(new Salon(salonDto.getName(), salonDto.getAddress())));
    }

}
