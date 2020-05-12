package com.javatraining.designpattern.loggersUsingSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	private final String logFile = "logFile.txt";
	private PrintWriter writer;
	
	public Logger() {
		try {
			FileWriter fileWriter = new FileWriter(logFile);
		    writer = new PrintWriter(fileWriter, true);
		} catch (IOException e) {}
	}
	
	public void greeting () {
		writer.println("Hai");
	}
	
	public void quetion () {
		writer.println("How are you?");
	}

	public void goodBye () {
		writer.println("Good Bye");
	}
	
}