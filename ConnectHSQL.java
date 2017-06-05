package com.db_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectHSQL {
	
	private static final String USERNAME ="dbuser";
	private static final String PASSWORD ="dbpassword";
	
	private static final String CONN_STRING = "jdbc:hsqldb:/Users/renzotejada/Documents/workspace/ConnectHSQLDB/data/explorecalifornia";

	String sqlInsert= "INSERT INTO `explorecalifornia`.`explorers` (`explorerId`, `firstName`, `lastName`, `dob`, `email`, `address`, `city`, `state`, `zipcode`, `userName`, `password`, `tours`, `bio`) VALUES (NULL, 'John', 'Quispe', '1985-07-10', 'jackie-@somewhere.com', '123 Main St.', 'Somewhere', 'CA', '90023', 'jackies', 'password', '1,3,5', 'I''ve lived in CA for over 20 years!');";//
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Conneceted!");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM states");
			rs.last();
			System.out.println("Number of rows: " + rs.getRow());
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
	}

}
