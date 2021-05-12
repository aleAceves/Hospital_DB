package Hospital.db.ui;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Hospital.db.ifaces.AdministratorManager;
import Hospital.db.pojos.Administrator;
import Hospital.db.pojos.Nurse;
import Hospital.db.pojos.Patient;
import Hospital.db.pojos.Surgeon;
import Hospital.db.ui.Menu;
import jobseeker.db.pojos.Person;
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

	private static void adminSubmenu(Administrator admin) throws Exception {
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
			System.out.println("12. Create an operation");
			System.out.println("13. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
				CheckSchedule();
				break;
			case 2:
				addSurgeon();
				break;
			case 3:
				searchSurgeon();
				break;
			case 4:
				searchSurgeon();
				break;
			case 5:
				addNurse();
				break;
			case 6:
				searchNurse();
				break;
			case 7:
				searchNurse();
				break;
			case 8:
				addPatient();
				break;
			case 9:
				searchPatient();
				break;
			case 10:
				searchPatient();
				break;
			case 11:
				break;
			case 12:
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
		Menu.dbManager.addSurgeon(surgeon);
	}
	
	private static void addNurse() throws Exception {
		System.out.println("Please, input the person info:");
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Surname: ");
		String surname = reader.readLine();
		Nurse nurse= new Nurse(name, surname);
		Menu.dbManager.addNurse(nurse);
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
		Menu.dbManager.addPatient(patient);
	}
	
	private static void searchSurgeon() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Name contains: ");
		String name = reader.readLine();
		List<Surgeon> surgeons = Menu.dbManager.searchSurgeonByName(name);
		if (surgeons.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(surgeons);
		}
	}
	
	private static void searchNurse() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Name contains: ");
		String name = reader.readLine();
		List<Nurse> nurses = Menu.dbManager.searchNurseByName(name);
		if (nurses.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(nurses);
		}
	}
	
	private static void searchPatient() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Name contains: ");
		String name = reader.readLine();
		List<Patient> patients = Menu.dbManager.searchPatientByName(name);
		if (patients.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(patients);
		}
	}
	
	private static void deleteSurgeon() throws Exception {
		System.out.println("Choose the person first:");
		searchPeople();
		System.out.println("Type the chosen person's id:");
		int personId = Integer.parseInt(reader.readLine());
		System.out.println("Now choose the job:");
		searchJob();
		System.out.println("Type the chosen job's id:");
		int jobId = Integer.parseInt(reader.readLine());
		dbman.fire(personId, jobId);
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

