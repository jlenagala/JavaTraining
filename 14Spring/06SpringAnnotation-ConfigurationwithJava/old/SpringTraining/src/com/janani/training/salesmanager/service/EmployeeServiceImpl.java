package com.janani.training.salesmanager.service;

import java.util.List;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
/*
	 * ---------Output------------
	 * Overload Cons 
	 * Janani at Ruwanwella
	 */
	EmployeeRepository employeeRepository;
	public EmployeeServiceImpl() {
		System.out.println("Default Cons");
	}


	/**
	 * @param employeeRepository
	 */
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overload Cons");
		this.employeeRepository = employeeRepository;
	}


	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}
