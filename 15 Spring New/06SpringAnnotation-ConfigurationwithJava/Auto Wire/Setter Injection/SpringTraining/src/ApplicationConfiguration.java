import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.janani.training.salesmanager.repository.EmployeeRepository;
import com.janani.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.janani")
public class ApplicationConfiguration {

	@Bean(name = "employeeService")
	public EmployeeService getEmployeeService() {

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

		return employeeServiceImpl;

		// return new EmployeeServiceImpl();
	}
////we can remove that bean using @repository annotaion in repository class
//	@Bean(name = "employeeRepository")
//	public EmployeeRepository getEmployeeRepository() {
//		return new HibernateEmployeeRepositoryImpl();
//	}
}
