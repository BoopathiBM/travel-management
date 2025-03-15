package com.boopathi.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boopathi.travel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
