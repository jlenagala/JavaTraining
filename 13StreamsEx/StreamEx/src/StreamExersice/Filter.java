
package StreamExersice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {
		
		
		HashMap<String, Integer> students = new HashMap<String, Integer>();
		students.put("Anton",42);
		students.put("Kamala", 77);
		students.put("Nimala",90);
		students.put("Anil", 25);
		students.put("Geetha", 61);
		students.put("Nayana", 99);
	

        
		Map<String, Integer>filterd = 
				students.entrySet()
				.stream()
				.filter((s1->(s1.getValue()>60)))
				.sorted()
				.collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));

		System.out.println(filterd);
	}

}
