package com.dto;

import lombok.Data;

@Data
public class BookingRequestDTO {
	private Long customerId;
	private Long tripId;
	private int numberOfPeople;
}
