package dians.coolcutsfinder.repository;

import dians.coolcutsfinder.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    void deleteById(Long id);
}
