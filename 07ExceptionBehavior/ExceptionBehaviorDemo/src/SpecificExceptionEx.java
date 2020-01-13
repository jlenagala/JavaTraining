//Demo2 - Using Specific exception
public class SpecificExceptionEx {

	public static void main(String[] args) {

		int i, j, k = 0;
		i = 0;
		j = 3;
		//Unchecked exception
		try {
			k = j / i;
		} 
		catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}
		System.out.println(k);

	}

}
