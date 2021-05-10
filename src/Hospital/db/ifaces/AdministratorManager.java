package Hospital.db.ifaces;

import Hospital.db.pojos.*;

public interface AdministratorManager {
	
	// in case we want to have more administrators, we will need this
	//public void insertAdministrator(Administrator admin);

	public Administrator getAnalyzer(int analyzerId);

	public Administrator logInAnalyzer(String name, String password);

	

}
