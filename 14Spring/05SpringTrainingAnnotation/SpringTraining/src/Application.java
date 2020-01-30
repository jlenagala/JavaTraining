import java.util.List;

import com.janani.training.salesmanager.model.Employee;
import com.janani.training.salesmanager.service.EmployeeService;
import com.janani.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		EmployeeService emplyeeService = new EmployeeServiceImpl();
		List<Employee> employees=emplyeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName() +" at "+ employee.getEmployeeLocation());
			
		}
	}

}
