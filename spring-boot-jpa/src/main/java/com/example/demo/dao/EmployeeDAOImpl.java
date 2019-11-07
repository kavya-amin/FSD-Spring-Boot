package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private EntityManager entityManager;
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}
	@Override
	public void save(Employee employee) {
	
		Employee theEmployee = entityManager.merge(employee);
		employee.setEmployeeId(theEmployee.getEmployeeId());
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmployee=entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmployee=entityManager.find(Employee.class, theId);
		entityManager.remove(theEmployee);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createQuery("from Employee e where e.email=:email", Employee.class);
		theQuery.setParameter("email", email);
		return theQuery.getResultList();
	}

}
