package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotBlank(message="is required")
	@Column(name = "first_nmae")
	private String firstName;
	@NotBlank(message="is required")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank(message="is required")
	private String email;

}
