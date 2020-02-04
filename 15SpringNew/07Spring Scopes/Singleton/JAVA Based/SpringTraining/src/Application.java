import java.applet.AppletContext;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

public class Application {
	/*
	 * 
	 * -------output (same instance---------
	 * 
	 * Setter executed
	 * com.janani.training.salesmanager.service.EmployeeServiceImpl@5e57643e
	 * com.janani.training.salesmanager.service.EmployeeServiceImpl@5e57643e Janani
	 * at Ruwanwella
	 */

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
		System.out.println(employeeService.toString());
		
		
		EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);
		System.out.println(employeeService.toString());
		
		// EmployeeService emplyeeService = new EmployeeServiceImpl();
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());

		}
	}

}
