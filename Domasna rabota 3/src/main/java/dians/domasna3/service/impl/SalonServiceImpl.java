package dians.domasna3.service.impl;

import dians.domasna3.model.Salon;
import dians.domasna3.repository.SalonRepository;
import dians.domasna3.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    public List<Salon> getAllSalons(){
        return this.salonRepository.findAll();
    }
}
