/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: zahid
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Friday 05-08-2022 22:53
 */

/**
 * @author zahid
 *
 */
public class Student {
	
	private int studentID;
	private int registerID;
	private String CCA;
	
	public Student(int studentID, int registerID) {
		this.studentID = studentID;
		this.registerID = registerID;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public int getRegisterID() {
		return registerID;
	}
	
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}
	
	public String getCCA() {
		return CCA;
	}
	
	public void setCCA(String cCA) {
		CCA = cCA;
	}
}
