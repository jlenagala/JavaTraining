package tlp.javatraining.employeeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication()
@EnableEurekaClient
@EnableCircuitBreaker
public class EmployeeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServicesApplication.class, args);
	}

}
