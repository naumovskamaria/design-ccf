package dians.coolcutsfinder.repository;

import dians.coolcutsfinder.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {

    Salon findSalonByName(String name);
    Salon findSalonById(Long id);
}
