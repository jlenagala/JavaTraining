package com.janani.training.salesmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.getAllEmployees();

	}
}
