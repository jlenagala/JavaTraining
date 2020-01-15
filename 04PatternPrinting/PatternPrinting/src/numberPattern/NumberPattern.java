package numberPattern;

public class NumberPattern {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.print(i + " \t");
		}
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");

		for (int i = 1; i < 10; i++) {
			
			System.out.print(i + " | \t");

			for (int j = 1; j < 10; j++) {
				
				System.out.print(i * j + "\t");
				System.out.print(" ");
				
			}
			
			System.out.println("");
		}

	}

}
