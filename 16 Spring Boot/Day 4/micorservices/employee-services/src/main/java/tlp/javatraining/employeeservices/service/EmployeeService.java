package tlp.javatraining.employeeservices.service;

import tlp.javatraining.employeeservices.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee getEmployee(Integer id);

    List<Employee> getAllEmployees();
    Employee getAllocationByEmployee(Integer id);
}
