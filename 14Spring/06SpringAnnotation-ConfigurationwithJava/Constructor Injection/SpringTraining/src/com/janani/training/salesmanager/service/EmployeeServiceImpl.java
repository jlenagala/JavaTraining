package com.janani.training.salesmanager.service;

import java.util.List;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	/*
	 * public EmployeeServiceImpl() { System.out.println("Default Cons"); }
	 */

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overload Cons");
		this.employeeRepository = employeeRepository;
	}

	/*
	 * public void setEmployeeRepository(EmployeeRepository employeeRepository) {
	 * this.employeeRepository = employeeRepository;
	 * 
	 * }
	 */

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}

}
