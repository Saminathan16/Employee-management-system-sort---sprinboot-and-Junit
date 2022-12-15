package com.sam.springboot.service;

import java.util.List;
import java.util.Optional;

import com.sam.springboot.entity.Employee;

public interface EmployeeService {

	List<Employee> readAll();

	Optional<Employee> read(long id);

	Employee storeEmp(Employee emp);

	List<Employee> sortName();

	List<Employee> sortAge();

	Employee updateEmp(Employee emp);

	void deleteEmp(long id);
	
}
