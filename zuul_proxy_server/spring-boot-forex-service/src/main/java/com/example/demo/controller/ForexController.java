package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ExchangeValue;
import com.example.demo.repository.ExchangeValueRepository;

@RestController
public class ForexController {
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@PostMapping("/create")
	public ExchangeValue createExchangeValue(@RequestBody ExchangeValue exchangeValue) {
		
		ExchangeValue exValue = exRepository.save(exchangeValue);
		return exValue;
		
	}

}
