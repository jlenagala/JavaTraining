package tlp.javatraining.employeeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tlp.javatraining.employeeservices.model.Employee;
import tlp.javatraining.employeeservices.model.Project;
import tlp.javatraining.employeeservices.model.Telephone;
import tlp.javatraining.employeeservices.service.EmployeeService;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        //to set the data to each employee--->to fullfil the null value problem
        if (employee.getTelephones() != null)
            for (Telephone telephone : employee.getTelephones())
                telephone.setEmployee(employee);
        if (employee.getProjects() != null) {
            for (Project project : employee.getProjects()) {
                if (project.getEmployees() != null)
                    project.getEmployees().add(employee);
            }

        }
            return employeeService.save(employee);
        }

    }

