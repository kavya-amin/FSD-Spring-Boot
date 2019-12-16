package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listAllEmployee(Model theModel){
		List<Employee>  theEmployees = employeeService.listAllEmployee();
		theModel.addAttribute("employees",theEmployees);
		return "list-employee";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel){
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") @Valid Employee theEmployee,
			BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "employees/employee-form";
		}
		else {		
			// save the employee
			employeeService.createEmployee(theEmployee);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/employees/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("id") int id, Model theModel)
	{
		
		Optional<Employee> theEmployee= employeeService.findByid(id);
		
		theModel.addAttribute("employee",theEmployee);
		return "employees/update-form";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id)
	{
		employeeService.delete(id);
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 @RequestParam("lastName") String theLastName,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all employees

		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		else {
			// else, search by first name and last name
			List<Employee> theEmployees =
							employeeService.findByFirstNameAndLastName(theFirstName, theLastName);
			
			// add to the spring model
			theModel.addAttribute("employees", theEmployees);
			
			// send to list-employees
			return "list-employee";
		}
	}
	
}