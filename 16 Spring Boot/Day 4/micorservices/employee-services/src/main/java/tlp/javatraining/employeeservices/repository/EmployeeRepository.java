package tlp.javatraining.employeeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tlp.javatraining.employeeservices.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //Employee save(Employee employee);
}
