
package StreamExersice;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {

		HashMap<String, Integer> students = new HashMap<String, Integer>();
		students.put("Anton", 42);
		students.put("Kamala", 77);
		students.put("Nimala", 90);
		students.put("Anil", 25);
		students.put("Geetha", 61);
		students.put("Nayana", 99);

		List<String> filterd = students.keySet().stream().filter((s) -> students.get(s) > 60).sorted()
				.collect(Collectors.toList());

		System.out.println(filterd);

	}

}
