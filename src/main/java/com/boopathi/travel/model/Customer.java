package com.boopathi.travel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private LocalDate dateOfBirth;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(nullable=false)
	private LocalDateTime updatedAt = LocalDateTime.now(); 

	@PrePersist
	protected void onCreate(){
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;  
        this.updatedAt = now;
		
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = LocalDateTime.now();
	}
	

}
