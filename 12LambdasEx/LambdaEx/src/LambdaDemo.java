interface CalculatorLambda {
	int powerCal(int x);

}

/*
 * class CalculatorImpl implements Calculator {
 * 
 * @Override public int powerCal(int x) {
 * 
 * return x * x; }
 * 
 * }
 */
public class LambdaDemo {

	public static void main(String[] args) {
		/*
		 * 
		 * 
		 * CalculatorLambda obj;
		 * 
		 * obj = new CalculatorLambda() {
		 * 
		 * @Override public int powerCal(int x) {
		 * 
		 * return x*x;
		 * 
		 * } };
		 */
		/*
		 * class files that are created is
		 * LambdaDemo.class
		 * CalculatorLambda.class
		 * LambdaDemo$1.class-Annonymous class
		 */
		/*
		 * 
		 *---- We can remove curly braces, 
		 * because the only one line is within the body-----
		 * CalculatorLambda obj =(int x)-> {
		 * 
		 * return x * x;
		 * 
		 * };
		 */
		/*
		 * when using Labda, class files that are created is
		 * LambdaDemo.class
		 * CalculatorLambda.class
		 * 
		 */

		/*
		CalculatorLambda obj = (int x) -> x * x;
		*/

		/*
		CalculatorLambda obj = (x) -> x * x;

		*/
		CalculatorLambda obj = x -> x * x;

		System.out.println(obj.powerCal(4));
	}
}
