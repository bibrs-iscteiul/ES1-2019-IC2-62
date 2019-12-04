package pt.iul.ista.es.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pt.iul.ista.es.applications.Method;

/**
 * The Class ChangeRules.
 * @author Gonçalo Almeida
 * @since 2019-11-10
 */
public class ChangeRules {

	/** The define rules. */
	JDialog defineRules = new JDialog();

	/** The frame. */
	Frame frame;
	
	int locThreeshold = -1;
	int cycloThreeshold = -1;
	int laaThreeshold = -1;
	int atfdThreeshold = -1;
	
	String locOperator;
	String cycloOperator;
	String laaOperator;
	String atfdOperator;

	String longMethodOperator;
	String featureEnvyOperator;
	
	JTextField text_loc;
	JTextField text_cyclo;
	JTextField text_atfd;
	JTextField text_laa;
	
	JComboBox<String> lmOperator;
	JComboBox<String> feOperator;
	
	JComboBox<String> locBox;
	JComboBox<String> cycloBox;
	JComboBox<String> atfdBox;
	JComboBox<String> laaBox;
	
	boolean definedRules;
	
	/**
	 * Instantiates a new change rules.
	 *
	 * @param frame the frame
	 */
	public ChangeRules(Frame frame) {
		defineRules = new JDialog();
		addFrameContent();
		defineRules.pack();
		defineRules.setSize(700, 300);
		
		this.frame = frame;
	}

	public Frame getFrame() {
		return frame;
	}
	
	public boolean isDefinedRules() {
		return definedRules;
	}

	public void setDefinedRules(boolean definedRules) {
		this.definedRules = definedRules;
	}

	public int getLocThreeshold() {
		return locThreeshold;
	}
	
	public int getCycloThreeshold() {
		return cycloThreeshold;
	}

	public int getLaaThreeshold() {
		return laaThreeshold;
	}

	public int getAtfdThreeshold() {
		return atfdThreeshold;
	}

	public String getLocOperator() {
		return locOperator;
	}

	public String getCycloOperator() {
		return cycloOperator;
	}
	
	public String getLaaOperator() {
		return laaOperator;
	}
	
	public String getAtfdOperator() {
		return atfdOperator;
	}
	
	public String getLongMethodOperator() {
		return longMethodOperator;
	}
	
	public String getFeatureEnvyOperator() {
		return featureEnvyOperator;
	}
	
	
	/**
	 * Open.
	 */
	public void open() {
		defineRules.setVisible(true);
	}

