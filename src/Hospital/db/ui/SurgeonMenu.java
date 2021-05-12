package Hospital.db.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



import Hospital.db.ifaces.PatientManager;
import Hospital.db.ui.Menu;
import Hospital.db.ifaces.*;
import Hospital.db.pojos.Patient;
import Hospital.db.pojos.Surgeon;
import Hospital.db.pojos.users.Role;
import Hospital.db.pojos.users.User;


public class SurgeonMenu {
	
	public static PatientManager patientManager;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	

	public static void surgeonMenu() {
		try {
			while (true) {
				Surgeon surgeon = null;
				int surgeonId = 0;
				int option = 0;
				boolean correctOption = false;
				do {
					System.out.println("\n SURGEON \n");
					//System.out.println("1. Sign In");
					System.out.println("2. Log In");
					System.out.println("3. Go back");
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
					//surgeon = signInAnalyzer();
					//surgeonId = Menu.dbManager.getLastId();
					surgeon.setId(surgeonId);
					surgeonSubmenu(surgeon);
					break;
				case 2:
					surgeon = logInSurgeon();
					do {
						if (surgeon == null) {
							surgeon = logInSurgeon();
						}
					} while (surgeon == null);

					surgeonSubmenu(surgeon);
					break;
				case 3:
					return;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// LOG IN FOR THE SURGEON
	public static Surgeon logInSurgeon() throws Exception {
		Surgeon surgeon = null;
		System.out.println("\n LOG IN: ");
		System.out.print("Username (name): ");
		String username = reader.readLine();
		System.out.print("Password (workUser): ");
		String password = reader.readLine();
		User user = Menu.usersManager.checkPassword(username, password);
		// We check if the user/password combination was OK
		if (user == null) {
			System.out.println("Wrong credentials, please try again!");
		}
		// We sign in and return the analyzer
		else {
			
			// CAMBIAR ESTO EN EL MENU
			//analyzer = Menu.analyzerManager.logInAnalyzer(username, password);
		}
		return surgeon;
	}

	public static void surgeonSubmenu(Surgeon surgeon) {
		try {
			while (true) {
				//Patient patient = null;
				//Doctor doctor = null;
				//int patientId = 0;
				int option = 0;
				boolean correctOption = false;
				do {
					System.out.println("\n SURGEON: \n");
					System.out.println("1. Check schedule");
					System.out.println("2. Check operating rooms");
					//System.out.println("3. Create XML");
					System.out.println("4. Go back");
					System.out.print("Select an option: ");

					try {
						option = Integer.parseInt(reader.readLine());
						correctOption = true;
					} catch (NumberFormatException e) {
						System.out.println("Insert an integer please;");
					}
				} while (correctOption == false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
}

