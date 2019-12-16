package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@RefreshScope

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired

	EmployeeService employeeSearchService;

	@RequestMapping("/employees")
	public Collection<Employee> findAll() {
		return employeeSearchService.findAll();

	}
	
	@GetMapping("/employee/{theId}")
	public Optional<Employee> findById(@PathVariable long theId){
		return employeeSearchService.searchById(theId);
		
	}


}
