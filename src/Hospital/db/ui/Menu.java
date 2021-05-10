package Hospital.db.ui;

import java.io.BufferedReader;



import java.time.format.DateTimeFormatter;
import java.io.InputStreamReader;
import java.security.MessageDigest;

import Hospital.db.ifaces.*;
import Hospital.db.jdbc.*;
import Hospital.db.jpa.JPAUserManager;
import Hospital.db.pojos.Nurse;
import Hospital.db.pojos.Patient;
import Hospital.db.pojos.Surgeon;
import Hospital.db.pojos.users.Role;
import Hospital.db.pojos.users.User;






public class Menu {

	//add the manager for each user that we have, and create them ADD THIS!!!!
	
	public static DBManager dbManager;
	public static UserManager usersManager;
	public static AdministratorManager administratorManager;
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	
	public static void main(String args[]) throws Exception{
		//creeate and connect with the database
		//HEMOGRAM AQUI TIENE ALGO DE SQL: PONER LUEGO
		dbManager.connect();
		usersManager.connect();
		
		administratorManager = dbManager.getAdministratorManager();
		
		// Create tables
		dbManager.createTables();
		usersManager = new JPAUserManager();
		usersManager.connect();
		Role role = new Role("surgeon");
		usersManager.createRole(role);
		Role role2 = new Role("nurse");
		usersManager.createRole(role2);
		Role role3 = new Role("patient");
		usersManager.createRole(role3);
		Role role4 = new Role("administrator");
		usersManager.createRole(role4);
		
		//the while(true), to show the menu
		while (true) {
			int option = 4;
			boolean correctOption = false;
			do {
				// starts program
				// CREEATE AN ADMIN BEFORE, by default, in order to have just one administrator
				System.out.println("\nWho are you?");
				System.out.println("1. Administrator");
				System.out.println("2. Surgeon");
				System.out.println("3. Nurse");
				System.out.println("4. Patient");
					
				System.out.println("5. Exit");
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
				AdministratorMenu.adminMenu();
				//we go to the menu for the administrator
				break;
			case 2:
				//MenuSurgeon.patientMenu();
				//wee go to the menu for the surgeon
				break;
			case 3:
				//MenuNurse.patientMenu();
				//go to the menu for the nurse
				break;
			case 4:
				//we go to the menu for the patient
				//MenuPatient.patientMenu();
			case 5:
				dbManager.disconnect();
				usersManager.disconnect();
				System.out.println("Thank you for using our program!");
				System.exit(0);
				break;
			default:
				break;
			}
		}
		




	
		
		do {
		System.out.println("Choose an option:");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("0. Exit");
		int choice = Integer.parseInt(reader.readLine());
		switch (choice) {
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		case 0:
			dbManager.disconnect();
			usersManager.disconnect();
			System.exit(0);
			break;
		default:
			break;
		}
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
			Role role = new Role("admin");
			usersManager.createRole(role);
			Role role2 = new Role("surgeon");
			usersManager.createRole(role2);
			Role role3 = new Role("nurse");
			usersManager.createRole(role3);
			Role role4 = new Role("patient");
			usersManager.createRole(role4);
		}while (true);
	}
			
			
	private static void register() throws Exception {
			// Ask the user for an email
			System.out.println("Please, write your email address:");
			String email = reader.readLine();
			// Ask the user for a password
			System.out.println("Please write your password:");
			String password = reader.readLine();
			// List the roles
			System.out.println(usersManager.getRoles());
			// Ask the user for a role
			System.out.println("Type the chosen role ID:");
			int id = Integer.parseInt(reader.readLine());
			Role role = usersManager.getRole(id);
			// Generate the hash
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			User user = new User(email, hash, role);
			usersManager.newUser(user);
		}
	
	private static void login() throws Exception {
		// Ask the user for an email
		System.out.println("Please, write your email address:");
		String email = reader.readLine();
		// Ask the user for a password
		System.out.println("Please write your password:");
		String password = reader.readLine();
		User user = usersManager.checkPassword(email, password);
		if (user == null) {
			System.out.println("Wrong email or password");
			return;
		} else if (user.getRole().getName().equalsIgnoreCase("admin")) {
			adminMenu();
		} else if (user.getRole().getName().equalsIgnoreCase("surgeon")) {
			surgeonMenu();
		} else if (user.getRole().getName().equalsIgnoreCase("nurse")) {
			nurseMenu();
		} else if (user.getRole().getName().equalsIgnoreCase("patient")) {
			patientMenu();
		}
		}
		// Check the type of the user and redirect her to the proper menu

	

	private static void adminMenu() throws Exception {
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Check schedule ");
			System.out.println("2. Add surgeons");
			System.out.println("3. Delete surgeons");
			System.out.println("4. Edit surgeons");
			System.out.println("5. Add nurses");
			System.out.println("6. Delete nurses");
			System.out.println("7. Edit nurses");
			System.out.println("8. Add patients");
			System.out.println("9. Delete patients");
			System.out.println("10. Edit patients");
			System.out.println("11. Check rooms");
			System.out.println("12. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
				CheckSchedule();
				break;
			case 2:
				addSurgeon();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				addNurse();
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				addPatient();
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 0:
				return;
			default:
				break;
			}
		} while (true);
	}
	
	private static void addSurgeon() throws Exception {
		System.out.println("Please, input the person info:");
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Surname: ");
		String surname = reader.readLine();
		System.out.print("Speciality: ");
		String speciality = reader.readLine();
		Surgeon surgeon= new Surgeon(name, surname, speciality);
		dbManager.addSurgeon(surgeon);
	}
	
	private static void addNurse() throws Exception {
		System.out.println("Please, input the person info:");
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Surname: ");
		String surname = reader.readLine();
		Nurse nurse= new Nurse(name, surname);
		dbManager.addNurse(nurse);
	}
	
	private static void addPatient() throws Exception {
		System.out.println("Please, input the person info:");
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Surname: ");
		String surname= reader.readLine();
		System.out.print("Address: ");
		String address= reader.readLine();
		System.out.print("Email: ");
		String email = reader.readLine();
		Patient patient= new Patient(name, surname, address, email);
		dbManager.addPatient(patient);
	}

		
			
}
