package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Login;

public interface LoginRepository extends MongoRepository<Login, Integer> {

	public Login findByLogin(Login login);
}
