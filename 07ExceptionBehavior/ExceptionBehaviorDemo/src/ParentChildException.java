/*
 * Cannot catch parent exception from child Exception
 */
public class ParentChildException {

	public static void main(String[] args) {
	    try {
            throw new RuntimeException();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException");
        }
    

	}

}
