package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
	@Autowired
	private OfferServiceRepository ofServiceRepository;
	
	public Offers createOffer(Offers offers) {
		Offers offer= ofServiceRepository.save(offers);
		return offer;
	}
	
	public List<Offers> getAllOffers(){
		return ofServiceRepository.findAll();
	}
}
