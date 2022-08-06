
public class Parent extends Student {

	private String studentName;
	private String classroom;
	private String classroomTeacher;
	private String parentName;
	private String parentEmail;
	private int contactNo;
	
	public Parent(int studentID, int registerID, String studentName, String classroom, String classroomTeacher, String parentName, String parentEmail, int contactNo) {
		super(studentID, registerID);
		this.studentName = studentName;
		this.classroom = classroom;
		this.classroomTeacher = classroomTeacher;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.contactNo = contactNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getClassroomTeacher() {
		return classroomTeacher;
	}

	public void setClassroomTeacher(String classroomTeacher) {
		this.classroomTeacher = classroomTeacher;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	public String toString() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10d", this.studentName, this.classroom, this.classroomTeacher, this.parentName, this.parentEmail, this.contactNo);
		return output;
	}
}
