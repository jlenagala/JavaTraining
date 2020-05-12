package com.javatraining.designpattern.loggersUsingSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingletonLogger {

	private static volatile SingletonLogger singletonLogger;

	private final String logFile = "singletonLogFile.txt";
	private PrintWriter writer;

	public SingletonLogger() {
		try {
			FileWriter fileWriter = new FileWriter(logFile);
			writer = new PrintWriter(fileWriter, true);
		} catch (IOException e) {
		}
	}

	public static SingletonLogger getInstance() {
		if (singletonLogger == null) {
			synchronized (SingletonLogger.class) {
				if (singletonLogger == null) {
					singletonLogger = new SingletonLogger();
				}
			}

		}
		return singletonLogger;
	}

	public void greeting() {
		writer.println("Hai");
	}

	public void quetion() {
		writer.println("How are you?");
	}

	public void goodBye() {
		writer.println("Good Bye");
	}

}
