package com.appdev.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.app.entity.Employee;
import com.appdev.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Integer getEmployeeSalary(String empName,Integer deptId) {
		System.out.println(empName);
		System.out.println(deptId);
		return employeeRepository.getEmployeeSalary(empName,deptId);
	}
	
	public Boolean isEligibleForBonus(Integer empId) {

		return employeeRepository.isEligibleForBonus(empId);
	}
	
		
	public Map<String, Object> fetchEmployeeSalaryDeptProcedure(Integer id){
		return employeeRepository.fetchEmployeeSalaryDeptProcedure(id);
	}
	
	public Employee fetchEmployeeDetails(Integer id) {
		return employeeRepository.fetchEmployeeDetails(id);
	}
}
