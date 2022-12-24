package dians.coolcutsfinder.service.impl;

import dians.coolcutsfinder.model.Booking;
import dians.coolcutsfinder.repository.BookingRepository;
import dians.coolcutsfinder.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService {

    public final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        this.bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return this.bookingRepository.findAll();
    }
}
