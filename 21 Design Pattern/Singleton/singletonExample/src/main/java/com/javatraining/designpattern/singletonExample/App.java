package com.javatraining.designpattern.singletonExample;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		long start, end;

//    	DBManager dbManager=DBManager.getDbManager();
//        System.out.println(dbManager);
//  
//    	DBManager dbManager1=DBManager.getDbManager();
//        System.out.println( dbManager1);

		DBManagerEx dbManagerEx = DBManagerEx.getDbManagerEx();
		System.out.println(dbManagerEx);

		start = System.currentTimeMillis();
		Connection connection = dbManagerEx.getConnection();
		end = System.currentTimeMillis();
		System.out.println(end - start);

		DBManagerEx dbManagerEx1 = DBManagerEx.getDbManagerEx();
		System.out.println(dbManagerEx1);

		start = System.currentTimeMillis();
		Connection connection1 = dbManagerEx1.getConnection();
		end = System.currentTimeMillis();
		System.out.println(start - end);
		
		
		
	}
}
