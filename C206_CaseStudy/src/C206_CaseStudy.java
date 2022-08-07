import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		ArrayList<Administrator> Lecturer = new ArrayList<Administrator>();

		generateRandomCCA(CCAList);

		Student s1 = generateRandomStudent(StudentList);

		generateRandomParent(parentList);

		generateRandomLecturer(Lecturer);

		// variables for choices in option(menu) option2(loggedInMenu) option3(ccaMenu)
		// option(ccaDetailsMenu)(Zahid)

		int option = 0;// menu
		int option2 = 0;// logged in menu
		int option3 = 0;// cca menu
		int option4 = 0;

		while (option != 9) {
			C206_CaseStudy.startmenu();
			option = Helper.readInt("Enter an option: ");

			if (option == 1) {

				System.out.println("");
				Helper.line(140, "-");
				System.out.println("LOGIN");
				Helper.line(140, "-");

				// User Input
				int studentIDInput = Helper.readInt("Student ID: ");
				int registerIDInput = Helper.readInt("Register ID: ");

				// Check if login details correct (Zahid)
				boolean check = false; // Added this and for loop for checking, and also made changes to if statement
										// (Nicole)

				check = studentLogin(StudentList, studentIDInput, registerIDInput, check);

				if (check) {

					// This is the login menu yall add your menu items here(Zahid)
					C206_CaseStudy.loggedinmenu();

					while (option2 != 9) {
						option2 = Helper.readInt("Enter an option: ");

						if (option2 == 1) {

							// view/register CCA menu(Zahid)
							Helper.line(140, "-");
							System.out.println("CCA");
							Helper.line(140, "-");

							// Added for loops (Nicole)
							for (int i = 0; i < CCAList.size(); i++) {
								System.out.println((i + 1) + ". " + CCAList.get(i).getCca_title());
							}

							System.out.println("");
							option3 = Helper.readInt("Enter an option: ");

							int ccaOption = 0;

							for (int i = 0; i < CCAList.size(); i++) {
								if (option3 == (i + 1)) {
									Helper.line(140, "-");
									System.out.println("Description: " + CCAList.get(i).getDescription());
									System.out.println("CCA vacancy: " + CCAList.get(i).getClass_size() + "/50");
									System.out.println("Days: " + CCAList.get(i).getCca_day_of_the_week());
									System.out.println("Time: " + CCAList.get(i).getTime());
									System.out.println("Venue: " + CCAList.get(i).getVenue());
									ccaOption = option3 - 1;
								}
							}

							System.out.println("\n1. Register for CCA");
							System.out.println("9. Exit\n");

							option4 = Helper.readInt("Enter an option: ");

							if (option4 == 1) {
								// CCA Description(Zahid)

								if (option4 == 1) {
									s1.setCCA(CCAList.get(ccaOption).getCca_title());
									CCAList.get(ccaOption).setClass_size(CCAList.get(ccaOption).getClass_size() + 1);
									System.out.println("CCA successfully Added");
								}

								else {

								}
							}

						} else if (option2 == 2) {
							// add other menu item
						}
					}

				} else {
					System.out.println("Student ID or Register ID is incorrect, please try again.");
				}

			} else if (option == 2) {
				// (Register Codes) pls do

			} else if (option == 3) { 
				String lecId = Helper.readString("Enter administrator ID: ");
				String lecPassword = Helper.readString("Enter Password: ");
				int adminId = 0;
				boolean status = false;
				
				for(int x = 0; x<Lecturer.size();x++) {
					if (lecId.equals(Lecturer.get(x).getAdministratorId()) && (lecPassword.equals(Lecturer.get(x).getPassword()))) {
						status = true;
						adminId = x;
						break;
					}
				}
				
				if (status == true) {
					int choice = 0;
					while (choice != 9) {
						adminMenu(Lecturer, adminId);
						choice = Helper.readInt("Enter option: ");
					}
					
					
					
				} else {
					System.out.print("Invalid Id and Password");
				}
				
			} else if (option == 4) { 
				// Parent details (Nicole)
				if (parentList.size() != 0) {
					while (option2 != 9) {
						if (parentList.size() != 0) {
							parentMenu(parentList);

							option2 = Helper.readInt("Enter an option: ");

							if (option2 == 1) {
								option3 = Helper.readInt("Enter student ID to delete from parent list: ");

								for (int i = 0; i < parentList.size(); i++) {
									if (parentList.get(i).getStudentID() == option3) {
										parentList.remove(i);
										System.out.println("\nParent has been remove from list.");
										break;
									}
								}
							} else { System.out.println("Invalid option"); }
						} else { break; }
					}
				} else { System.out.println("There are no registered parents."); }
			} else { System.out.println("Invalid option"); }
		} System.out.println("Bye bye, have a nice day"); }


	/**
	 * @param Lecturer
	 * @param adminId
	 */
	private static void adminMenu(ArrayList<Administrator> Lecturer, int adminId) {
		Helper.line(140, "-");
		String welcome = String.format("Instrutor page\nWelcome %s",Lecturer.get(adminId).getLecturer_name());
		System.out.println(welcome);
		Helper.line(140, "-");
		System.out.println("1. Add CCA");
		System.out.println("2. View CCA");
		System.out.println("3. Delete CCA");
		System.out.println("9. Logout\n");
		Helper.line(140, "-");
	}


	/**
	 * @param parentList
	 */
	private static void parentMenu(ArrayList<Parent> parentList) {
		Helper.line(140, "-");
		System.out.println("STUDENT PARENT DETAILS LIST");
		Helper.line(140, "-");

		C206_CaseStudy.viewAllParents(parentList);
		Helper.line(140, "-");

		System.out.println("\n1. Delete parent from list");
		System.out.println("9. Exit\n");
	}


	/**
	 * @param StudentList
	 * @param studentIDInput
	 * @param registerIDInput
	 * @param check
	 * @return
	 */
	private static boolean studentLogin(ArrayList<Student> StudentList, int studentIDInput, int registerIDInput,
			boolean check) {
		for (int i = 0; i < StudentList.size(); i++) {
			
			int studentID = StudentList.get(i).getStudentID();
			int registerID = StudentList.get(i).getRegisterID();
			
			if ((studentIDInput == studentID)
					&& (registerIDInput == registerID)) {
				check = true;
				break;
			}
		}
		return check;
	}


	/**
	 * @param Lecturer
	 */
	private static void generateRandomLecturer(ArrayList<Administrator> Lecturer) {
		// For CCA lecturer (Sean)
		Administrator admin1 = new Administrator("Sports", 0, "Football", "Play with our feet is fun", 1,
				"Mondays and Wednesdays", 1600, "Field", "2104", "David", "I wanna sleep.");
		Lecturer.add(admin1);
	}


	/**
	 * @param parentList
	 */
	private static void generateRandomParent(ArrayList<Parent> parentList) {
		// for Login Testing (Nicole)
		Parent p1 = new Parent(123, 123, "Sponge", "C123", "Mr. Sqaurepants", "Bob", "spongebob@gmail.com", 1234578);
		p1.setCCA("Basketball");
		parentList.add(p1);
	}


	/**
	 * @param StudentList
	 * @return
	 */
	private static Student generateRandomStudent(ArrayList<Student> StudentList) {
		// for Login Testing (Zahid)
		Student s1 = new Student(123, 321);
		s1.setCCA("Football");
		StudentList.add(s1);
		return s1;
	}


	/**
	 * @param CCAList
	 */
	private static void generateRandomCCA(ArrayList<CCA> CCAList) {
		// Test CCA variable (Zahid)
		CCA cca1 = new CCA("Sports", 0, "Football", "Play with our feet is fun", 1, "Mondays and Wednesdays", 1600,
				"Field");
		CCA cca2 = new CCA("Sports", 1, "Bouldering", "Climbing is fun!", 1, "Tuesdays and Thursdays", 1600,
				"Rock Wall");
		CCAList.add(cca1);
		CCAList.add(cca2);
	}
		

	public static void startmenu() {
		// Sean
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Staff Login");
		System.out.println("4. Parent details");
		System.out.println("9. Exit \n");
	}


	public static String toDoStaff(String yeet) {

		return "";
	}

	public static void loggedinmenu() {
		// Add more options for the log in menu(Zahid)
		Helper.line(140, "-");
		System.out.println("1. View/Register for CCA");
		System.out.println("2. ?");
		System.out.println("9. Exit \n");
	}

	public static void setHeader(String header) {
		Helper.line(140, "-");
		System.out.println(header);
		Helper.line(140, "-");
	}

	public static void viewAllParents(ArrayList<Parent> parentList) { // Made by Nicole
		String output = String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", "STUDENT ID", "REGISTER ID",
				"STUDENT NAME", "CLASSROOM", "TEACHER", "PARENT NAME", "PARENT EMAIL", "CONTACT NO");

		for (int i = 0; i < parentList.size(); i++) {
			output += parentList.get(i).toString();
		}
		System.out.println(output);
	}
}
