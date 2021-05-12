package Hospital.db.jdbc;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital.db.ifaces.AdministratorManager;
import Hospital.db.ifaces.DBManager;
import Hospital.db.ifaces.NurseManager;
import Hospital.db.ifaces.PatientManager;
import Hospital.db.pojos.Nurse;
import Hospital.db.pojos.Operation;
import Hospital.db.pojos.Patient;
import Hospital.db.pojos.Surgeon;


public class JDBCManager implements DBManager{
	
	private Connection c;
	
	public JDBCManager() {
		super();
	}
	
	

@Override
	public void connect() {
			try {
				// Open database connection
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:./Hospital_DB.db");
				c.createStatement().execute("PRAGMA foreign_keys=ON");
				System.out.println("Database connection opened.");
				this.createTables();
			} catch (SQLException sqlE) {
				System.out.println("There was a database exception.");
				sqlE.printStackTrace();
			} catch (Exception e) {
				System.out.println("There was a general exception.");
				e.printStackTrace();
			}
		}
	
	
	// CREATING THE TABLES
	public void createTables() {
		
		Statement stm1;
		
		try{
		
		stm1= c.createStatement();
		
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
		
		// Create table operations_surgeons
		s1 = "CREATE TABLE operations_surgeons "
				+ "(operation_id INTEGER REFERENCES operation(id), "
				+ "surgeon_id INTEGER REFERENCES surgeons(id), " 
				+ "PRIMARY KEY (operations_id, surgeons_id))";
		
		stm1.executeUpdate(s1);

		stm1.close();
		
		System.out.print("Tables created");
			
		} catch(SQLException ex) {
			System.out.print("Error in SQL");
			ex.printStackTrace();
		}
	}

	
	
	
	// Close the database connection
	@Override
	public void disconnect() {
		try {
			c.close();	
		} catch(SQLException e) {
			System.out.print("Error in disconnecting");
			e.printStackTrace();
		}
	}
	
	
	// ADD SURGEONS
	
	public void addSurgeon (Surgeon s) {
		try {
			// Id is chosen by the database
			//Statement stmt = c.createStatement();
			String sql = "INSERT INTO surgeons (name,surname, speciality) VALUES (?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, s.getName());
			prep.setString(2, s.getSurname());
			prep.setString(3, s.getSpeciality());
			//we miss the list of operations
			
			prep.executeUpdate(sql);
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//REVISAR EL CONSTRUCTOR EN POJOS SIN LA LIST OF OPERATIONS
		public Surgeon getSurgeon (int id) {
			try {
				String sql = "SELECT * FROM surgeons WHERE id = ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, id);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					String surgeonName = rs.getString("name");
					String surgeonSurname = rs.getString("surname");
					String surgeonSpeciality = rs.getString("speciality");
					return new Surgeon (id, surgeonName, surgeonSurname, surgeonSpeciality);
				}
				rs.close();
				prep.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	
	// ADD NURSES
	public void addNurse (Nurse n) {
		try {
			// Id is chosen by the database
			//Statement stmt = c.createStatement();
			String sql = "INSERT INTO nurses (name, surname) VALUES (?,?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, n.getName());
			prep.setString(2, n.getSurname());
			prep.executeUpdate(sql);
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public Nurse getNurse (int id) {
		try {
			String sql = "SELECT * FROM nurses WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				String nurseName = rs.getString("name");
				String nurseSurname = rs.getString("surname");
				return new Nurse (id, nurseName, nurseSurname);
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ADD PATIENT
	public void addPatient (Patient p) {
		try {
			// Id is chosen by the database
			//Statement stmt = c.createStatement();
			String sql = "INSERT INTO patients (name, surname, address, email) VALUES(?,?,?,?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, p.getName());
			prep.setString(2, p.getSurname());
			prep.setString(3, p.getAddress());
			prep.setString(4, p.getEmail());
			prep.executeUpdate(sql);
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public Patient getPatient (int id) {
		try {
			String sql = "SELECT * FROM patients WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				String patientName = rs.getString("name");
				String patientSurname = rs.getString("surname");
				String patientAddress = rs.getString("address");
				String patientEmail = rs.getString("email");
				return new Patient (id, patientName, patientSurname, patientAddress, patientEmail);
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	// SEARCH SURGEON BY NAME
	@Override
	public List<Surgeon> searchSurgeonByName(String name) {
		List<Surgeon> surgeons = new ArrayList<Surgeon>();
		try {
			String sql = "SELECT * FROM surgeons WHERE name LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String surgeonName = rs.getString("name");
				String surgeonSurname = rs.getString("surname");
				String surgeonSpeciality = rs.getString("speciality");
				Surgeon surgeon = new Surgeon (id, surgeonName, surgeonSurname, surgeonSpeciality);
				surgeons.add(surgeon);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return surgeons;
	}
	
	// SEARCH NURSE BY NAME
	public List<Nurse> searchNurseByName(String name) {
		List<Nurse> nurses = new ArrayList<Nurse>();
		try {
			String sql = "SELECT * FROM nurses WHERE name LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String nurseName = rs.getString("name");
				String nurseSurname = rs.getString("surname");
				Nurse nurse = new Nurse (id, nurseName, nurseSurname);
				nurses.add(nurse);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nurses;
	}
	
	// SEARCH PATIENT BY NAME
	public List<Patient> searchPatientByName(String name) {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			String sql = "SELECT * FROM patients WHERE name LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String patientName = rs.getString("name");
				String patientSurname = rs.getString("surname");
				String patientAddress = rs.getString("address");
				String patientEmail = rs.getString("email");
				Patient patient = new Patient (id, patientName, patientSurname,patientAddress,patientEmail);
				patients.add(patient);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}
	
	
	public void addOperation(Operation o) {
		try {
			String sql = "INSERT INTO operation (type, date) VALUES (?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, o.getType());
			prep.setDate(2, o.getDate());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Operation getOperation(int id) {
		try {
			String sql = "SELECT * FROM operation WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				return new Operation(id, rs.getString("type"), rs.getDate("endDate"));
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Operation> searchOperationsByType(String type) {
		List<Operation> operations = new ArrayList<Operation>();
		try {
			String sql = "SELECT * FROM operation WHERE name LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + type + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// Create a job with everything except the list of people that work here
				Operation operation = new Operation(rs.getInt("id"), rs.getString("type"),  rs.getDate("date"));
				// Adds the surgeons that are in the operation to the operation
				operation.setSurgeons(this.getSurgeonsOfOperation(operation.getId()));
				// Adds the job to the list that will be returned
				operations.add(operation);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operations;
	}

	public List<Surgeon> getSurgeonsOfOperation(int operationId) {
		List<Surgeon> surgeons = new ArrayList<Surgeon>();
		try {
			String sql = "SELECT * FROM operations_surgeons WHERE operation_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, operationId);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int surgeonId = rs.getInt("person_id");
				surgeons.add(this.getSurgeon(surgeonId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return surgeons;
	}
	
	// ADD SURGEON TO OPERATION
	public void addSurgeonsToOperation(Surgeon s, Operation o) {
		try {
			String sql = "INSERT INTO operations_surgeons (operation_id, surgeon_id) VALUES (?,?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, o.getId());
			prep.setInt(2, s.getId());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DELETE SURGEON FROM OPERATION
	public void deleteSurgeonsFromOperation(int surgeonId, int operationId) {
		try {
			String sql = "DELETE FROM operations_surgeons WHERE operation_id = ? AND surgeon_id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, operationId);
			prep.setInt(2, surgeonId);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public AdministratorManager getAdministratorManager() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public NurseManager getNurseManager() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PatientManager getPatientManager() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}

