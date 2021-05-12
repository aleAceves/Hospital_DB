package Hospital.db.ifaces;

import Hospital.db.pojos.Surgeon;

public interface SurgeonManager {
	
	public void insertSurgeon(Surgeon surgeon);

	public Surgeon getSurgeon(int surgeonId);

	public Surgeon logInSurgeon(String name, String password);

	public int getSurgeonId(Surgeon surgeon);

	
	// ESTO ES DE LA DE MERI
	// join doctor with patient bc is the analyzer the one that creates the patient
	//public void linkPatientDoctor(int patientId, int doctorId);

}