	/**
	 * Adds the frame content.
	 */
	private void addFrameContent() {

		String[] operadores = {"-", ">", "<", "="};

		JLabel loc = new JLabel();
		loc.setText("Valor do LOC: ");
		text_loc = new JTextField("LOC");
		locBox = new JComboBox(operadores);

		JLabel cyclo = new JLabel();
		cyclo.setText("Valor do CYCLO: ");
		text_cyclo = new JTextField("CYCLO");
		cycloBox = new JComboBox(operadores);

		JLabel atfd = new JLabel();
		atfd.setText("Valor do ATFD: ");
		text_atfd = new JTextField("ATDF");
		atfdBox = new JComboBox(operadores);

		JLabel laa = new JLabel();
		laa.setText("Valor do LAA: ");
		text_laa = new JTextField("LAA");
		laaBox = new JComboBox(operadores);


		String[] op = {"-", "or", "and"};
		JLabel lm = new JLabel("Operaçăo do Long Method: ");
		lmOperator = new JComboBox(op);
		JLabel fe = new JLabel("Operaçăo do Feature Envy: ");
		feOperator = new JComboBox(op);

		JButton definir = new JButton("Definir");

		definir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveRules();
			
				//defineRules.setVisible(false);
			}
		});

		JPanel dr = new JPanel();
		dr.setLayout(new GridLayout(10, 1));

		JPanel ploc = new JPanel();
		JPanel ploc2 = new JPanel();
		ploc.setLayout(new GridLayout(1, 2));
		ploc2.setLayout(new GridLayout(1, 3));
		ploc.add(loc);
		ploc.add(text_loc);
		ploc2.add(locBox);
		dr.add(ploc);
		dr.add(ploc2);

		JPanel pcyclo = new JPanel();
		JPanel pcyclo2 = new JPanel();
		pcyclo.setLayout(new GridLayout(1, 2));
		pcyclo2.setLayout(new GridLayout(1, 3));
		pcyclo.add(cyclo);
		pcyclo.add(text_cyclo);
		pcyclo2.add(cycloBox);
		dr.add(pcyclo);
		dr.add(pcyclo2);

		JPanel patfd = new JPanel();
		JPanel patfd2 = new JPanel();
		patfd.setLayout(new GridLayout(1, 2));
		patfd2.setLayout(new GridLayout(1, 3));
		patfd.add(atfd);
		patfd.add(text_atfd);
		patfd2.add(atfdBox);
		dr.add(patfd);
		dr.add(patfd2);

		JPanel plaa = new JPanel();
		JPanel plaa2 = new JPanel();
		plaa.setLayout(new GridLayout(1, 2));
		plaa2.setLayout(new GridLayout(1, 3));
		plaa.add(laa);
		plaa.add(text_laa);
		plaa2.add(laaBox);
		dr.add(plaa);
		dr.add(plaa2);

		dr.add(lm);
		dr.add(lmOperator);
		dr.add(fe);
		dr.add(feOperator);

		dr.add(definir, BorderLayout.SOUTH);
		defineRules.add(dr);
	}
	
	public void saveRules() {
		
		if (text_loc.getText().matches("[0-9]+")) {
			locThreeshold = Integer.parseInt(text_loc.getText());
			System.out.println("threeshold loc is " + locThreeshold);
		}

		if (text_cyclo.getText().matches("[0-9]+")) {
			cycloThreeshold = Integer.parseInt(text_cyclo.getText());
			System.out.println("threeshold cyclo is " + cycloThreeshold);
		}

		if (text_atfd.getText().matches("[0-9]+")) {
			atfdThreeshold = Integer.parseInt(text_atfd.getText());
			System.out.println("threeshold atfd is " + atfdThreeshold);
		}

		if (text_laa.getText().matches("[0-9]+")) {
			laaThreeshold = Integer.parseInt(text_laa.getText());
			System.out.println("threeshold laa is " + laaThreeshold);
		}
					
		if(!(lmOperator.getSelectedItem().toString() == "null") || !(lmOperator.getSelectedItem().toString() == "-")) {
			longMethodOperator = lmOperator.getSelectedItem().toString();
			System.out.println("long method operator is " + longMethodOperator);
		}
		
		if(!(feOperator.getSelectedItem().toString() == "null") || !(feOperator.getSelectedItem().toString() == "-")) {
			featureEnvyOperator = feOperator.getSelectedItem().toString();
			System.out.println("feature envy operator is " + featureEnvyOperator);
		}
		
		if(!(locBox.getSelectedItem().toString() == "-")) {
			locOperator = locBox.getSelectedItem().toString();
			System.out.println("loc operator is " + locOperator);
		}
		
		System.out.println("cyclo operator before if " + cycloBox.getSelectedItem().toString());
		if(!(cycloBox.getSelectedItem().toString() == "-")) {
			cycloOperator = cycloBox.getSelectedItem().toString();
			System.out.println("cyclo operator is " + cycloOperator);
		}
		
		if(!(laaBox.getSelectedItem().toString() == "-")) {
			laaOperator = laaBox.getSelectedItem().toString();
			System.out.println("laa operator is " + laaOperator);
		}
		
		if(!(atfdBox.getSelectedItem().toString() == "-")) {
			atfdOperator = atfdBox.getSelectedItem().toString();
			System.out.println("atfd operator is " + atfdOperator);
		}
		
		boolean longMethodValido;
		boolean featureEnvyValido;
		boolean metricasValidas;
		
		if(locThreeshold != -1 && cycloThreeshold != -1 && (longMethodOperator.equals("null") || longMethodOperator.equals("-"))) {
			
			longMethodValido = false;
			System.out.println(longMethodValido);
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Long Method para continuar.", "Warning!", JOptionPane.WARNING_MESSAGE);
		} else {
			longMethodValido = true;
			System.out.println(longMethodValido);
		}
		
		if(atfdThreeshold != -1 && laaThreeshold != -1 && (featureEnvyOperator.equals("null") || featureEnvyOperator.equals("-"))) {
			featureEnvyValido = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Feature Envy para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else {
			featureEnvyValido = true;
		}
		
		if( (locThreeshold != -1 && locOperator == null) || (cycloThreeshold != -1 && cycloOperator == null) || (atfdThreeshold != -1 && atfdOperator == null) || (laaThreeshold != -1 && laaOperator == null) ) {
			metricasValidas = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador para as métricas definidas para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println("valor metricas validas " + metricasValidas);
		} else {
			metricasValidas = true;
			System.out.println("valor metricas validas " + metricasValidas);
		}
		
		if(longMethodValido && featureEnvyValido && metricasValidas) {
		
			definedRules = true;
		
			frame.updateRulesInGUI();
			
			if(frame.isExcelImportado()) {
			
				System.out.println("entrei no if excel");
				
				for (Method method : frame.getMethods()) {
	
					boolean longMethodUser = method.isLongMethodUser(locThreeshold, locOperator, cycloThreeshold, cycloOperator, longMethodOperator);
					method.setLongMethodUserBoolean(longMethodUser);
					
					boolean featureEnvyUser = method.isFeatureEnvyUser(atfdThreeshold, atfdOperator, laaThreeshold, laaOperator, featureEnvyOperator);
					method.setFeatureEnvyUserBoolean(featureEnvyUser);
				}
				
				frame.getMethodsJModel().clear();
				
				for (Method method : frame.getMethods()) 
					if(method.isLongMethodUserBoolean() || method.isFeatureEnvyUserBoolean())
						frame.getMethodsJModel().addElement("MethodID: " + method.getMethodID() + "; Long Method: " + method.isLongMethodUserBoolean() + "; Feature Envy: " + method.isFeatureEnvyUserBoolean());
	
				frame.getMethodsJList().setModel(frame.getMethodsJModel());
			}
			
			defineRules.setVisible(false);
		}
	}
}
