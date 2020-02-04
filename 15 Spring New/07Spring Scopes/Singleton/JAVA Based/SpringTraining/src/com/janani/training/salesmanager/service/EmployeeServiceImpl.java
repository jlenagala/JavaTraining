package com.janani.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	/*
	 * ---------Output------------
	 Default Cons
	 Setter excuted
	 Janani at Ruwanwella
	 */
	
	EmployeeRepository employeeRepository;
	public EmployeeServiceImpl() {
		System.out.println("Default Cons");
	}
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overload Cons");
	}
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter excuted");
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}

