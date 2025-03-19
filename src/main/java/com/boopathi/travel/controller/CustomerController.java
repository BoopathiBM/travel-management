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

import com.boopathi.travel.model.Customer;
import com.boopathi.travel.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Long id){
		return customerService.getCustomerById(id);
	}

	@PostMapping
	public Customer CreateCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer){
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable Long id){
		customerService.deleteCustomer(id);
	}

	

}
