package com.appdev.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public List<Employee> fetchAllEmployee(){
		List<Employee> employeeList = new ArrayList();
		employeeList.add(new Employee(1,"John"));
		employeeList.add(new Employee(2,"Ram"));
		return employeeList;
	}

	public Employee fetchEnployeeById(String id) {
		// TODO Auto-generated method stub
		return new Employee(1,"King");
	}
}
