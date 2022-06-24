package com.appdev.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/wish")
	public String sayHello() {
		return "Welcome to Spring Security application";
	}
	
	@RequestMapping("/fetchall")
	public List<Employee> fetchAllEmployee(){
		return employeeService.fetchAllEmployee();
		
	}
	@RequestMapping("/fetch/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.fetchEnployeeById(id);
	}
	
	@RequestMapping("/save")
	public String saveEmployee() {
		return "Save Completed";
	}
	
	
}
