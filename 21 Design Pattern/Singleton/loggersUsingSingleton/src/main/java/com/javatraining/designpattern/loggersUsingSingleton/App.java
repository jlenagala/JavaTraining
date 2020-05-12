package com.javatraining.designpattern.loggersUsingSingleton;

public class App {
	public static void main(String[] args) {
		
		Logger logger1 = new Logger();
		System.out.println(logger1);
		Logger logger2 = new Logger();
		System.out.println(logger2);
		Logger logger3 = new Logger();
		System.out.println(logger3);
		
		logger1.greeting();
		logger2.goodBye();
		logger1.quetion();
		logger3.greeting();
		logger2.goodBye();
		
		
		System.out.println("-----------Singleton------------------- ");
		SingletonLogger singletonLogger1 = SingletonLogger.getInstance();
		System.out.println(singletonLogger1);
		SingletonLogger singletonLogger2 = SingletonLogger.getInstance();
		System.out.println(singletonLogger2);
		SingletonLogger singletonLogger3 = SingletonLogger.getInstance();
		System.out.println(singletonLogger3);
		
		singletonLogger1.greeting();
		singletonLogger2.goodBye();
		singletonLogger1.quetion();
		singletonLogger3.greeting();
		singletonLogger2.goodBye();
	}
}
