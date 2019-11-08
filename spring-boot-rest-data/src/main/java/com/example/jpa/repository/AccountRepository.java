package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
