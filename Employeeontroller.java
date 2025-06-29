package com.student.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.springboot.modal.Employee;
import com.student.springboot.service.EmployeeServices;

@RestController
@RequestMapping("/api/employees")
public class Employeeontroller {
	@Autowired
	private EmployeeServices employeeServices;
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	@GetMapping
	//build get all Employee
	public List<Employee>getAllEmployee(){
		List<Employee> allEmployee = employeeServices.getAllEmployee();
		return allEmployee;
		
	}
	@GetMapping("{id}")
	//build  get Employee by  id
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable("id")  long id){
		
		return new ResponseEntity<Employee>( employeeServices.getAllEmployeeByid(id),HttpStatus.OK);
		
	}
	//build update employee Rest api
	@PutMapping("{id}")
	public  ResponseEntity<Employee> updateEmployee (@PathVariable("id") long id ,@RequestBody Employee employee  ){
		return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee, id),HttpStatus.OK);
		
	}
	//build delete employee Rest api
	@DeleteMapping("{id}")
	public  ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
		employeeServices.deleteEmployee(id);
		return new ResponseEntity<String> ("Employee delete successfully!",HttpStatus.OK);
	}

}
