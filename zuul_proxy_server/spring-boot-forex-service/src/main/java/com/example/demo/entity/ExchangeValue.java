package com.example.demo.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeValue {
	  private Long id;
	  private String from;
	  private String to;
	  private BigDecimal conversionMultiple;
	  private int port;

}
