package com.janani.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
@Component
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {

	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}
