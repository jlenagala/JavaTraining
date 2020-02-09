package tlp.javatraining.employeeservices.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlp.javatraining.employeeservices.model.Employee;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @RequestMapping("/hello")
    public String greeting() {
        return "hello world";

    }

	/*	How to manual change data format
			Add depenedency to the pom file
			@RequestMapping(value = "/employeesJSON",produces = APPLICATION_JSON_VALUE)
			@RequestMapping(value = "/employeesXML",produces = MediaType.APPLICATION_XML_VALUE)*/

    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return Employee.getAllEmployees();
    }


}
