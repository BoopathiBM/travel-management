package com.boopathi.travel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boopathi.travel.model.Trip;
import com.boopathi.travel.service.TripService;

@RestController
@RequestMapping("/api/trips")
public class TripController {

	@Autowired
	private TripService tripService;


	@GetMapping
	private List<Trip> getAllTrip(){
		return tripService.getAllTrip();
	}

	@GetMapping("/{id}")
	public Optional<Trip> getTripById(@PathVariable Long id){
		return tripService.getTripById(id);		
	}

	@PostMapping
	public Trip createTrip(@RequestBody Trip trip){
		return tripService.createTrip(trip);
	}

	@PutMapping("/{id}")
	public Trip updateTrip(@PathVariable Long id,@RequestBody Trip trip){
		 return tripService.updateTrip(id, trip);
	}

	@DeleteMapping("/{id}")
	public void deleteTrip(@PathVariable Long id){
		tripService.deleteTripById(id);
	}



}
