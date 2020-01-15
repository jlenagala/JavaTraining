package annonymousInnerClass;

interface AnonymousBusStation {
	public void parking();
}

public class AnnonymousInnerClassDemo {

	public static void main(String[] args) {

		AnonymousBusStation anonymousBusStation = new AnonymousBusStation() {

			public void parking() {
				System.out.println("Invoke AnonymousBusStation parking()method");
			}
			
		};
		
		anonymousBusStation.parking();
	}
}
