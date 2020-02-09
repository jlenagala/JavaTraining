package tlp.javatraining.employeeservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    private Integer id;
	private String name;
    private String city;

	public Employee() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				'}';
	}

	/*public static List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Anton", 42));
        employees.add(new Employee("Kamala", 80));
        employees.add(new Employee("Nimala", 46));
        employees.add(new Employee("Anil", 98));
        employees.add(new Employee("Geetha", 61));

        return employees;

    }*/

}