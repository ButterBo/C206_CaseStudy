import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Administrator admin1;
	private CCA cca1;

	private ccaCategory c1;
	private ccaCategory c2;

	
	private ArrayList<Administrator> lectureList;
	private ArrayList<CCA> ccaList;

	private Parent p1;
	private Parent p2;

	private ArrayList<Parent> parentList;


	private ArrayList<Administrator> lectureList;
	private ArrayList<CCA> ccaList;
	private ArrayList<ccaCategory> CategoryList;



	public void setUp() throws Exception {

		admin1 = new Administrator("Sports", 0, "Football", "Play with our feet is fun", 1,
				"Mondays and Wednesdays", 1600, "Field", "2104", "David", "I wanna sleep.");
		cca1 = new CCA("Sports", 1, "Bouldering", "Climbing is fun!", 1, "Tuesdays and Thursdays", 1600,
				"Rock Wall");
		lectureList = new ArrayList<Administrator>();
		ccaList = new ArrayList<CCA>();

		p1 = new Parent(123, 123, "Sponge", "C123", "Mr. Sqaurepants", "Bob", "spongebob@gmail.com", 1234578);
		p2 = new Parent(234, 432, "John", "C234", "Mr. Cena", "Nathan", "johnathan@gmail.com", 87654321);

	}

	@Test
	public void testAddCCA() {
		assertNotNull("Check if CCA arraylist is not empty", ccaList);
		
		C206_CaseStudy.addCCA(ccaList, "Yeet", cca1 );
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check if cca is addedd", cca1, ccaList.get(0));
	}
	
	@Test
	public void viewCCA() {
		assertNotNull("Check if CCA arraylist is not empty", ccaList);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
//	yulong
	@Test
	public void testViewAllStudent() { 

		assertNotNull("Check that there is StudentList to add to", StudentList);

		String allStudent = C206_CaseStudy.viewAllStudent(StudentList);
		String testOutput = "";
		assertEquals("Check that the list of Student retrieved from C206_CaseStudy is empty", testOutput, allStudent);
		
		C206_CaseStudy.addStudent(StudentList);
		C206_CaseStudy.addStudent(StudentList);
		assertEquals("Test if after adding s1 and s2 to StudentList, the size is now 2", 2, StudentList.size());
		
		

		allStudent = C206_CaseStudy.viewAllParent(parentList);
		
		testOutput = String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", 123, 123, "Sponge", "C123", "Mr. Sqaurepants", "Bob", "spongebob@gmail.com", 1234578);
		testOutput += String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", 234, 432, "John", "C234", "Mr. Cena", "Nathan", "johnathan@gmail.com", 87654321);
		
		assertEquals("Test if the expected output is the same as the list of Student retrieved from C206_CaseStudy", testOutput, allStudent);
	}
	
//	yulong
	@Test   
	public void testDeleteStudent() {
		assertNotNull("Test if there is Student arraylist to delete from", StudentList);

		C206_CaseStudy.addStudent(StudentList);

		boolean deleted = C206_CaseStudy.deleteStudent(StudentList, 1);
		assertTrue("Test if Student has been deleted", deleted);
		assertEquals("Test that Student list size is now 1 after deleting", 1, StudentList.size());
		

		deleted = C206_CaseStudy.deleteStudent(StudentList, 3);
		assertFalse("Test if non-existing Student is not deleted", deleted);
		assertEquals("Test that Student list size is still 1", 1, StudentList.size());

		deleted = C206_CaseStudy.deleteStudent(StudentList, 1);
		assertFalse("Test that Student was deleted", deleted);
		assertEquals("Test that Student list size is now 0", 0, StudentList.size());
	}
	@Test
	public void testAddParent() { //Nicole
		assertNotNull("Test if there is valid Parent arraylist to add to", parentList);

		C206_CaseStudy.addParent(parentList, p1);
		assertEquals("Test if the Parent arraylist size is now 1", 1, parentList.size());

		assertSame("Test that Parent that has just been added is the same as the 1st item of the parent list", p1, parentList.get(0));

		C206_CaseStudy.addParent(parentList, p2);
		assertEquals("Test that Parent arraylist size is now 2", 2, parentList.size());
		assertSame("Test that new Parent that is added is the same as 2nd item of the list", p2, parentList.get(1));
	}
	
	@Test
	public void testViewAllParent() { // Nicole

		assertNotNull("Check that there is parentList to add to", parentList);

		String allParents = C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that the list of parents retrieved from C206_CaseStudy is empty", testOutput, allParents);
		
		C206_CaseStudy.addParent(parentList, p1);
		C206_CaseStudy.addParent(parentList, p2);
		assertEquals("Test if after adding p1 and p2 to parentList, the size is now 2", 2, parentList.size());
		
		

		allParents = C206_CaseStudy.viewAllParent(parentList);
		
		testOutput = String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", 123, 123, "Sponge", "C123", "Mr. Sqaurepants", "Bob", "spongebob@gmail.com", 1234578);
		testOutput += String.format("%-15s %-15s %-15s %-15s %-20s %-15s %-25s %-15s \n", 234, 432, "John", "C234", "Mr. Cena", "Nathan", "johnathan@gmail.com", 87654321);
		
		assertEquals("Test if the expected output is the same as the list of Parents retrieved from C206_CaseStudy", testOutput, allParents);
	}
	
	@Test
	public void testDeleteParent() { // Nicole

		assertNotNull("Test if there is Parent arraylist to delete from", parentList);

		C206_CaseStudy.addParent(parentList, p1);

		boolean deleted = C206_CaseStudy.deleteParent(parentList, 1);
		assertTrue("Test if parent has been deleted", deleted);
		assertEquals("Test that parent list size is now 1 after deleting", 1, parentList.size());
		

		deleted = C206_CaseStudy.deleteParent(parentList, 3);
		assertFalse("Test if non-existing parent is not deleted", deleted);
		assertEquals("Test that parent list size is still 1", 1, parentList.size());

		deleted = C206_CaseStudy.deleteParent(parentList, 1);
		assertFalse("Test that parent was deleted", deleted);
		assertEquals("Test that parent list size is now 0", 0, parentList.size());
	}

	@Test   //yongxuan
	public void testDeleteCategory() {
		//test if category list is not null but empty -boundary
		assertNotNull ("test if there is valid category arrayList to retrieve item", CategoryList);
		
		//given an empty list, after adding 2 items, test if the size of the list is 0 -normal
		C206_CaseStudy.addCategory(CategoryList, c1);
		C206_CaseStudy.addCategory(CategoryList, c2);
		
		assertEquals("check that categorylist size is 0", 0, CategoryList.size());
	}
	
	@Test
	public void testAddCategory() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid category arraylist to add to", CategoryList);
	
		C206_CaseStudy.addCategory(CategoryList, c1);
		assertEquals("Check that Category arraylist size is 1", 1, CategoryList.size());
		assertSame("Check that category is added", c1, CategoryList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
	
		C206_CaseStudy.addCategory(CategoryList, c2);
		assertEquals("Check that Category arraylist size is 2", 2, CategoryList.size());
		assertSame("Check that Category is added", c2, CategoryList.get(1));
	}
}