package Hospital.db.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Hospital.db.ifaces.*;
import Hospital.db.jdbc.*;
import Hospital.db.jpa.JPAUserManager;
import Hospital.db.pojos.users.Role;




public class Menu {

	
	public static DBManager dbManager;
	public static UserManager usersManager;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) {
		try {
			// create and connect with the database
			dbManager = new JDBCManager();
			dbManager.connect();
			//analyzerManager = dbManager.getAnalyzerManager();
			//patientManager = dbManager.getPatientManager();
			//doctorManager = dbManager.getDoctorManager();
			//featuresManager = dbManager.getFeaturesManager();
			//hemogramManager = dbManager.getHemogramManager();
			//featureValueManager = dbManager.getFeatureValueManager();

			// Create tables
			dbManager.createTables();
			usersManager = new JPAUserManager();
			usersManager.connect();
			Role role = new Role("doctor");
			usersManager.createRole(role);
			Role role2 = new Role("analyzer");
			usersManager.createRole(role2);
			Role role3 = new Role("patient");
			usersManager.createRole(role3);

			while (true) {
				int option = 4;
				boolean correctOption = false;
				do {
					// starts program
					// THE DOCTOR SHOULD BE CREATED BEFORE CREATING THE HEMOGRAM
					System.out.println("\nWho are you?");
					System.out.println("1. Analyzer");
					System.out.println("2. Doctor");
					System.out.println("3. Patient");
					System.out.println("0. Exit");
					System.out.print("Select an option: ");

					try {
						option = Integer.parseInt(reader.readLine());
						correctOption = true;
					} catch (NumberFormatException e) {
						System.out.println("Insert an integer please;");
					}
				} while (correctOption == false);

				switch (option) {
				case 1:
					//MenuAnalyzer.analyzerMenu();
					break;
				case 2:
					//MenuDoctor.doctorMenu();
					break;
				case 3:
					//MenuPatient.patientMenu();
					break;
				case 0:
					dbManager.disconnect();
					usersManager.disconnect();
					System.out.println("Thank you for using our program! Have a good day :D");
					System.exit(0);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}