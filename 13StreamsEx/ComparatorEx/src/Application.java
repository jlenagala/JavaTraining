import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * using studentRanker
 *
*/
public class Application {

	public static void main(String[] args) {
		
	        List<Student> students = new ArrayList<>();
	        students.add(new Student("Anton", 42));
	        students.add(new Student("Kamala", 80));
	        students.add(new Student("Nimala", 46));
	        students.add(new Student("Anil", 98));
	        students.add(new Student("Geetha", 61));
	        
		Collections.sort(students,new StudentRanker());
		System.out.println(students);

	}

}
