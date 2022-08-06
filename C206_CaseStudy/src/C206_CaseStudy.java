import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<Student> StudentList = new ArrayList<Student>();

		// Test CCA variable (Zahid)
		CCA cca1 = new CCA("Sports",0, "Football","Play with our feet is fun", 1,"Mondays and Wednesdays", 1600, "Field");
		CCA cca2 = new CCA("Sports",1, "Bouldering","Climbing is fun!", 1,"Tuesdays and Thursdays", 1600, "Rock Wall");
		CCAList.add(cca1);
		CCAList.add(cca2);

		//for Login Testing (Zahid)
		Student s1 = new Student(123,321);
		s1.setCCA("Football");
		StudentList.add(s1);

		//option(menu) option2(loggedInMenu) option3(ccaMenu) option(ccaDetailsMenu)(Zahid)
		int option = 0;
		int option2 = 0;
		int option3 = 0;
		int option4 = 0;

		while (option != 9) {
			C206_CaseStudy.startmenu();
			option = Helper.readInt("Enter an option: ");

			if (option == 1) {

				Helper.line(30, "-");
				System.out.println("LOGIN");
				Helper.line(30, "-");

				//User Input
				int studentIDInput = Helper.readInt("Student ID: ");
				int registerIDInput = Helper.readInt("Register ID: ");

				//Check if login details correct (Zahid)

				if(studentIDInput == StudentList.get(0).getStudentID() == true && registerIDInput == StudentList.get(0).getRegisterID() == true) {

					//This is the login menu yall add your menu items here(Zahid)
					C206_CaseStudy.loggedinmenu();
					
					while (option2 != 9) {
						option2 = Helper.readInt("Enter an option: ");
						
						if (option2 == 1) {
							
							//view/register CCA menu(Zahid)
							Helper.line(30, "-");
							System.out.println("CCA");
							Helper.line(30, "-");
							
							for(int i = 0; i < CCAList.size();i++) {
								System.out.println((i+1) +". "+ CCAList.get(i).getCca_title());
							}
							
							option3 = Helper.readInt("Enter an option: ");
							
							if(option3 == 1) {
								//CCA Description(Zahid)
								Helper.line(30, "-");
								System.out.println(""+CCAList.get(0).getCca_title());
								Helper.line(30, "-");
								System.out.println("Description: "+CCAList.get(0).getDescription());
								System.out.println("CCA vacancy: "+CCAList.get(0).getClass_size()+"/50");
								System.out.println("Days: "+CCAList.get(0).getCca_day_of_the_week());
								System.out.println("Time: "+CCAList.get(0).getTime());
								System.out.println("Venue: "+CCAList.get(0).getVenue());
								Helper.line(30, "-");
								System.out.println("1. Register for CCA");
								System.out.println("2. View CCA");
								System.out.println("9. Exit");
								option4 = Helper.readInt("Enter an option: ");
								
								if(option4 == 1) {
									s1.setCCA(CCAList.get(0).getCca_title());
									CCAList.get(0).setClass_size(CCAList.get(0).getClass_size()+1);
									System.out.println("CCA successfully Added");
								}
								else if(option4 ==2) {
									Helper.line(30, "-");
									System.out.println(""+CCAList.get(0).getCca_title());
									Helper.line(30, "-");
									System.out.println("Vacancy: "+CCAList.get(0).getClass_size()+"/50");
									Helper.line(30, "-");
									for(int i = 0; i < StudentList.size();i++) {
										if(StudentList.get(i).getCCA().equals(CCAList.get(0).getCca_title()))
										System.out.println((i+1) +". "+ StudentList.get(i).getStudentID());
									}
								}

							}
						}
						else if(option2 == 2) {
							//add other menu item
						}
					} 
				}
				else {
					System.out.println("Student ID or Register ID is incorrect, please try again.");
				}

			}

		}
		if (option == 2) {
			//(Register Codes) pls do
		} 
		else if (option == 9) {
			System.out.println("Bye bye, have a nice day");
		} 
		else {
			System.out.println("Invalid option");
		}
	}

public static void startmenu() {
	C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
	Helper.line(80, "=");
	System.out.println("Main Menu");
	Helper.line(80, "=");
	System.out.println("1. Login");
	System.out.println("2. Register");
	System.out.println("9. Exit");
	Helper.line(80, "=");
}

public static void loggedinmenu() {

	// Add more options for the log in menu(Zahid)
	C206_CaseStudy.setHeader("Main Menu");
	Helper.line(80, "=");
	System.out.println("1. View/Register for CCA");
	System.out.println("2. ?");
	System.out.println("9. Exit");
	Helper.line(80, "=");
}

public static void setHeader(String header) {
	Helper.line(80, "-");
	System.out.println(header);
	Helper.line(80, "-");
}

}
