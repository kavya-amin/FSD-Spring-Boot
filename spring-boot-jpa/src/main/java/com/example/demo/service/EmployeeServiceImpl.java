package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeDAO.findByEmail(email);
	}

}
