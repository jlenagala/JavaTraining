package com.janani.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	//@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		System.out.println("Default Cons");
	}
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overload Cons");
		this.employeeRepository = employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Stter inj");
		this.employeeRepository = employeeRepository;

	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}

}
