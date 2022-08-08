import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<ccaCategory> ccaCategoryList = new ArrayList<ccaCategory>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		ArrayList<Administrator> adminList = new ArrayList<Administrator>();

		ccaList.add(new CCA("Sports", 0, "Football", "Play with our feet is fun", 1, "Mondays and Wednesdays", 1600,
				"Field"));
		ccaList.add(
				new CCA("Sports", 1, "Bouldering", "Climbing is fun!", 1, "Tuesdays and Thursdays", 1600, "Rock Wall"));
		studentList.add(new Student(123, 321, "Football"));
		parentList.add(new Parent(123, 123, "Basketball", "Sponge", "C123", "Mr. Sqaurepants", "Bob",
				"spongebob@gmail.com", 1234578));
		
		adminList.add(new Administrator("Sports", 0, "Football", "Play with our feet is fun", 1,
				"Mondays and Wednesdays", 1600, "Field", "2104", "David", "I wanna sleep."));

		// variables for choices in option(menu) option2(loggedInMenu) option3(ccaMenu)
		// option(ccaDetailsMenu)(Zahid)

		int mainMenuOption = 0;// menu

		while (mainMenuOption != 9) {
			C206_CaseStudy.startMenu();
			mainMenuOption = Helper.readInt("Enter an option: ");

			if (mainMenuOption == 1) {
				System.out.println("");
				C206_CaseStudy.setHeader("LOGIN");

				// User Input
				int studentIDInput = Helper.readInt("Student ID: ");
				int registerIDInput = Helper.readInt("Register ID: ");

				// Check if login details correct (Zahid)
				boolean check = false; // Added this and for loop for checking, and also made changes to if statement
										// (Nicole)
				check = studentLoginCheck(studentList, studentIDInput, registerIDInput);
				Student s1 = new Student(studentIDInput, registerIDInput, "");

				if (check) {
					// This is the login menu yall add your menu items here(Zahid)
					C206_CaseStudy.loggedinmenu();
					int loggedInMenuOption = 0;

					while (loggedInMenuOption != 9) {

						loggedInMenuOption = Helper.readInt("Enter an option (or 9 to exit): ");

						if (loggedInMenuOption == 1) {
							// view/register CCA menu(Zahid)
							viewAllCCAs(ccaList);

							int ccaMenuInput = Helper.readInt("\nEnter a CCA option to view (or 9 to exit): ");

							while (ccaMenuInput != 9) {
								viewCCADetails(ccaList, s1, ccaMenuInput);
								viewAllCCAs(ccaList);
								ccaMenuInput = Helper.readInt("\nEnter a CCA option to view (or 9 to exit): ");
							}
						}
					}
				} else {
					System.out.println("Student ID or Register ID is incorrect, please try again.");
				}

			} else if (mainMenuOption == 2) {
				Helper.line(140, "-");
				System.out.println("1. Register as student");
				System.out.println("2. Register as parent");
				System.out.println("9. Exit \n");

				int registerOption = Helper.readInt("Please enter an option: ");

				if (registerOption == 1) {
					// Registration for student (Yulong)
					Student studentNew = inputStudent();
					C206_CaseStudy.addStudent(studentList, studentNew);

				} else if (registerOption == 2) {
					// Registration for parent (Nicole)
					Parent newParent = inputParent();
					C206_CaseStudy.addParent(parentList, newParent);
				}

			} else if (mainMenuOption == 3) {
				String adminID = Helper.readString("Enter administrator ID: ");
				String adminPassword = Helper.readString("Enter Password: ");
				int adminId = 0;
				boolean status = false;

				for (int x = 0; x < adminList.size(); x++) {
					if ((adminID.equals(adminList.get(x).getAdministratorId()))
							&& (adminPassword.equals(adminList.get(x).getPassword()))) {
						status = true;
						adminId = x;
						break;
					}
				}

				if (status == true) {
					int adminMenuchoice = 0;

					while (adminMenuchoice != 9) {
						adminMenu(adminList, adminId);
						adminMenuchoice = Helper.readInt("Please enter an option: ");

						if (adminMenuchoice == 1) {
							addCCA(ccaList);

						} else if (adminMenuchoice == 2) {
							viewAllCCAs(ccaList);

						} else if (adminMenuchoice == 3) {

							C206_CaseStudy.setHeader("DELETE CCA");
							viewAllCCAs(ccaList);
							int removeCCA = Helper.readInt("Enter CCA number from table (or -1 to exit): ");

							delCCA(ccaList, removeCCA);

						} else if (adminMenuchoice == 4) {
							// Parent details (Nicole)
							if (parentList.size() != 0) {
								parentMenu(parentList);
								int parentMenuOption = Helper.readInt("Please enter an option: ");

								if (parentMenuOption == 1) {
									int deleteStudent = Helper.readInt("Enter student ID to delete from parent list: ");
									boolean deleteParent = deleteParent(parentList, deleteStudent);

									if (deleteParent) {
										System.out.println("\nParent has been remove from list.");
									} else {
										System.out.println("\nInvalid student ID.");
									}
								}
							} else {
								System.out.println("There are no registered parents.");
							}

						} else if (adminMenuchoice == 5) {
							ccaCategory newCategory = inputCategory();
							addCategory(ccaCategoryList, newCategory);

						} else if (adminMenuchoice == 6) {
							viewAllCategories(ccaCategoryList);

						} else if (adminMenuchoice == 7) {
							viewAllCategories(ccaCategoryList);
							deleteCategory(ccaCategoryList);

						} else {
							System.out.println("Invalid option, please try again");
							adminMenuchoice = Helper.readInt("Enter option: ");
						}
					}
				}
			} else {
				System.out.println("Invalid option, please try again");
			}
		}
	}

	/**
	 * @param ccaList
	 * @param removeCCA
	 */
	public static void delCCA(ArrayList<CCA> ccaList, int removeCCA) {
		if (removeCCA != -1) {
			if (removeCCA > -1) {
				ccaList.remove(removeCCA - 1);
			}
		}
	}

	public static void setHeader(String header) {
		Helper.line(140, "-");
		System.out.println(header);
		Helper.line(140, "-");
	}

	public static void startMenu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Staff Login");
		System.out.println("9. Exit \n");
	}

	// ================================= Option 1 - Login
	// =================================
	private static boolean studentLoginCheck(ArrayList<Student> studentList, int studentIDInput, int registerIDInput) {
		boolean check = false;
		for (int i = 0; i < studentList.size(); i++) {
			int studentID = studentList.get(i).getStudentID();
			int registerID = studentList.get(i).getRegisterID();

			if ((studentIDInput == studentID) && (registerIDInput == registerID)) {
				check = true;
				break;
			}
		}
		return check;
	}

	public static void loggedinmenu() {
		// Add more options for the log in menu(Zahid)
		Helper.line(140, "-");
		System.out.println("1. View CCA");
		System.out.println("9. Exit \n");
	}

	public static void ccaDetails(ArrayList<CCA> ccaList, int ccaMenuInput) {
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaMenuInput == (i + 1)) {
				Helper.line(140, "-");
				System.out.println("Description: " + ccaList.get(i).getDescription());
				System.out.println("CCA vacancy: " + ccaList.get(i).getClass_size() + "/50");
				System.out.println("Days: " + ccaList.get(i).getCca_day_of_the_week());
				System.out.println("Time: " + ccaList.get(i).getTime());
				System.out.println("Venue: " + ccaList.get(i).getVenue());
			}
		}
	}

	public static void viewCCADetails(ArrayList<CCA> ccaList, Student s1, int ccaMenuInput) {
		for (int i = 0; i < ccaList.size(); i++) {
			if ((i + 1) == ccaMenuInput) {
				// View CCA details(Zahid)
				C206_CaseStudy.ccaDetails(ccaList, ccaMenuInput);
				char option = Helper.readChar("\nWould you like to register for this cca? (y/n):");

				if (option == 'y') {
					C206_CaseStudy.registerStudent(ccaList, s1, ccaMenuInput - 1);
					break;
				}
			}
		}
	}

	public static void viewAllCCAs(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("All CCAs List");

		// Added for loops (Nicole)
		for (int i = 0; i < ccaList.size(); i++) {
			System.out.println((i + 1) + ". " + ccaList.get(i).getCca_title());
		}
	}

	public static void registerStudent(ArrayList<CCA> CCAList, Student s1, int ccaOption) {
		s1.setCCA(CCAList.get(ccaOption).getCca_title());
		CCAList.get(ccaOption).setClass_size(CCAList.get(ccaOption).getClass_size() + 1);
		System.out.println("You have successfully registered for this CCA!");
	}

	// ================================= Option 2 - Register
	// =================================
	public static Student inputStudent() { // Registration for student -Nicole
		int studentID = Helper.readInt("Please enter your child's studentID: ");

		Random rand = new Random();
		int registrationID = 10000 + rand.nextInt(90000);
		
		Student newStudent = new Student(studentID, registrationID, "");
		return newStudent;
	}

	public static void addStudent(ArrayList<Student> studentList, Student newStudent) { // Registration for student -Nicole

		boolean exists = false;

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID() == newStudent.getStudentID()) {
				exists = true;
				break;
			}
		}
		if (exists) {
			System.out.println("You have already registered using this student ID!");
		} else {
			studentList.add(newStudent);
			System.out.println("You have successfully registered!");
			System.out.println("Your new registration ID is: " + newStudent.getRegisterID());
		}
	}

	public static Parent inputParent() { // Registration for parent -Nicole
		int studentID = Helper.readInt("Please enter your child's studentID: ");
		String studentName = Helper.readString("Please enter your child's name: ");
		String classroom = Helper.readString("Please enter your child's classroom code: ");
		String teacher = Helper.readString("Please enter your child's teacher name: ");
		String parentName = Helper.readString("Please enter your name: ");
		String parentEmail = Helper.readString("Please enter your email address: ");
		int contactNo = Helper.readInt("Please enter your contact number: ");

		Random rand = new Random();
		int registrationID = 10000 + rand.nextInt(90000);

		Parent newParent = new Parent(studentID, registrationID, "", studentName, classroom, teacher, parentName, parentEmail, contactNo);
		return newParent;
	}

	public static void addParent(ArrayList<Parent> parentList, Parent newParent) { // Registration for parent -Nicole

		boolean exists = false;

		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getStudentID() == newParent.getStudentID()) {
				exists = true;
				break;
			}
		}
		if (exists) {
			System.out.println("You have already registered using this student ID!");
			System.out.println("Your new registration ID is: " + newParent.getRegisterID());
		} else {
			parentList.add(newParent);
			System.out.println("You have successfully registered!");
		}
	}

	// ================================= Option 3 - Staff Login
	// =================================
	private static void adminMenu(ArrayList<Administrator> adminList, int adminId) {
		Helper.line(140, "-");
		String welcome = String.format("Instrutor page\nWelcome %s", adminList.get(adminId).getLecturer_name());
		System.out.println(welcome);
		Helper.line(140, "-");
		System.out.println("1. Add CCA");
		System.out.println("2. View CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Parent details");
		System.out.println("5. Add CCA category");
		System.out.println("6. View CCA category");
		System.out.println("7. Delete CCA category");
		System.out.println("9. Logout");
		Helper.line(140, "-");
	}

	public static void addCCA(ArrayList<CCA> ccaList) {
		Helper.line(140, "-");

		String ccaName = Helper.readString("Enter new CCA name: ");
		String description = Helper.readString("Enter CCA's description: ");
		int size = Helper.readInt("Enter CCA's class size (more than 0): ");

		if (size != 0) {
			String day = Helper.readString("Enter when the CCA will occur (weekday): ");
			day = day.toLowerCase();

			if (!day.equalsIgnoreCase("saturday") || !day.equalsIgnoreCase("sunday")) {
				int time = 0;
				time = Helper.readInt("Enter what time the CCA will occur (24HR): ");

				if (time >= 1000 && time <= 1800) {
					String venue = Helper.readString("Enter where the CCA will occur(weekdays): ");
					String category = Helper.readString("Enter CCA category: ");
					int categoryID = Helper.readInt("Enter CCA category ID: ");
					
					boolean exists = checkCategoryID(ccaList, categoryID);

					if (exists) {
						CCA newCCA = new CCA(category, categoryID, ccaName, description, size, day, time, venue);
						ccaList.add(newCCA);
						
					} else {
						System.out.println("There was an error adding the CCA, please try again");
					}

				} else {
					System.out.println("CCA can only occur from 10:00 to 18:00");
				}

			} else {
				System.out.println("CCA can only occur during weekdays, please try again");
			}

		} else {
			System.out.println("CCA class size cannot be 0, please try again");
		}
	}

	private static boolean checkCategoryID(ArrayList<CCA> ccaList, int categoryID) {
		boolean exists = false;
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i).getCat_id() == categoryID) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	private static void parentMenu(ArrayList<Parent> parentList) {
		Helper.line(140, "-");
		System.out.println("STUDENT PARENT DETAILS LIST");
		Helper.line(140, "-");

		System.out.println(C206_CaseStudy.viewAllParent(parentList));
		Helper.line(140, "-");

		System.out.println("\n1. Delete parent from list");
		System.out.println("9. Exit\n");
	}

	public static String viewAllParent(ArrayList<Parent> parentList) { // Made by Nicole
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", "STUDENT ID",
				"REGISTER ID", "REGISTERED CCA", "STUDENT NAME", "CLASSROOM", "TEACHER", "PARENT NAME", "PARENT EMAIL",
				"CONTACT NO");

		for (int i = 0; i < parentList.size(); i++) {
			output += parentList.get(i).toString();
		}
		return output;
	}

	public static boolean deleteParent(ArrayList<Parent> parentList, int option) { // Made by Nicole

		boolean deleted = false;
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getStudentID() == (option - 1)) {
				parentList.remove(i);
				deleted = true;
				break;
			}
		}
		return deleted;
	}

	public static ccaCategory inputCategory() { // Nicole
		String categoryName = Helper.readString("Enter new CCA Category : ");
		int categoryID = Helper.readInt("Enter new ID: ");

		ccaCategory newCategory = new ccaCategory(categoryName, categoryID);
		return newCategory;
	}

	public static void addCategory(ArrayList<ccaCategory> ccaCategoryList, ccaCategory newCategory) { // Nicole
		boolean exists = false;
		for (int i = 0; i < ccaCategoryList.size(); i++) {
			if (ccaCategoryList.get(i).getCat_title().equals(newCategory.getCat_title())
					|| ccaCategoryList.get(i).getCat_id() == newCategory.getCat_id()) {
				exists = true;
				break;
			}
		}

		if (exists) {
			System.out.println("This category already exists!");
		} else {
			ccaCategoryList.add(newCategory);
			System.out.println("The new category has been created!");
		}
	}

	public static void viewAllCategories(ArrayList<ccaCategory> ccaCategoryList) {
		String output = String.format("%-15s %-15s\n", "CATEGORY ID", "CATEGORY TITLE");

		for (int i = 0; i < ccaCategoryList.size(); i++) {
			output += String.format("%-15d %-15s\n", ccaCategoryList.get(i).getCat_id(),
					ccaCategoryList.get(i).getCat_title());
		}
		System.out.println(output);
	}

	public static void deleteCategory(ArrayList<ccaCategory> ccaCategoryList) {
		int deleteCategory = Helper.readInt("Please enter a category ID (or -1 to exit): ");

		if (deleteCategory != -1) {
			for (int i = 0; i < ccaCategoryList.size(); i++) {
				if (ccaCategoryList.get(i).getCat_id() == deleteCategory) {
					ccaCategoryList.remove(i);
					break;
				}
			}
		}
	}

}