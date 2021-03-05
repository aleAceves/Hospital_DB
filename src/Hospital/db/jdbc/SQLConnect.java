package Hospital.db.jdbc;

import java.io.IOException;
import java.sql.*;

public class SQLConnect {
	try {
		
		Class.forName("org.sqlite.JDBC");
		Connection c= DriverManager.getConnection("jbdc:sqlite:./db/Hospital.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened");
		
		
		c.close();
		System.out.println("Database connection closed");

	
		
		
	}
	catch(IOException ex) {
		ex.printStackTrace();
	};
}
