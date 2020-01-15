package localInnerClassEx;

class BusStation

{

	public void busStationtimeCal() {

		System.out.println("Invoke BusStation timeCal() method");

		// inner class
		class Bus {
			public void busRun() {
				System.out.println("Invoke Bus run() method ");

			}

		}
		// innerclass -instantiating
		Bus bus = new Bus();
		bus.busRun();
	}

//	public void parking() {
//		System.out.println("Invoke BusStation parking()method");
//	}
}

public class LocalInnerClassDemo {

	public static void main(String[] args) {
		// invoke outer class method
		BusStation busStation = new BusStation();
		busStation.busStationtimeCal();
		// busStation.parking();

	}

}
