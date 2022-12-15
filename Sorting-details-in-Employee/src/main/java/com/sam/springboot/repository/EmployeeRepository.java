package com.sam.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.springboot.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
