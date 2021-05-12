package Hospital.db.ui;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Hospital.db.ui.Menu;
import Hospital.db.pojos.users.User;
import Hospital.db.pojos.Patient;

public class PatientMenu {
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Patient patient = null;

	public static void patientMenu() {
		try {
			while (true) {
				int option = 0;
				boolean correctOption = false;
				do {
					System.out.println("\nPATIENT\n");
					System.out.println("1. LogIn");
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
					patient = logInPatient();
					if (patient != null) {
						patientSubMenu();
					}
					break;
				case 2:
					return;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Patient logInPatient() throws Exception {
		Patient patient = null;
		System.out.println("\nLOG IN");
		System.out.print("Username (name): ");
		String username = reader.readLine();
		System.out.print("Password: ");
		String password = reader.readLine();
		User user = Menu.usersManager.checkPassword(username, password);
		if (user == null) {
			System.out.println("Wrong credentials, please try again!");
		} else {
			patient = Menu.patientManager.logInPatient(username, password);
		}
		return patient;
	}

	
	

	public static void patientSubMenu() {
		try {
			while (true) {
				//List<Hemogram> hemogramList = new ArrayList<Hemogram>();
				//List<FeatureValue> featureValueList = new ArrayList<FeatureValue>();
				int option = 0;
				boolean correctOption = false;
				do {
					System.out.println("\n PATIENT \n");
					System.out.println("1. Check schedule");
					System.out.println("2. Check rooms");
					System.out.println("3. Generate XML");
					System.out.println("4. Go back");
					System.out.print("Select an option: ");

					try {
						option = Integer.parseInt(reader.readLine());
						correctOption = true;
					} catch (NumberFormatException e) {
						System.out.println("Insert an integer please;");
					}
				} while (correctOption == false);

				/*
				switch (option) {
				case 1:
					hemogramList = Menu.hemogramManager.listHemogramPatient(patient.getId());
					patient.setHemograms(hemogramList);
					if (hemogramList == null) {
						System.out.println("The patient do not have a hemogram");
					} else {
						System.out.println("\nHemograms: ");
						for (Hemogram hemogram : hemogramList) {
							System.out.println("ID: " + hemogram.getId() + ", Date: " + hemogram.getDob());
						}
					}
					System.out.print("Select the ID of the Hemogram you wan to see: ");
					option = Integer.parseInt(reader.readLine());
					Hemogram hemogramPatient = Menu.hemogramManager.getHemogram(option);
					if (hemogramPatient != null) {
						if (patient.getId() == hemogramPatient.getPatient().getId()) {
							featureValueList = Menu.featureValueManager.getFeatureValuesByHemogram(option);
							if (featureValueList != null) {
								System.out.println("\nHemogram with date " + hemogramPatient.getDob());
								for (FeatureValue featureValue : featureValueList) {
									System.out.println(featureValue.getFeature().getName() + "; VALUE: "
											+ featureValue.getValue() + ", HEALTHY: " + featureValue.getHealthy()
											+ ", [MIN: " + String.format("%.2f", featureValue.getFeature().getMinimum())
											+ ", MAX: " + String.format("%.2f", featureValue.getFeature().getMaximum())
											+ "]");
								}
								System.out.println("Doctors comments: " + hemogramPatient.getComments());

							}
						}
					} else {
						System.out.println("The hemogram introduced doesn't exist");
						break;
					}

					break;
				case 2:
					generateXML(patient.getId());
					System.out.println("XML successfully created, to see the html please go to the xmls folder and open the Patien.html");
				case 3:
					return;
				default:
					break;
				}
			*/	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}

