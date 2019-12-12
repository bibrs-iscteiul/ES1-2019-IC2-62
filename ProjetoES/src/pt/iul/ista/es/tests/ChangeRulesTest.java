package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.applications.ChangeRules;
import pt.iul.ista.es.applications.Frame;

class ChangeRulesTest {

	static ChangeRules changeRules;
	static Frame frame;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		frame = new Frame();
		changeRules = new ChangeRules(frame);
		
	}
	
	@Test
	void test() {
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		//testSetFrame
		changeRules.setFrame(frame);
		assertEquals(changeRules.getFrame(),frame);
		
		//testSetDefinedRules
		changeRules.setDefinedRules(true);
		assertEquals(changeRules.isDefinedRules(),true);
	}
}
