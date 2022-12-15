package com.sam.springboot.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springboot.entity.Employee;
import com.sam.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService serv;
	
	@PostMapping
	public Employee setEmployees(@RequestBody Employee emp)
	{
		return serv.storeEmp(emp);	
	}
	@GetMapping
	public List<Employee> getEmployees()
	{
		return serv.readAll();
		
	}
	
	@GetMapping(path = "/name")
	public List<Employee> SortEmployeesbyName()
	{
		return serv.sortName();
		
	}
	@GetMapping(path = "/age")
	public List<Employee> SortEmployeesbyage()
	{
		return serv.sortAge();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployee(@PathVariable(value = "id") long id)
	{
		return serv.read(id);
	}
	
	@PutMapping
	public Employee putEmployees(@RequestBody Employee emp)
	{
		return serv.updateEmp(emp);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		serv.deleteEmp(id);
		return "deleted - "+id;
	}
	
}
