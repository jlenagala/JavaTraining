package tlp.javatraining.employeeservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlp.javatraining.employeeservices.model.Employee;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @RequestMapping("/hello")
    public String greeting() {
        return "hello world";

    }

    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
       // return Employee.getAllEmployees();
        return null;
    }
    @RequestMapping(value = "/employees/{id}")
    public Employee getAllEmployees(@PathVariable int id) {
        if (id==10){

            Employee employee=new Employee();
            System.out.println(id);
            employee.setId(id);
            employee.setName("janani");
            employee.setCity("Gampaha");
            return employee;
        }
        else {
            return null;
        }
    }

}
