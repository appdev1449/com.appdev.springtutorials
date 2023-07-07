package com.appdev.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.appdev.app.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	//Function call with NO inputs but returns INT type output
	@Query(value="select get_customer_count()",nativeQuery=true)
	public Integer fetchCustomerCount();
	
	@Query(value="select get_customer_email(?1)",nativeQuery=true)
	public String fetchCustomerEmail(Integer id);
	
	@Procedure(value="get_customer_count_proc")
	public Integer fetchCustomerCountProcedure();
	
	@Procedure("get_customer_email_proc")
	public String fetchCustomerEmailProcedure(Integer customerId);

}
