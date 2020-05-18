package com.javatraining.designpattern.corExample;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		CEO ceo = new CEO();
		Director director = new Director();
		Manager manager = new Manager();
		Role role = new Role();

		role.setAccessLevel(manager);
		manager.setAccessLevel(director);
		director.setAccessLevel(ceo);

		AccessRequest accessRequest = new AccessRequest(200000, "fund");
		manager.processRequest(accessRequest);

		AccessRequest accessRequest1 = new AccessRequest(20, "Funeral");
		manager.processRequest(accessRequest1);

		AccessRequest accessRequest2 = new AccessRequest(1000000, "Awrudu Func");
		manager.processRequest(accessRequest2);

		/*
		 * ----------------OUTPUT-------------------
		 *  ApprovedCEO 
		 *  ApprovedManager
		 *  ApprovedCEO
		 */
	}
}
