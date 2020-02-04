import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.janani")
@PropertySource("application.properties")
public class ApplicationConfiguration {

	@Bean(name = "employeeService")
	public EmployeeService getEmployeeService() {

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		// employeeServiceImpl.setEmployeeRepository(getEmployeeRepository());

		return employeeServiceImpl;
		// return new EmployeeServiceImpl();
	}
	@Bean(name = "propertySourcesPlaceholderConfigure")
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/*
	 * @Bean(name = "employeeRepository") public EmployeeRepository
	 * getEmployeeRepository() { return new HibernateEmployeeRepositoryImpl(); }
	 */
}
