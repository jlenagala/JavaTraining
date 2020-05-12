package com.javatraining.designpattern.singletonExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManagerEx {
	private static volatile DBManagerEx dbManagerEx;// =new DBManager();

	private static volatile Connection connection;

	private DBManagerEx() {
		if (dbManagerEx != null) {
			throw new RuntimeException("Please use getDbmanagerMethod");
		}

	}

	public static DBManagerEx getDbManagerEx() {

		if (dbManagerEx == null) {
			synchronized (DBManagerEx.class) {
				if (dbManagerEx == null) {
					dbManagerEx = new DBManagerEx();
				}
			}

		}
		return dbManagerEx;
	}

	public Connection getConnection() {

		if (connection == null) {
			synchronized (DBManagerEx.class) {
				if (connection == null) {
					String url = "jdbc:mysql://localhost:3306/singleton?createDatabaseIfNotExist=true";
					try {
						connection = DriverManager.getConnection(url, "root", "root123");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		return connection;

	}
}
