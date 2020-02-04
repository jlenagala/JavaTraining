package com.janani.training.salesmanager.service;

import java.util.List;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	/*
	 * private EmployeeRepository employeeRepository;
	 * 
	 * public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	 * this.employeeRepository = employeeRepository; }
	 */
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}
