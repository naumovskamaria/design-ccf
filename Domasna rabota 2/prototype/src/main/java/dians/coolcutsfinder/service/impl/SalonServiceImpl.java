package dians.coolcutsfinder.service.impl;

import dians.coolcutsfinder.model.Salon;
import dians.coolcutsfinder.repository.SalonRepository;
import dians.coolcutsfinder.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {
    private final SalonRepository SalonRepository;
    @Autowired
    public SalonServiceImpl(SalonRepository SalonRepository) {
        this.SalonRepository = SalonRepository;
    }


    @Override
    public Salon createSalon(Salon Salon) {
        return SalonRepository.save(Salon);
    }

    @Override
    public List<Salon> getAllSalons() {
        return SalonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long id) {
        return SalonRepository.findSalonById(id);
    }

    @Override
    public Salon getSalonByName(String name) {
        return SalonRepository.findSalonByName(name);
    }

    @Override
    public void updateSalon(Long id, Salon Salon) {
        Optional<Salon> Salon1 = SalonRepository.findById(id);
        Salon Salon2 =Salon1.get();
        Salon2.setName(Salon.getName());
        Salon2.setAddress(Salon.getAddress());
        SalonRepository.save(Salon2);
    }

    @Override
    public void deleteSalon(Long id) {
        Optional<Salon> Salon = SalonRepository.findById(id);
        SalonRepository.delete(Salon.get());
    }
}
