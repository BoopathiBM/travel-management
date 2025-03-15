package com.boopathi.travel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boopathi.travel.model.Trip;
import com.boopathi.travel.repo.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository tripRepository;

	public List<Trip> getAllTrip(){
		return tripRepository.findAll();
	}

	public Optional<Trip> getTripById(Long id){
		return tripRepository.findById(id);
	}

	public Trip createTrip(Trip trip){
		return tripRepository.save(trip);
	}

	public Trip updateTrip(Long id, Trip updatedTrip){

		Trip existingTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not Found"));

		existingTrip.setTripName(updatedTrip.getTripName());
		existingTrip.setDestination(updatedTrip.getDestination());
		existingTrip.setStartDate(updatedTrip.getStartDate());
		existingTrip.setEndDate(updatedTrip.getEndDate());
		existingTrip.setPrice(updatedTrip.getPrice());
		existingTrip.setCapacity(updatedTrip.getCapacity());
		existingTrip.setAvailableSeats(updatedTrip.getAvailableSeats());
		existingTrip.setDescription(updatedTrip.getDescription());
		existingTrip.setCreatedAt(LocalDateTime.now());
		existingTrip.setUpdatedAt(LocalDateTime.now());

		return tripRepository.save(existingTrip);
	}

	public void deleteTripById(Long id){
		tripRepository.deleteById(id);  
	}

}
