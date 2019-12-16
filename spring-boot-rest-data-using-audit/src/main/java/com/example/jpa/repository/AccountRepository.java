package com.example.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Page<Account> findByCustomerId(Long customerId, Pageable pageable);

	Optional<Account> findByIdAndCustomerId(Long accountId, Long customerId);

}
