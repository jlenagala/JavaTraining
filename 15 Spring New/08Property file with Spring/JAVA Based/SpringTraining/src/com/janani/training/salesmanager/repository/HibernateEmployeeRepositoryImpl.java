package com.janani.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.janani.training.salesmanager.model.Employee;

@Repository("employeeRepositorySetter")//we can use any name
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	@Value("${name}")
	private String empName;
	
	@Value("${city}")
	private String empCity;
	@Override
	public List<Employee> getAllEmployees(){
		
		List<Employee> employees=new ArrayList<>();
		Employee employee=new Employee();
		employee.setEmployeeName(empName);
		employee.setEmployeeLocation(empCity);
		employees.add(employee);
		
		return employees;
		
	}
}
