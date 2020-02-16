package tlp.javatraining.employeeservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tlp.javatraining.employeeservices.commonmodel.Allocation;
import tlp.javatraining.employeeservices.hystrixcommand.AllocationCommand;
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
    @LoadBalanced
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

    public Allocation[] fetchAllocation(Employee employee) {
        AllocationCommand allocationCommand = new AllocationCommand(employee, httpHeaders, restTemplate);
        return allocationCommand.execute();
    }

    @Override
    public Employee getAllocationByEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            //System.out.println("000- "+employee.getId());
         /*   ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
                    "http://allocation/alloservice/allofindbyemployee/" + employee.getId(),
                    // "http://localhost:8082/alloservice/allofindbyemployee/" + employee.getId(),
                    HttpMethod.GET,
                    httpEntity,
                    Allocation[].class);
           if (responseEntity.getStatusCode().value() == 200) {
                employee.setAllocations(responseEntity.getBody());
            }*/
            employee.setAllocations(fetchAllocation(employee));

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
