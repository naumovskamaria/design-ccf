package dians.coolcutsfinder.service;

import dians.coolcutsfinder.model.Salon;

import java.util.List;

public interface SalonService {

    Salon createSalon(Salon Salon);

    List<Salon> getAllSalons();

    Salon getSalonById(Long id);

    Salon getSalonByName(String name);

    void updateSalon(Long id, Salon Salon);

    void deleteSalon(Long id);
}
