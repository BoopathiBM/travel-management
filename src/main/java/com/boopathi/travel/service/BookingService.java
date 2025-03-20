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
import com.dto.BookingRequestDTO;

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

    public Booking createBooking(BookingRequestDTO bookingRequestDTO) {

        Optional<Customer> customerOpt = customerRepository.findById(bookingRequestDTO.getCustomerId());

        Optional<Trip> tripOpt = tripRepository.findById(bookingRequestDTO.getTripId());

        if(customerOpt.isEmpty() || tripOpt.isPresent()){
            throw new IllegalArgumentException("invalid customer or trip");
        }

        Booking book = new Booking();

        book.setBookingDate(LocalDateTime.now());
        book.setStatus("Confirmed");
        book.setNumberOfPeople(bookingRequestDTO.getNumberOfPeople());
        book.setTotalPrice((totalPrice(tripOpt.get().getPrice(),bookingRequestDTO.getNumberOfPeople())));
        book.setCustomer(customerOpt.get());
        book.setTrip(tripOpt.get());
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());


        return null;

    }

    public BigDecimal totalPrice(BigDecimal pricePerPerson, int numberOfPeople) {

        return pricePerPerson.multiply(BigDecimal.valueOf(numberOfPeople));

    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

}
