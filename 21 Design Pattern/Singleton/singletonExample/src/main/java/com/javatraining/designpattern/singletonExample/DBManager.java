package com.javatraining.designpattern.singletonExample;

public class DBManager {
	private static volatile DBManager dbManager;// =new DBManager();

	private DBManager() {
		if (dbManager != null) {
			throw new RuntimeException("Please ude getDbmanagerMethod");
		}

	}

	public static DBManager getDbManager() {

		if (dbManager == null) {
			synchronized (DBManager.class) {
				if (dbManager == null) {
					dbManager = new DBManager();
				}
			}

		}
		return dbManager;
	}

}
