package Hospital.db.ifaces;

//import java.util.List;

import Hospital.db.pojos.Nurse;

public interface NurseManager {
	
	public void insertNurse(Nurse nurse);

	//public void signUpPatient(Nurse nurse);

	public Nurse getNurse(int patientId);

	public Nurse searchNurse(String name);

	public int getNurseId(Nurse nurse );

	public Nurse logInPatient(String name, String surname);

	//public List<Nurse> listNurses(int doctorId);

}
