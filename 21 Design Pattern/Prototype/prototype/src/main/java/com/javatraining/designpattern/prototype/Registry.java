package com.javatraining.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	private Map<VehicleType,Vehicle> vehicles=new HashMap();
	public Registry() {
		this.initialize();
		
	}
	
	public Vehicle getVehicle(VehicleType vehicleType) {
		Vehicle vehicle=null;
		try {
			vehicle=(Vehicle) vehicles.get(vehicleType).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicle;
		
	}
	private void initialize() {

		Car car=new Car();
		car.setEngineCapacity(2000);
		car.setType("Mini");
		car.setFuelType("Gasoline");
		
		Bus bus=new Bus();
		bus.setEngineCapacity(3000);
		bus.setNumberOfSeats(24);
		bus.setFuelType("Diesal");
		
		
		vehicles.put(VehicleType.CAR, car);
		vehicles.put(VehicleType.BUS, bus);
		
	}
	

}
