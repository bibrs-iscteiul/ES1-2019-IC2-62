package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.applications.Method;
import pt.iul.ista.es.applications.ReadFromFile;

class ReadFromFileTest {

	static ReadFromFile readFile;
	static List<Method> method;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		readFile = new ReadFromFile();
		method = readFile.read("Long-Method.xlsx", 0);
	}

	@Test
	void testRead() {
		try {
			assertEquals(readFile.read("Long-Method.xlsx", 0), method);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {	

		//testSetRowNumber
		readFile.setRowNumber(1);
		assertEquals(readFile.getRowNumber(), 1);

		//testSetColNumber
		readFile.setColNumber(1);
		assertEquals(readFile.getColNumber(), 1);
	}

}
