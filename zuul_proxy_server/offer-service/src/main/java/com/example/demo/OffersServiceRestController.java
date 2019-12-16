package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OffersServiceRestController {
	
	@Autowired
	private OfferService offerService;
	
	@PostMapping("/offers")
	public Offers createOffer(@RequestBody Offers offers) {
		return offerService.createOffer(offers);
	}
	
	@RequestMapping(value = "/getCurrentOffer", method = RequestMethod.GET)
	@ResponseBody
	public List<Offers> getCurrentOffers() {
		return offerService.getAllOffers();
	}
}