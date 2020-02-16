package tlp.javatraining.employeeservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tlp.javatraining.employeeservices.commonmodel.Allocation;
import tlp.javatraining.employeeservices.model.Employee;
import tlp.javatraining.employeeservices.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;
    @Autowired
    RestTemplate restTemplate;
    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee;
        } else
            return null;
    }

    @Override
    public Employee getAllocationByEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
                    "http://localhost:8082/alloservice/allofindbyemployee/" + employee.getId(),
                    HttpMethod.GET,
                    httpEntity,
                    Allocation[].class);
            if (responseEntity.getStatusCode().value() == 200) {
                employee.setAllocations(responseEntity.getBody());
            }
            // employee.setAllocations(responseEntity.getBody());
            return employee;
        } else
            return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
