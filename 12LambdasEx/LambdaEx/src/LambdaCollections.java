import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaCollections {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7);
		/*
		 * Consumer<Integer> c = i -> System.out.println(i);
		 */		
		
		list.forEach( i -> System.out.println(i));
	}

}
