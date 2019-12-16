package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.save(theEmployee);
		return employee;
	}

	@Override
	public Optional<Employee> findByid(int id) {
		// TODO Auto-generated method stub
Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return result;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByFirstNameAndLastName(String theFirstName, String theLastName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(theFirstName, theLastName);
	}

}
