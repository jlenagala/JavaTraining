package com.javatraining.designpattern.prototypexample;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Library library = new Library();
		library.setName("Novel");
		library.loadData();
		Library library1 = (Library) library.clone();
		
		library.getBooks().remove(1);


		library1.setName("Nove");
		// library1.loadData();
		
		System.out.println(library);
		System.out.println(library1);
	}
}
