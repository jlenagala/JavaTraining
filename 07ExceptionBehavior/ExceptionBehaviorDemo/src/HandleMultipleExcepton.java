/*
 * Handle multiple exception
 * 			 -- When once you get a error it directly jump into catch exception
 * 				so it will jump into first exception catch block
 * 			 -- When writing a main exception you must write it in last catch block, because 
 *              the exception catch by main exception block we can not handle it again.
 *              so it will show error in specific catch blocks
 */
public class HandleMultipleExcepton {

	public static void main(String[] args) {
		int i, j, k = 0;
		i = 0;
		j = 3;

		int arr[] = new int[4];
		// Unchecked exception
		try {
			k = j / i;

			for (int x = 0; x <= 4; x++) {
				arr[x] = x;
			}

		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Maximum number of value is 4");
		} catch (Exception e) {
			System.out.println("Exception occurs");
		}
		System.out.println(k);

	}

}
