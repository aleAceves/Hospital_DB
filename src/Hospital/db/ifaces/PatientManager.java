package Hospital.db.ifaces;

import java.util.List;

import Hospital.db.pojos.Patient;

public interface PatientManager {
	
	public void insertPatient(Patient patient);

	public void signUpPatient(Patient patient);

	public Patient getPatient(int patientId);

	public Patient searchPatient(String name);

	public int getPatientId(Patient patient);

	public Patient logInPatient(String name, String password);

	public List<Patient> listPatients(int surgeonId);

}
