package com.boopathi.travel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boopathi.travel.model.Customer;
import com.boopathi.travel.repo.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updateCustomer) {

        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("customer not found"));

        existingCustomer.setFirstName(updateCustomer.getFirstName());
        existingCustomer.setLastName(updateCustomer.getLastName());
        existingCustomer.setEmail(updateCustomer.getEmail());
        existingCustomer.setPhoneNumber(updateCustomer.getPhoneNumber());
        existingCustomer.setAddress(updateCustomer.getAddress());
        existingCustomer.setDateOfBirth(updateCustomer.getDateOfBirth());
        existingCustomer.setCreatedAt(LocalDateTime.now());
        existingCustomer.setUpdatedAt(LocalDateTime.now());

        return customerRepository.save(existingCustomer);
    }

	public void deleteCustomer(Long id){
		customerRepository.deleteById(id);
	}

}
