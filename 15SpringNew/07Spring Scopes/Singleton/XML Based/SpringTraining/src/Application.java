import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService emplyeeService = applicationContext
				.getBean("employeeService",EmployeeService.class);
		
		System.out.println(emplyeeService.toString());
		EmployeeService emplyeeService2 = applicationContext
				.getBean("employeeService",EmployeeService.class);
		
		System.out.println(emplyeeService2.toString());
		List<Employee> employees=emplyeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName() +" at "+ employee.getEmployeeLocation());
			
		}
	}

}
