package com.appdev.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.app.entity.Employee;
import com.appdev.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/salary")
	public Integer getEmployeeSalary(@RequestParam String empName,@RequestParam Integer deptId) {
		return employeeService.getEmployeeSalary(empName,deptId);
	}
	@RequestMapping("/isEligible/{id}")
	public Boolean getEmployeeSalary(@PathVariable Integer id) {
		return employeeService.isEligibleForBonus(id);
	}
	
	@RequestMapping("/empsalarydept/{id}")
	public Map<String,Object> fetchEmployeeSalaryDeptProcedure(@PathVariable Integer id){
		return employeeService.fetchEmployeeSalaryDeptProcedure(id);
	}
	@RequestMapping("/empdetails/{id}")
	public Employee fetchEmployeeDetails(@PathVariable Integer id) {
		return employeeService.fetchEmployeeDetails(id);
	}
}
