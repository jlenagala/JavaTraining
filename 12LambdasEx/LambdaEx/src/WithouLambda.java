interface Calculator {
	int powerCal(int x);

}

class CalculatorImpl implements Calculator {

	@Override
	public int powerCal(int x) {
		return x * x;
	}

}

public class WithouLambda {
	/*
	 *class files that are created is 
	 *WithouLambda.class
	 *Calculator.class
	 * CalculatorImpl.class
	 */

	public static void main(String[] args) {
		// object of reference to interface
		Calculator obj;
		// that reference can equal to object of class
		obj = new CalculatorImpl();
		System.out.println(obj.powerCal(3));

	}

}
