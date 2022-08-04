import java.util.ArrayList;
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		
		int option = 0;
		
		while (option != 9) {
			C206_CaseStudy.startmenu();
			option = Helper.readInt("Enter an option: ");
			
			if (option == 1) {
				
			} else if (option == 2) {
				
			} else if (option == 9) {
				System.out.println("Bye bye, have a nice day");
			} else {
				System.out.println("Invalid option");
			}
		}

	}
	
	public static void startmenu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		Helper.line(80, "=");
		System.out.println("1. Login");
		System.out.println("2. Register");
		Helper.line(80, "=");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}
