package com.example.jpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Customer;
import com.example.jpa.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public Page<Customer> getAllPosts(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@PostMapping("/customers")
	public Customer createPost(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable Long customerId, @Valid @RequestBody Customer customerRequest) {
		return customerRepository.findById(customerId).map(customer -> {
			customer.setCustomerName(customerRequest.getCustomerName());
			customer.setAddress(customerRequest.getAddress());
			return customerRepository.save(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("customerId " + customerId + " not found"));
	}

	@DeleteMapping("/posts/{customerId}")
	public ResponseEntity<?> deletePost(@PathVariable Long customerId) {
		return customerRepository.findById(customerId).map(customer -> {
			customerRepository.delete(customer);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
	}

}
