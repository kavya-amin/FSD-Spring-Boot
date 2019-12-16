package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public List<Employee> listAllEmployee();
	public Employee createEmployee(Employee theEmployee);
	public Optional<Employee> findByid(int id);
	public void delete(int id);
	public List<Employee> findByFirstNameAndLastName(String theFirstName,
			String theLastName);
	

}
 