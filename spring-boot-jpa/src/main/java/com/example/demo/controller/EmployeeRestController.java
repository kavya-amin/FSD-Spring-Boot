package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	
	
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}



	@RequestMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		 employeeService.save(employee);
		 
		 return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		return employeeService.update(theEmployee);
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee with give id "+employeeId+" is not found");
		}
		return theEmployee;
	}
	
	@DeleteMapping("/emp/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee with give id "+employeeId+" is not found");
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee Id: "+employeeId;
	}
	
	
	@GetMapping("/{email}")
	public List<Employee> getEmployeeByEmail(@PathVariable String email) {
		List<Employee> theEmployee=employeeService.findByEmail(email);
		if(theEmployee == null) {
			throw new RuntimeException("Employee with give id "+email+" is not found");
		}
		return theEmployee;
	}
}
