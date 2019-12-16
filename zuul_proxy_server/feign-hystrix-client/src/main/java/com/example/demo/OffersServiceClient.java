package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("offer-service")
public interface OffersServiceClient {
	
	@RequestMapping(value = "/getCurrentOffer", method = RequestMethod.GET)
    public List<Offers> getCurrentOffers();

}
