package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public void save(Employee employee);
	public Employee update(Employee employee);
	public Employee findById(int theId);
	public void deleteById(int theId);
	public List<Employee> findByEmail(String email);
}
