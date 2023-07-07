package com.appdev.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@RequestMapping("/count")
	public Integer getCustomerCount() {
		return customerService.getCustomerCount();
	}

	@RequestMapping("/email/{id}")
	public String getCustomerEmail(@PathVariable Integer id) {
		System.out.println(id);
		return customerService.getCustomerEmail(id);
	}
	
	@RequestMapping("/countProc")
	public Integer fetchCustomerCountProcedure() {
		return customerService.fetchCustomerCountProcedure();
	}
	
	@RequestMapping("/emailProcedure/{id}")
	public String fetchCustomerEmailProcedure(@PathVariable Integer id) {
		return customerService.fetchCustomerEmailProcedure(id);
	}
}
