package com.student.springboot.service;

import java.util.List;

import com.student.springboot.modal.Employee;

public interface EmployeeServices{
	public Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	
	Employee getAllEmployeeByid(long id);
	
	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);
}
