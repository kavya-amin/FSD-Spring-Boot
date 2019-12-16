package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferServiceRepository extends MongoRepository<Offers, String> {

}
