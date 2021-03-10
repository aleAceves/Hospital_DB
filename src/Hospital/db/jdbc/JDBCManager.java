package Hospital.db.jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCManager {
	
	private Connection c;
	
	public void connect() {
	

	try {
		
		Class.forName("org.sqlite.JBDC");
		
		c= DriverManager.getConnection("jbdc:sqlite:./db/Hospital.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened");
		this.createTables();
		} catch(SQLException ex) {
			System.out.print("Error in the connection");
			ex.printStackTrace();
		} catch(Exception ex) {
			System.out.print("General error");
			ex.printStackTrace();
		}
	
	}
	
	
	
	private void createTables() {
		
		try{
		
		Statement stm1= c.createStatement();
		
		String s1= "CREATE TABLE surgeons "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " name  TEXT NOT NULL, "
				+ " surname TEXT NOT NULL, "
				+ " speciality TEXT NOT NULL )";
		
		stm1.executeUpdate(s1);

		
		s1= "CREATE TABLE patients "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " name  TEXT NOT NULL, "
				+ " surname TEXT NOT NULL, "
				+ " email TEXT NOT NULL, "
				+ " address TEXT NOT NULL)";
		
		stm1.executeUpdate(s1);


		
		s1= "CREATE TABLE nurses "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " name  TEXT NOT NULL, "
				+ " surname TEXT NOT NULL )";
		
		stm1.executeUpdate(s1);

		
		s1= "CREATE TABLE waiting_room "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " number INTEGER )";
		
		stm1.executeUpdate(s1);
		

		s1= "CREATE TABLE operating_room "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " number INTEGER )";
		
		stm1.executeUpdate(s1);
		

		
		s1= "CREATE TABLE operation "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " type TEXT NOT NULL,"
				+ " date DATE NOT NULL )";
		
		stm1.executeUpdate(s1);
		
		stm1.close();
		
		System.out.print("Tables created");
			
		
	
		} catch(SQLException ex) {
			System.out.print("Error in SQL");
			ex.printStackTrace();
		}
	}
	
	
	public void disconnect () {
		try {
			c.close();
		
		} catch(SQLException e) {
			System.out.print("Error in disconnecting");
			e.printStackTrace();
		}
	}
	
	public void addSurgeons () {
		
	}
	
	
}

