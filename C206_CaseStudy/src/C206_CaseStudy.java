import java.util.ArrayList;
import java.util.Random;

import ga.Student;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
        ArrayList<ccaCategory> ccaCategoryList = new ArrayList<ccaCategory>();
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
				// Registration for parent (Yulong)
				Parent studentNew = inputStudent();
				C206_CaseStudy.addParent(parentList, studentNew);
				System.out.println("You have successfully registered!");
				
				// Registration for parent (Nicole)
				Parent parentNew = inputParent();
				C206_CaseStudy.addParent(parentList, parentNew);
				System.out.println("You have successfully registered!");
				

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
						if(choice == 1) {
							boolean loop = true;
							addCCA(CCAList, loop);
												
						} else if (choice == 2) {
							
							viewCCAList(CCAList);
							
						} else if (choice == 3) {
							
							Helper.line(140, ".");
							System.out.println("Delete CCA");
							Helper.line(140, ".");
							displayCCAName(CCAList);
							String del = Helper.readString("Do you want to remove a CCA (Y/N): ");
							if (del.equalsIgnoreCase("n")) {
								break;
							} else {
								int removeCCA = Helper.readInt("Enter CCA number from table : ");
								if(removeCCA>-1) {
									CCAList.remove(removeCCA-1);
								}
							}
						} else if (choice == 4) {
							// Parent details (Nicole)
							if (parentList.size() != 0) {
								while (option2 != 9) {
									if (parentList.size() != 0) {
										parentMenu(parentList);
	
										option2 = Helper.readInt("Enter an option: ");
	
										if (option2 == 1) {
											option3 = Helper.readInt("Enter student ID to delete from parent list: ");
	
											deleteParent(parentList, option3);
											
										} else { System.out.println("Invalid option"); }
									} else { break; }
								}
							} else { System.out.println("There are no registered parents."); 
							}
						}
						
					

					
				} else {
					System.out.print("Invalid Id and Password");
				}
			}else if(option==9){
				System.out.println("Bye bye, have a nice day");
			} else { 
				System.out.println("Invalid option");
			}
			}
				 
		 
}
	
/**
	 * @return
	 */
	private static Parent inputStudent() {
		// TODO Auto-generated method stub
		return null;
	}


//	yulong
	public static void deleteStudent(ArrayList<Student> StudentList, int option) {
		for (int i = 0; i < StudentList.size(); i++) {
			if (StudentList.get(i).getStudentID() == option) {
				StudentList.remove(i);
				System.out.println("\nStudent has been remove from the list.");
				break;
			}
		}
	}

	/**
	 * @param parentList
	 * @param option3
	 */
	public static boolean deleteParent(ArrayList<Parent> parentList, int option) {
		
		boolean deleted = false;
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getStudentID() == (option-1)) {
				parentList.remove(i);
				System.out.println("\nParent has been remove from list.");
				deleted = true;
				break;
			}
		}
		return deleted;
	}


	/**
	 * @param CCAList
	 */
	private static void displayCCAName(ArrayList<CCA> CCAList) {
		String display = "";
		for (int num = 0;num<CCAList.size();num++) {
			display += String.format("%d: %s\n ", num+1, CCAList.get(num).getCca_title());
		}
		System.out.println(display);
	}


	/**
	 * @param CCAList
	 */
	private static void viewCCAList(ArrayList<CCA> CCAList) {
		Helper.line(140, "-");
		for(int v =0 ; v<CCAList.size();v++) {
			Helper.line(140, "+");
			String viewCCA = String.format("Category: %s\n", CCAList.get(v).getCat_title());
			viewCCA += String.format("Category ID: %d\n", CCAList.get(v).getCat_id());
			viewCCA += String.format("CCA: %s\n", CCAList.get(v).getCca_title());
			viewCCA += String.format("Desciption: %s\n", CCAList.get(v).getDescription());
			viewCCA += String.format("Class Size: %d\n", CCAList.get(v).getClass_size());
			viewCCA += String.format("Day of the week: %s\n", CCAList.get(v).getCca_day_of_the_week());
			viewCCA += String.format("Time: %d\n", CCAList.get(v).getTime());
			viewCCA += String.format("Venue: %s\n", CCAList.get(v).getVenue());
			System.out.println(viewCCA);
			Helper.line(140, "+");
		}
		Helper.line(140, "-");
	}


	/**
	 * @param CCAList
	 * @param loop
	 */
	private static void addCCA(ArrayList<CCA> CCAList, boolean loop) {
		Helper.line(140, "-");
		while(loop != false) {
			boolean leave = false;
			String ccaName = Helper.readString("Enter new CCA name: ");
			String leaveAdd = Helper.readString("Do you want to exit adding CCA (Y/N): ");
			if(leaveAdd.equalsIgnoreCase("y")) {
				loop = false;
			} else {
				if(!ccaName.isEmpty()) {
					String description = Helper.readString("Enter CCA's description: ");
					
					if(!description.isEmpty()) {
						int size = Helper.readInt("Enter CCA's class size: ");
						
						if(size!=0) {
							String day = Helper.readString("Enter when the CCA will occur(weekdays): ");
							if(!day.equalsIgnoreCase("saturaday") || !day.equalsIgnoreCase("sunday") && !day.isEmpty()) {
								int time = 0;
								time = Helper.readInt("Enter what time the CCA will occur(24HR): ");
								if(time!=0 && time < 2401 && time > 999) {
									
									String venue = Helper.readString("Enter where the CCA will occur(weekdays): ");
									
									if(!venue.isEmpty()) {
										String category = Helper.readString("Enter CCA category: ");
										int categoryID = Helper.readInt("Enter CCA category ID: ");
										boolean allow = false;
										allow = checkCategoryID(CCAList, categoryID, allow);
										
										if(allow==true) {
											CCA newCCA = new CCA(category, categoryID, ccaName, description, size, day, time, venue);
											addCCA(CCAList, ccaName, newCCA);
											leave = true;
											loop = false;
										} else {
											System.out.println("Category ID has already been taken");
										}
										
									} else {
										System.out.println("CCA venue is empty, please try again");
									}
									
								} else {
									System.out.println("CCA time is empty, please try again");
								}
									
							} else {
								System.out.println("CCA cannot be empty and cannot occur during the weekend, Please try again");
							}
								
						} else {
							System.out.println("CCA description is empty, please try again");
						}
					} else {
						System.out.println("CCA description is empty, please try again");
					}
				} else {
					System.out.println("CCA name is empty, please try again");
				}
			}
		}
		Helper.line(140, "-");
	}


	/**
	 * @param CCAList
	 * @param ccaName
	 * @param newCCA
	 */
	static void addCCA(ArrayList<CCA> CCAList, String ccaName, CCA newCCA) {
		CCAList.add(newCCA);
		System.out.println(ccaName+" has been successfully added to database");
	}


	/**
	 * @param CCAList
	 * @param categoryID
	 * @param allow
	 * @return
	 */
	private static boolean checkCategoryID(ArrayList<CCA> CCAList, int categoryID, boolean allow) {
		for (int s =0;s<CCAList.size();s++) {
			if(CCAList.get(s).getCat_id()!=categoryID) {
				allow = true;
				break;
			}
		}
		return allow;
	}


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
		System.out.println("4. Parent details");
		System.out.println("5. Add CCA category");
		System.out.println("6. View CCA category");
		System.out.println("7. Delete CCA category");
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

		System.out.println(C206_CaseStudy.viewAllParents(parentList));
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
	 */
	private static void generateRandomStudent(ArrayList<Student> StudentList) {
		// for Login Testing (Zahid)
		Student s1 = new Student(123, 321);
		s1.setCCA("Football");
		StudentList.add(s1);
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
		System.out.println("5. Add CCA category");
		System.out.println("6. View CCA category");
		System.out.println("7. Delete CCA category");
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
	
//	yulong
	public static void viewAllStudent(ArrayList<Student> StudentList) { 
		String output = String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", "STUDENT ID", "REGISTER ID");

		for (int i = 0; i < StudentList.size(); i++) {
			output += StudentList.get(i).toString();
		}
		System.out.println(output);
	}

	public static String viewAllParent(ArrayList<Parent> parentList) { // Made by Nicole
		String output = String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", "STUDENT ID", "REGISTER ID",
				"STUDENT NAME", "CLASSROOM", "TEACHER", "PARENT NAME", "PARENT EMAIL", "CONTACT NO");

		for (int i = 0; i < parentList.size(); i++) {
			output += parentList.get(i).toString();
		}
		return output;
	}
	
