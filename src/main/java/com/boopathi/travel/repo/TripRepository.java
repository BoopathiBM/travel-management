package com.boopathi.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boopathi.travel.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
