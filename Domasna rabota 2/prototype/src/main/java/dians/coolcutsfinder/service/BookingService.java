package dians.coolcutsfinder.service;

import dians.coolcutsfinder.model.Booking;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);

    void deleteBooking(Long id);

    List<Booking> getAllBookings();



}
