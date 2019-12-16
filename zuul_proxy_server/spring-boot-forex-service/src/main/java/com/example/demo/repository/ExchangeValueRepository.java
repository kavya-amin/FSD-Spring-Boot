package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.ExchangeValue;

public interface ExchangeValueRepository extends MongoRepository<ExchangeValue, Integer> {
	ExchangeValue findByFromAndTo(String from, String to);
}
