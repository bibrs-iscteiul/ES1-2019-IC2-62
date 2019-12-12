package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.applications.ChooseRule;
import pt.iul.ista.es.applications.Frame;
import pt.iul.ista.es.applications.Rule;

class ChooseRuleTest {
	
	static ChooseRule chooseRule;
	static Frame frame;
	static Rule rule;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		frame = new Frame();
		chooseRule = new ChooseRule(frame);
		rule = new Rule(5, "loc", 5, "cyclo", "longMethod",
				5, "atfd", 0.5, "laa", "featureEnvy");
	}

	@Test
	void test() {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		//setSelectedRuleLongMethod
		chooseRule.setSelectedRuleLongMethod(rule);
		assertEquals(chooseRule.getSelectedRuleLongMethod(), rule);
		
		//testSetSelectedRuleFeatureEnvy
		chooseRule.setSelectedRuleFeatureEnvy(rule);
		assertEquals(chooseRule.getSelectedRuleFeatureEnvy(), rule);
	}
}
