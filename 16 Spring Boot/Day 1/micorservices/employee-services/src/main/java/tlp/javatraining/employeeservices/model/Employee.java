package tlp.javatraining.employeeservices.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private int marks;

public Employee(String name, int marks) {
	this.name = name;
	this.marks = marks;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}
	
	

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

	public static List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Anton", 42));
		employees.add(new Employee("Kamala", 80));
		employees.add(new Employee("Nimala", 46));
		employees.add(new Employee("Anil", 98));
		employees.add(new Employee("Geetha", 61));
		
		return employees;

	}

}