package pt.iul.ista.es.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.iul.ista.es.gui.Frame;
import pt.iul.ista.es.gui.ReadFromFile;
import pt.iul.ista.es.gui.Rule;

class FrameTest {

	static Frame frame;
	static JFrame jframe;
	static JLabel label;
	static JComboBox<Rule> comboBox;
	static ReadFromFile readfile;
	static Rule rule;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		frame = new Frame();
		jframe = new JFrame();
		label = new JLabel("label");

		String[] s = {"combo"};
		comboBox = new JComboBox(s);
		readfile = new ReadFromFile();

		rule = new Rule(5, "loc", 5, "cyclo", "longMethod",
				5, "atfd", 0.5, "laa", "featureEnvy");
	}

	@Test
	void testCompare() {
		frame.compare(true, true);
		assertEquals(frame.getDci(), 1);
		
		frame.compare(true, false);
		assertEquals(frame.getDii(), 1);
		
		frame.compare(false, false);
		assertEquals(frame.getAdci(), 1);
		
		frame.compare(false, true);
		assertEquals(frame.getAdii(), 1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		//testSetFrame
		frame.setFrame(jframe);
		assertEquals(frame.getFrame(),jframe);

		//testSetLmLog
		frame.setLmLog(label);
		assertEquals(frame.getLmLog(),label);

		//testSetFeLog
		frame.setFeLog(label);
		assertEquals(frame.getFeLog(),label);

		//testSetRules
		frame.setRules(comboBox);
		assertEquals(frame.getRules(),comboBox);

		//testSetExcelImportado
		frame.setExcelImportado(true);
		assertEquals(frame.isExcelImportado(),true);

		//testSetReadFile
		frame.setReadFile(readfile);
		assertEquals(frame.getReadFile(),readfile);

		//testSetLastRuleDefined
		frame.setLastRuleDefined(rule);
		assertEquals(frame.getLastRuleDefined(), rule);

		//testSetDci
		frame.setDci(1);
		assertEquals(frame.getDci(), 1);

		//testSetDii
		frame.setDii(1);
		assertEquals(frame.getDii(), 1);

		//testSetAdci
		frame.setAdci(1);
		assertEquals(frame.getAdci(), 1);

		//testSetAdii
		frame.setAdii(1);
		assertEquals(frame.getAdii(), 1);

	}

}