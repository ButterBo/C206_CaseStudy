import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Administrator admin1;
	private CCA cca1;
	private Category c1;
	private Category c2;
	private Parent p1;
	private Parent p2;

	private ArrayList<Parent> parentList;
	private ArrayList<Administrator> lectureList;
	private ArrayList<CCA> ccaList;
	private ArrayList<Category> ccaCategoryList;

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
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddParent() {
		assertNotNull("Test if there is valid Parent arraylist to add to", parentList);

		C206_CaseStudy.addParent(parentList, p1);
		assertEquals("Test if the Parent arraylist size is now 1", 1, parentList.size());

		assertSame("Test that Parent that has just been added is the same as the 1st item of the parent list", p1, parentList.get(0));

		C206_CaseStudy.addParent(parentList, p2);
		assertEquals("Test that Parent arraylist size is now 2", 2, parentList.size());
		assertSame("Test that new Parent that is added is the same as 2nd item of the list", p2, parentList.get(1));
	}
	
	@Test
	public void testRetrieveAllChromebook() {

		// test if the list of chromebooks retrieved from the SourceCentre is empty
		String allChromebook = C206_CaseStudy.viewAllParents(parentList);
		String testOutput = "";
		assertEquals("Check that viewAllParents is not empty", testOutput, allChromebook);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());

		// test if the expected output string same as the list of chromebooks retrieved
		// from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st", "Yes", "",
				"Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "",
				"Win 10");

		assertEquals("Check that ViewAllChromebookList", testOutput, allChromebook);
	}

	@Test   //yongxuan
	public void testDeleteCategory() {
		//test if category list is not null but empty -boundary
		assertNotNull ("test if there is valid category arrayList to retrieve item", ccaCategoryList);
		
		//given an empty list, after adding 2 items, test if the size of the list is 0 -normal
		C206_CaseStudy.addCategory(ccaCategoryList, c1);
		C206_CaseStudy.addCategory(ccaCategoryList, c2);
		
		assertEquals("check that categorylist size is 0", 0, ccaCategoryList.size());
	}
}
