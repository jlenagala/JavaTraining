import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		// 1. configure soring beans in applicationContext.xml
		// 2. load the spring configuration file(create spring container)
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 3. retrieve beans from container
		//     --employeeService== beanId & EmployeeService.class==corresponding bean id's Impl class's interface
		EmployeeService emplyeeService = applicationContext
				.getBean("employeeService",EmployeeService.class);
		
		// 4. call methods in bean
		List<Employee> employees=emplyeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName() +" at "+ employee.getEmployeeLocation());
			
		}
	}

}
