//class created by sean
public class Administrator extends CCA{
	private String administratorId;
	private String lecturer_name;
	private String password;
	
	public Administrator(String title, int id, String cca_title, String description, int class_size,
			String cca_day_of_the_week, int time, String venue, String administratorId, String lecturer_name,
			String password) {
		super(title, id, cca_title, description, class_size, cca_day_of_the_week, time, venue);
		this.administratorId = administratorId;
		this.lecturer_name = lecturer_name;
		this.password = password;
	}

	public String getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(String administratorId) {
		this.administratorId = administratorId;
	}

	public String getLecturer_name() {
		return lecturer_name;
	}

	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toStringCCA() {//to allow the CCA instructor to view CCA is mostly likely created by them
		String output = String.format("CCA: %s \n Description: \n Class size: %d \n Day available: \n Venue: %s \n "
				+ "Time: %s", getCca_title(), getDescription(), getClass_size(), getCca_day_of_the_week(),
				getVenue(), getTime());
		
		return output;
	}
	
	

}
