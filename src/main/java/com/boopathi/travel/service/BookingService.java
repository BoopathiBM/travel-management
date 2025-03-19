package com.boopathi.travel.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boopathi.travel.model.Booking;
import com.boopathi.travel.model.Customer;
import com.boopathi.travel.model.Trip;
import com.boopathi.travel.repo.BookingRepository;
import com.boopathi.travel.repo.CustomerRepository;
import com.boopathi.travel.repo.TripRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Long customerId, Long tripId, int noOfPeople) {

        
        if (customerId == null || tripId == null) {
            throw new IllegalArgumentException("Customer ID and Trip ID must not be null");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setTrip(trip);

        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("Confirmed");
        booking.setPaymentStatus("Pending");
        booking.setNumberOfPeople(noOfPeople);
        booking.setTotalPrice(totalPrice(trip.getPrice(), noOfPeople));
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());

        // ✅ Save the booking
        return bookingRepository.save(booking);

    }

    public BigDecimal totalPrice(BigDecimal pricePerPerson, int numberOfPeople) {

        return pricePerPerson.multiply(BigDecimal.valueOf(numberOfPeople));

    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

}
