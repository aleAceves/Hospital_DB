package Hospital.db.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCreate {

	try {
		
		Class.forName("org.sqlite.JBDC");
		
		Connection c= DriverManager.getConnection("jbdc:sqlite:./db/Hospital.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened");
		
		Statement stm1= c.createStatement();
		
		String s1= "CREATE TABLE surgeons "
				+ "(id   INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ " name  TEXT NOT NULL, "
				+ " surname TEXT NOT NULL, "
				+ " speciality TEXT NOT NULL )";
			
		
	}
	catch(IOException ex) {
		ex.printStackTrace();
	};
}
