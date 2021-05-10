package Hospital.db.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;

import Hospital.db.ifaces.AdministratorManager;
import Hospital.db.pojos.Administrator;
//import hemogram.db.interfaces.PatientManager;
import Hospital.db.ui.Menu;

import Hospital.db.pojos.users.User;

public class AdministratorMenu {
	
	public static AdministratorManager adminManager;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


	public static void adminMenu() {
		try {
			while (true) {
				Administrator admin = null;
				int adminId = 0;
				int option = 0;
				boolean correctOption = false;
				do {
					System.out.println("\n ADMINISTRATOR \n");
					System.out.println("1. Log In");
					//System.out.println("2. Sign In");
					System.out.println("2. Go back");
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
					admin = logInAdmin();
					do {
						if (admin == null) {
							admin = logInAdmin();
						}
					} while (admin == null);

					// to show the real options that the administrator has
					adminSubmenu(admin);
					break;
				case 2:
					break;
			
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// FUNCTIONS WE ARE GOING TO NEED:

	private static void adminSubmenu(Administrator admin) {
		try {
			// VEER QUÉ HACEMOS AQUÍ

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static Administrator logInAdmin() throws IOException {
		Administrator admin = null;
		System.out.println("\nLOG IN");
		System.out.print("Username (name): ");
		String username = reader.readLine();
		System.out.print("Password (workUser): ");
		String password = reader.readLine();
		User user = Menu.usersManager.checkPassword(username, password);
		// We check if the user/password combination was OK
		if (user == null) {
			System.out.println("Wrong credentials, please try again!");
		}
		// We sign in and return the admin
		else {
			
			//VER QUE HACE ESTO;
			admin = Menu.administratorManager.logInAnalyzer(username, password);
		}
		return admin;
		
	}


	
	}

