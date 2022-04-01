package com.workmotion.repository;

import com.workmotion.model.Employee;
import com.workmotion.service.EmployeeService;

public class EmployeeRepository {
	
	private EmployeeService employeeService = new EmployeeService();
	
	public Employee saveEmployee(Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
}
