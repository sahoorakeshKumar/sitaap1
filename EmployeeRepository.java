package com.student.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.springboot.modal.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
