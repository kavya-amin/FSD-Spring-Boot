package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService  {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> searchById(long theId) {
		return employeeRepository.findById(theId);
	}
	
	
	/**private static List<Employee> employeeRepsitory = null;

	static {

		employeeRepsitory = new ArrayList<Employee>();
		employeeRepsitory.add(createEmployee(1L, "John", "Embedded C++", "Architect"));
		employeeRepsitory.add(createEmployee(2L, "Rahul", "Cloud", "Senior Developer"));

	}

	private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {

		Employee emp = new Employee();

		emp.setEmployeeId(id);

		emp.setName(name);

		emp.setPracticeArea(practiceArea);

		emp.setDesignation(designation);

		emp.setCompanyInfo("IBM");

		return emp;

	}

	public Collection<Employee> findAll() {

		return employeeRepsitory;

	}**/

}
