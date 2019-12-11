package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.gui.Rule;

class RuleTest {

	static Rule ruleConstrutor1;

	List<Rule> savedRules;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ruleConstrutor1 = new Rule(5, "loc", 5, "cyclo", "longMethod",
				5, "atfd", 0.5, "laa", "featureEnvy");
	}

	@Test
	void testToString() {
		String s = ("LOC " + ruleConstrutor1.getLocOperator() + " " + ruleConstrutor1.getLocThreeshold() + " " + ruleConstrutor1.getLongMethodOperator() + " " + 
				"CYCLO " + ruleConstrutor1.getCycloOperator() + " " + ruleConstrutor1.getCycloThreeshold() + " " + "ATFD " + ruleConstrutor1.getAtfdOperator() + 
				" " + ruleConstrutor1.getAtfdThreeshold() + " " + ruleConstrutor1.getFeatureEnvyOperator() + " " + "LAA " + ruleConstrutor1.getLaaOperator()
				+ " " + ruleConstrutor1.getLaaThreeshold() + " ");
		assertEquals(ruleConstrutor1.toString(), s); 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {		

		//testSetLocThreeshold
		ruleConstrutor1.setLocThreeshold(10);
		assertEquals(ruleConstrutor1.getLocThreeshold(), 10);

		//testSetLocOperator
		ruleConstrutor1.setLocOperator("a");
		assertEquals(ruleConstrutor1.getLocOperator(), "a");

		//testSetCycloThreeshold
		ruleConstrutor1.setCycloThreeshold(10);
		assertEquals(ruleConstrutor1.getCycloThreeshold(), 10);

		//testSetCycloOperator
		ruleConstrutor1.setCycloOperator("a");
		assertEquals(ruleConstrutor1.getCycloOperator(), "a");

		//testSetLongMethodOperator
		ruleConstrutor1.setLongMethodOperator("a");
		assertEquals(ruleConstrutor1.getLongMethodOperator(), "a");

		//testSetAtfdThreeshold
		ruleConstrutor1.setAtfdThreeshold(10);
		assertEquals(ruleConstrutor1.getAtfdThreeshold(), 10);

		//testSetAtfdOperator
		ruleConstrutor1.setAtfdOperator("a");
		assertEquals(ruleConstrutor1.getAtfdOperator(), "a");

		//testSetLaaThreeshold
		ruleConstrutor1.setLaaThreeshold(0.5);
		assertEquals(ruleConstrutor1.getLaaThreeshold(), 0.5);

		//testSetLaaOperator
		ruleConstrutor1.setLaaOperator("a");
		assertEquals(ruleConstrutor1.getLaaOperator(), "a");

		//testSetFeatureEnvyOperator
		ruleConstrutor1.setFeatureEnvyOperator("a");
		assertEquals(ruleConstrutor1.getFeatureEnvyOperator(), "a");

		//testSetLongMethod
		ruleConstrutor1.setLongMethod(true);
		assertEquals(ruleConstrutor1.isLongMethod(), true);

		//testSetFeatureEnvy
		ruleConstrutor1.setFeatureEnvy(true);
		assertEquals(ruleConstrutor1.isFeatureEnvy(), true);
	}

}
