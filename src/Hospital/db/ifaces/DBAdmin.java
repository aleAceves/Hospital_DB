package Hospital.db.ifaces;

import java.util.List;


import Hospital.db.pojos.Nurse;
import Hospital.db.pojos.Patient;
import Hospital.db.pojos.Surgeon;


public interface DBAdmin {
	
	// Connects with the database and, if needed, performs necessary setup
		public void connect();
		// Closes the connection with the database
		// To be called when the application ends
		public void disconnect();
		
		// Add a new surgeon
		public void addSurgeon(Surgeon s);
		// Get a particular surgeon
		public Surgeon getSurgeon(int id);
		// Search for a surgeon by name
		// If name is empty or null, return all people
		public List<Surgeon> searchSurgeonByName(String name);
		
		// Add a new nurse
		public void addNurse(Nurse n);
		// Get a particular nurse
		public Nurse getNurse(int id);
		// Search for a nurse by name
		// If name is empty or null, return all jobs
		public List<Nurse> searchNurseByName(String name);
		
		// Add a new patient
		public void addPatient(Patient p);
		// Get a particular patient
		public Patient getPatient(int id);
		// Search for a patient by name
		// If name is empty or null, return all jobs
		public List<Patient> searchPatientByName(String name);
		
		
		// FALTARIAN COSAS!!!!!!
		
		
	

}
