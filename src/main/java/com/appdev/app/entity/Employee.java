package com.appdev.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity

@NamedStoredProcedureQuery(name = "employee.salarydept"
,procedureName = "get_employee_salary_dept_proc"
,parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name="employee_id", type=Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name="emp_name", type=String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name="salary", type=Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name="deptname", type=String.class),
}
)
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="name")
	private String employeeName;

	@Column(name="dept_id")
	private Integer deptId;


	@Column(name="salary")
	private Integer salary;

	@Column(name="status")
	private Boolean status;
	
	@Column(name="performance")
	private String performance;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	

}
