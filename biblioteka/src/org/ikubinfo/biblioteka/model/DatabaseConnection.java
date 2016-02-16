package org.ikubinfo.biblioteka.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	protected Connection conn = null;
	protected final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	protected final String DB_URL = "jdbc:mysql://localhost:3306";
	protected final String DB_USER = "root";
	protected final String DB_PASS = "fly1993";

	public Connection getConnection() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		} catch (SQLException se) {
			System.out.println(se.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

}