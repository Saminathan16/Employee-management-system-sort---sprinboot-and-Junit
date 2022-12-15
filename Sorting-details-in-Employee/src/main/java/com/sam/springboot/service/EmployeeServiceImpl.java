package com.sam.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.springboot.entity.Employee;
import com.sam.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> readAll() {
		// TODO Auto-generated method stub
		return (List<Employee>) repo.findAll();
	}

	@Override
	public Optional<Employee> read(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Employee storeEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public List<Employee> sortName() {
		// TODO Auto-generated method stub
		List<Employee> emp= (List<Employee>) readAll();
		int size=emp.size();
		System.out.println(emp);
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				String s1 = emp.get(i).getFirstName()+" "+emp.get(i).getLastName();
				String s2 = emp.get(j).getFirstName()+" "+emp.get(j).getLastName();
				if(s1.compareTo(s2)>0)
				{
					Collections.swap(emp, i, j);
				}
			}
		}
		System.out.println(emp);
		return emp;
	}

	@Override
	public List<Employee> sortAge() {
		// TODO Auto-generated method stub
		List<Employee> emp= (List<Employee>) readAll();
		int size=emp.size();
		System.out.println(emp);
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
			    if(emp.get(i).getAge()>emp.get(j).getAge())
				{
					Collections.swap(emp, i, j);
				}
			}
		}
		System.out.println(emp);
		return emp;
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public void deleteEmp(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
