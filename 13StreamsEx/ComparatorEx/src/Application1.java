import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*without using studentRanker
 * using Lambda
 * 
 *
*/
public class Application1 {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student("Anton", 42));
		students.add(new Student("Kamala", 80));
		students.add(new Student("Nimala", 46));
		students.add(new Student("Anil", 98));
		students.add(new Student("Geetha", 61));
		Comparator<Student> studentComparator = (student1,
				student2) -> ((student1.getMarks() > student2.getMarks()) ? +1
						: (student1.getMarks() < student2.getMarks()) ? -1 : 0);
		Collections.sort(students, studentComparator);
		System.out.println(students);

	}

}
