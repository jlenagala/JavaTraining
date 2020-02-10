package tlp.javatraining.employeeservices.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employee")
public class Employee {
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	List<Telephone>telephones;
    @OneToOne(cascade = CascadeType.ALL)
    Address addresses;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
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