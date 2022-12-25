package dians.d3final.repository;

import dians.d3final.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {

    Salon findByName(String name);

    Optional<Salon> findById(Long id);

    void deleteByName(String name);
}
