package com.student.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.springboot.exception.ResourceNotFoundException;
import com.student.springboot.modal.Employee;
import com.student.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee save = repo.save(employee);
		return save;
		// return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> all = repo.findAll();
		return all;
	}

	@Override
	public Employee getAllEmployeeByid(long id) {
		/*
		 * Optional<Employee> byId = repo.findById(id); if(byId.isPresent()) { return
		 * byId.get();
		 * 
		 * }else { throw new ResourceNotFoundException("Employee", "id", id); }
		 */
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		// save existingEmployee to db
		repo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		repo.findById(id).orElseThrow(()->
		              new ResourceNotFoundException("Employee", "id", id));
		repo.existsById(id);
	}

}
