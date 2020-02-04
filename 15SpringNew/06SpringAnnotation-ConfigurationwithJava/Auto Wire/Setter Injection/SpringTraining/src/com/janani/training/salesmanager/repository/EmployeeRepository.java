package com.janani.training.salesmanager.repository;

import java.util.List;

import com.janani.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}