package Example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Anton", 42));
		students.add(new Student("Kamala", 80));
		students.add(new Student("Nimala", 46));
		students.add(new Student("Anil", 98));
		students.add(new Student("Geetha", 61));

		List<Student> sorted = students.stream()
				.sorted((student1, student2) -> new Integer(student1.getName().length())
						.compareTo(student2.getName().length()))
				.collect(Collectors.toList());

		System.out.println(sorted);
	}

}
