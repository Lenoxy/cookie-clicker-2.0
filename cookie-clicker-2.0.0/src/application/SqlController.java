package application;

import java.sql.*;
import java.text.DecimalFormat;

import model.SQL;

public class SqlController{
	static Connection connect() {
		try {
			Class.forName(SQL.driver);
			Connection conn = DriverManager.getConnection(SQL.host, SQL.user, SQL.password);
			System.out.println("SQL connection established!");
			
			return conn;
		} catch (Exception e) {
			System.out.println("SQL Connection failed!: " + e);
			e.printStackTrace();
		}
		return null;
	}
	
	static boolean insert(String name, double score) throws Exception {
		boolean successful = false;
		try {
			DecimalFormat format = new DecimalFormat("0.#");
			Connection conn = connect();
			PreparedStatement  posted = conn.prepareStatement("INSERT INTO board (name, score) VALUES('"+ name +"', " + format.format(score) + ")");
			posted.executeUpdate();	
			successful = true;
		}catch(Exception e) {
			System.out.println("Insert error: " + e);
			successful = false;
		}
		finally {
			System.out.println("Insert successful!");
		}
		return successful;
	}
}
