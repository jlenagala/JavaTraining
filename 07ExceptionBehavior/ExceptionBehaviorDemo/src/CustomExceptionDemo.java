public class CustomExceptionDemo extends Exception {

	public static void main(String[] args) {

		int i = 5;
		try {
			if (i < 10)
				throw new MyExceptions("Error");
		}

		catch (MyExceptions e) {
			System.out.println(e);
		}

	}

}

class MyExceptions extends Exception {

	public MyExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
