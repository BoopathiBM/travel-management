package com.boopathi.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boopathi.travel.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
