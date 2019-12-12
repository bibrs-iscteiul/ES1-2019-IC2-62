package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.applications.Method;

class MethodTest {

	static Method method;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		method = new Method(0, "package", "class", "methodname", 
				10, 10, 10, 0.5, true, true, true, true, true, true);

	}

	@Test
	void testIsLongMethodUser() {

		//falso final
		assertEquals(method.isLongMethodUser(-1, ">", -1, ">", "-"), false);


		//ands
		assertEquals(method.isLongMethodUser(5, ">", 5, ">", "and"), true);
		assertEquals(method.isLongMethodUser(5, ">", 15, ">", "and"), false);

		assertEquals(method.isLongMethodUser(15, "<", 15, "<", "and"), true);
		assertEquals(method.isLongMethodUser(5, "<", 15, "<", "and"), false);

		assertEquals(method.isLongMethodUser(10, "=", 10, "=", "and"), true);
		assertEquals(method.isLongMethodUser(10, "=", 11, "=", "and"), false);

		assertEquals(method.isLongMethodUser(5, ">", 15, "<", "and"), true);
		assertEquals(method.isLongMethodUser(5, ">", 5, "<", "and"), false);

		assertEquals(method.isLongMethodUser(15, "<", 5, ">", "and"), true);
		assertEquals(method.isLongMethodUser(10, "<", 5, ">", "and"), false);

		assertEquals(method.isLongMethodUser(5, ">", 10, "=", "and"), true);
		assertEquals(method.isLongMethodUser(15, ">", 11, "=", "and"), false);

		assertEquals(method.isLongMethodUser(15, "<", 10, "=", "and"), true);
		assertEquals(method.isLongMethodUser(10, "<", 11, "=", "and"), false);

		assertEquals(method.isLongMethodUser(10, "=", 5, ">", "and"), true);
		assertEquals(method.isLongMethodUser(11, "=", 11, ">", "and"), false);

		assertEquals(method.isLongMethodUser(10, "=", 15, "<", "and"), true);
		assertEquals(method.isLongMethodUser(11, "=", 11, "<", "and"), false);


		//ors
		assertEquals(method.isLongMethodUser(5, ">", 5, ">", "or"), true);
		assertEquals(method.isLongMethodUser(10, ">", 10, ">", "or"), false);

		assertEquals(method.isLongMethodUser(15, "<", 15, "<", "or"), true);
		assertEquals(method.isLongMethodUser(10, "<", 10, "<", "or"), false);

		assertEquals(method.isLongMethodUser(10, "=", 10, "=", "or"), true);
		assertEquals(method.isLongMethodUser(15, "=", 11, "=", "or"), false);

		assertEquals(method.isLongMethodUser(5, ">", 15, "<", "or"), true);
		assertEquals(method.isLongMethodUser(10, ">", 10, "<", "or"), false);

		assertEquals(method.isLongMethodUser(15, "<", 5, ">", "or"), true);
		assertEquals(method.isLongMethodUser(10, "<", 10, ">", "or"), false);

		assertEquals(method.isLongMethodUser(5, ">", 10, "=", "or"), true);
		assertEquals(method.isLongMethodUser(15, ">", 11, "=", "or"), false);

		assertEquals(method.isLongMethodUser(15, "<", 10, "=", "or"), true);
		assertEquals(method.isLongMethodUser(10, "<", 11, "=", "or"), false);

		assertEquals(method.isLongMethodUser(10, "=", 5, ">", "or"), true);
		assertEquals(method.isLongMethodUser(11, "=", 10, ">", "or"), false);

		assertEquals(method.isLongMethodUser(10, "=", 15, "<", "or"), true);
		assertEquals(method.isLongMethodUser(11, "=", 10, "<", "or"), false);


		//quando é só o loc
		assertEquals(method.isLongMethodUser(5, ">", -1, "=", "-"), true);
		assertEquals(method.isLongMethodUser(15, ">", -1, "=", "-"), false);

		assertEquals(method.isLongMethodUser(15, "<", -1, "=", "-"), true);
		assertEquals(method.isLongMethodUser(5, "<", -1, "=", "-"), false);

		assertEquals(method.isLongMethodUser(10, "=", -1, "=", "-"), true);
		assertEquals(method.isLongMethodUser(15, "=", -1, "=", "-"), false);


		//quando é só o cyclo
		assertEquals(method.isLongMethodUser(-1, "=", 5, ">", "-"), true);
		assertEquals(method.isLongMethodUser(-1, "=", 15, ">", "-"), false);

		assertEquals(method.isLongMethodUser(-1, "=", 15, "<", "-"), true);
		assertEquals(method.isLongMethodUser(-1, "=", 5, "<", "-"), false);

		assertEquals(method.isLongMethodUser(-1, "=", 10, "=", "-"), true);
		assertEquals(method.isLongMethodUser(-1, "=", 15, "=", "-"), false);
	}

	@Test
	void testIsFeatureEnvyUser() {

		//falso final
		assertEquals(method.isFeatureEnvyUser(-1, ">", -1, ">", "-"), false);


		//ands

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.3, ">", "and"), true);
		assertEquals(method.isFeatureEnvyUser(5, ">", 15, ">", "and"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.7, "<", "and"), true);
		assertEquals(method.isFeatureEnvyUser(5, "<", 15, "<", "and"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.5, "=", "and"), true);
		assertEquals(method.isFeatureEnvyUser(10, "=", 11, "=", "and"), false);

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.7, "<", "and"), true);
		assertEquals(method.isFeatureEnvyUser(15, ">", 5, "<", "and"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.3, ">", "and"), true);
		assertEquals(method.isFeatureEnvyUser(10, "<", 5, ">", "and"), false);

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.5, "=", "and"), true);
		assertEquals(method.isFeatureEnvyUser(15, ">", 11, "=", "and"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.5, "=", "and"), true);
		assertEquals(method.isFeatureEnvyUser(10, "<", 11, "=", "and"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.3, ">", "and"), true);
		assertEquals(method.isFeatureEnvyUser(11, "=", 11, ">", "and"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.7, "<", "and"), true);
		assertEquals(method.isFeatureEnvyUser(11, "=", 11, "<", "and"), false);


		//ors

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.3, ">", "or"), true);
		assertEquals(method.isFeatureEnvyUser(10, ">", 10, ">", "or"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.7, "<", "or"), true);
		assertEquals(method.isFeatureEnvyUser(10, "<", 0.5, "<", "or"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.5, "=", "or"), true);
		assertEquals(method.isFeatureEnvyUser(15, "=", 11, "=", "or"), false);

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.7, "<", "or"), true);
		assertEquals(method.isFeatureEnvyUser(10, ">", 0.5, "<", "or"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.3, ">", "or"), true);
		assertEquals(method.isFeatureEnvyUser(10, "<", 10, ">", "or"), false);

		assertEquals(method.isFeatureEnvyUser(5, ">", 0.5, "=", "or"), true);
		assertEquals(method.isFeatureEnvyUser(15, ">", 11, "=", "or"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", 0.5, "=", "or"), true);
		assertEquals(method.isFeatureEnvyUser(10, "<", 11, "=", "or"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.3, ">", "or"), true);
		assertEquals(method.isFeatureEnvyUser(11, "=", 10, ">", "or"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", 0.7, "<", "or"), true);
		assertEquals(method.isFeatureEnvyUser(11, "=", 0.5, "<", "or"), false);


		//quando é só o atfd

		assertEquals(method.isFeatureEnvyUser(5, ">", -1, "=", "-"), true);
		assertEquals(method.isFeatureEnvyUser(15, ">", -1, "=", "-"), false);

		assertEquals(method.isFeatureEnvyUser(15, "<", -1, "=", "-"), true);
		assertEquals(method.isFeatureEnvyUser(5, "<", -1, "=", "-"), false);

		assertEquals(method.isFeatureEnvyUser(10, "=", -1, "=", "-"), true);
		assertEquals(method.isFeatureEnvyUser(15, "=", -1, "=", "-"), false);


		//quando é só o laa

		assertEquals(method.isFeatureEnvyUser(-1, "=", 0.3, ">", "-"), true);
		assertEquals(method.isFeatureEnvyUser(-1, "=", 15, ">", "-"), false);

		assertEquals(method.isFeatureEnvyUser(-1, "=", 0.7, "<", "-"), true);
		assertEquals(method.isFeatureEnvyUser(-1, "=", 0, "<", "-"), false);

		assertEquals(method.isFeatureEnvyUser(-1, "=", 0.5, "=", "-"), true);
		assertEquals(method.isFeatureEnvyUser(-1, "=", 15, "=", "-"), false);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		//testSetMethodID
		method.setMethodID(1);
		assertEquals(method.getMethodID(), 1);

		//testSetPackageName
		method.setPackageName("a");
		assertEquals(method.getPackageName(),"a");

		//testSetClassName
		method.setClassName("a");
		assertEquals(method.getClassName(),"a");
		
		//testSetMethodName
		method.setMethodName("a");
		assertEquals(method.getMethodName(),"a");
		
		//testSetLoc
		method.setLoc(1);
		assertEquals(method.getLoc(),1);
		
		//testSetCyclo
		method.setCyclo(1);
		assertEquals(method.getCyclo(),1);
		
		//testSetAtfd
		method.setAtfd(1);
		assertEquals(method.getAtfd(),1);
		
		//testSetLaa
		method.setLaa(0.1);
		assertEquals(method.getLaa(),0.1);
		
		//testSetIsLongMethod
		method.setIs_long_method(false);
		assertEquals(method.isIs_long_method(), false);

		//testSetIplasma
		method.setIplasma(false);
		assertEquals(method.isIplasma(), false);

		//testSetPmd
		method.setPmd(false);
		assertEquals(method.isPmd(), false);

		//testSetIsFeatureEnvy
		method.setIs_feature_envy(false);
		assertEquals(method.isIs_feature_envy(), false);

		//testSetLongMethodUserBoolean
		method.setLongMethodUserBoolean(false);
		assertEquals(method.isLongMethodUserBoolean(), false);

		//testSetFeatureEnvyUserBoolean
		method.setFeatureEnvyUserBoolean(false);
		assertEquals(method.isFeatureEnvyUserBoolean(), false);
	}
	
	@Test
	void testToString() {
		String s = ("ID: " + method.getMethodID() + "; Package: " + method.getPackageName() + "; Classe: " + method.getClassName() + 
				"; Método: " + method.getMethodName() + "; LOC: " + method.getLoc() + "; CYCLO: " + method.getCyclo() + "; ATFD: " + method.getAtfd() + "; LAA: " 
				+ method.getLaa() + "; isLongMethod: " + method.isIs_long_method() + "; iPlasma: " + method.isIplasma() + "; PMD: " 
				+ method.isPmd() + "; isFeatureEnvy: " + method.isIs_feature_envy());
		assertEquals(method.toString(), s);
	}

}
