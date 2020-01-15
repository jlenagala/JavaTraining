package memberInnerClass;
class BusStation

{
	// private variable - outer class
	private int stationId = 1;

	// inner class
	class Bus {
		// Accessing outer class private variable
		public int getStationId() {
			System.out.println("member class vlaue");
			return stationId;
		}
	}
}

public class MemberClassDemo {

	public static void main(String[] args) {
		
		BusStation busStation = new BusStation();
		// Instantiating inner class
		BusStation.Bus menberClassEx = busStation.new Bus();
		
		System.out.println(menberClassEx.getStationId());
		
		}

}
