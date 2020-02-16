package tlp.javatraining.employeeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tlp.javatraining.employeeservices.model.Employee;
import tlp.javatraining.employeeservices.model.Telephone;
import tlp.javatraining.employeeservices.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping(value = "/findbyid/{id}",method = RequestMethod.GET)
    public Employee getAllemployeesById(@PathVariable int id) {
        Employee employee = employeeService.getAllocationByEmployee(id);
        return employee;
    }


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> findAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        //to set the data to each employee--->to fullfil the null value problem
        if (employee.getTelephones() != null) {
            for (Telephone telephone : employee.getTelephones()) {
                telephone.setEmployee(employee);
            }
        }
        return employeeService.save(employee);
    }

}

