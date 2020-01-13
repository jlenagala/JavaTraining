/**
 * Demo 01-How works exception
 *
 * (unchecked Exception)
 */

/**
 * @author Dell
 *
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i, j, k = 0;
		i = 0;
		j = 3;
		//Unchecked exception
		try {
			k = j / i;
		} 
		catch (Exception e) {
			System.out.println("Cannot divide by zero");
		}
		System.out.println(k);

	}

}
