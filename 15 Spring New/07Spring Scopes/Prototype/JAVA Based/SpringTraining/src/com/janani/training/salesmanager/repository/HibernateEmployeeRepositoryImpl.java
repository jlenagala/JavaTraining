package com.janani.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.janani.training.salesmanager.model.Employee;

@Repository("employeeRepositorySetter")//we can use any name
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	
	@Override
	public List<Employee> getAllEmployees(){
		
		List<Employee> employees=new ArrayList<>();
		Employee employee=new Employee();
		employee.setEmployeeName("Janani");
		employee.setEmployeeLocation("Ruwanwella");
		employees.add(employee);
		
		return employees;
		
	}
}
