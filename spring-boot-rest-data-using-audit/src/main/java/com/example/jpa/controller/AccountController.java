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

import com.example.jpa.entity.Account;
import com.example.jpa.repository.AccountRepository;
import com.example.jpa.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers/{customerId}/accounts")
	public Page<Account> getAllCustomersByCustomerId(@PathVariable(value = "customerId") Long customerId, Pageable pageable) {
		return accountRepository.findByCustomerId(customerId, pageable);
	}

	@PostMapping("/customers/{customerId}/accounts")
	public Account createAccount(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Account account) {
		return customerRepository.findById(customerId).map(customer -> {
			account.setCustomer(customer);
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("customerId " + customerId + " not found"));
	}

	@PutMapping("/customers/{customerId}/accounts/{accountId}")
	public Account updateAccount(@PathVariable(value = "customerId") Long customerId,
			@PathVariable(value = "accountId") Long accountId, @Valid @RequestBody Account accountRequest) {
		if (!customerRepository.existsById(customerId)) {
			throw new ResourceNotFoundException("CustomerId " + customerId + " not found");
		}

		return accountRepository.findById(accountId).map(account -> {
			account.setAccoutType(accountRequest.getAccoutType());
			account.setActive(accountRequest.isActive());
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("AccountId " + accountId + "not found"));
	}

	@DeleteMapping("/customers/{customerId}/accounts/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable(value = "customerId") Long customerId,
			@PathVariable(value = "accountId") Long accountId) {
		return accountRepository.findByIdAndCustomerId(accountId, customerId).map(account -> {
			accountRepository.delete(account);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Account not found with id " + accountId + " and customerId " + customerId));
	}
}
