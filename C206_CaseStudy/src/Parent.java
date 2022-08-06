
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
	
	
	// student ID, name, grade and class, classroom teacher, parent’s name, parent’s email address, contact No, register ID
}
