package pt.iul.ista.es.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	MethodTest.class,
	ReadFromFileTest.class
})

public class AllTests {
}
