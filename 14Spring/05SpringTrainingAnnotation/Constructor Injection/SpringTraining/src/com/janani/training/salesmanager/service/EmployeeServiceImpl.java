package com.janani.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	/*
	 * @Autowired EmployeeRepository employeeRepository;
	 */

	EmployeeRepository employeeRepository;

	/*
	 * public EmployeeServiceImpl() {
	 * 
	 * }
	 */

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Constructor inject");
		this.employeeRepository = employeeRepository;
	}
	/*
	 * @Autowired public void setEmployeeRepository(EmployeeRepository
	 * employeeRepository) { System.out.println("Setter inject");
	 * this.employeeRepository = employeeRepository; }
	 */

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}
