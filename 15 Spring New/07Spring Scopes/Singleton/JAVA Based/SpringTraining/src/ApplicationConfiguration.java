import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.janani")
public class ApplicationConfiguration {
	
		
	@Bean(name = "employeeService")
	@Scope("singleton")
	public EmployeeService getEmployeeService() {
		
		EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
		//employeeServiceImpl.setEmployeeRepository(getEmployeeRepository());
		
		return employeeServiceImpl ;
		//return new EmployeeServiceImpl();
	}

	/*
	 * @Bean(name = "employeeRepository") public EmployeeRepository
	 * getEmployeeRepository() { return new HibernateEmployeeRepositoryImpl(); }
	 */
}
