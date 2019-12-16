package com.example.demo.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;

	@Column(name="name")
	   private String name;

	@Column(name="practice_area")
	   private String practiceArea;

	@Column(name="destination")
	   private String designation;

	   private String companyInfo;
}
