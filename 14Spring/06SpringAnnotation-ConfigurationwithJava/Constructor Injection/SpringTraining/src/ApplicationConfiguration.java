import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {

	@Bean(name = "employeeService")
	public EmployeeService getEmployeeService() {

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl(getEmployeeRepository());

		return employeeServiceImpl;

		// return new EmployeeServiceImpl();
	}

	@Bean(name = "employeeRepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
	}
}
