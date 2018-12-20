package application;

import java.sql.*;

import model.SQL;

public class SqlController {
	static void connect() {
		try {		
			Connection connection = DriverManager.getConnection(SQL.host, SQL.user, SQL.password);
			System.out.println("Database connection successful!");
		} catch (SQLException e) {
			System.out.println("Database connection failed!");
			e.printStackTrace();
		}
	}
}