//	yulong (student register(add))
	public static void addStudent(ArrayList<Student> StudentList) {
		int studentID = Helper.readInt("Enter student ID > ");
		int registerID = Helper.readInt("Enter register ID > ");
			
		boolean exists = false;
		
		for (int i = 0; i < StudentList.size(); i++) {
			if (StudentList.get(i).getStudentID() == studentID) {
				exists = true;
				break;
			}
		}
		
		if (exists) {
			System.out.println("You have already registered using this student ID!");
		} else {
				Random rand = new Random();
				registerID = 10000 + rand.nextInt(90000);
				System.out.println("Your register ID is " + registerID);
				
				Student studentNew = new Student(studentID, registerID);
				StudentList.add(studentNew);
			}
	}
	
	public static Parent inputParent() { //Registration for parent -Nicole
		int studentID = Helper.readInt("Please enter your child's studentID: ");
		String studentName = Helper.readString("Please enter your child's name: ");
		String classroom = Helper.readString("Please enter your child's classroom code: ");
		String teacher = Helper.readString("Please enter your child's teacher name: ");
		String parentName = Helper.readString("Please enter your name: ");
		String parentEmail = Helper.readString("Please enter your email address: ");
		int contactNo = Helper.readInt("Please enter your contact number: ");

		boolean done = false;
		
		while (done == false) {
			String contact = contactNo + "";
			if (contact.length() == 8) {
				done = true;
			} else {
				System.out.println("Please enter a valid contact number!");
				contactNo = Helper.readInt("Please enter your contact number: ");
			}
		}
		Random rand = new Random();
		int registrationID = 10000 + rand.nextInt(90000);
		System.out.println("Your registration ID is " + registrationID);
		
		Parent parentNew = new Parent(studentID, registrationID, studentName, classroom, teacher, parentName, parentEmail, contactNo);
		return parentNew;
		
	}
	
	public static void addParent(ArrayList<Parent> parentList, Parent parentNew) { //Registration for parent -Nicole
					
		boolean exists = false;
		
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getStudentID() == parentNew.getStudentID()) {
				exists = true;
				break;
			}
		}
		
		if (exists) {
			System.out.println("You have already registered using this student ID!");
		} else {
				parentList.add(parentNew);
			
		}
	}
}
