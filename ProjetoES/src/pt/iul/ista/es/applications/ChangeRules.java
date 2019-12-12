package pt.iul.ista.es.applications;

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
import pt.iul.ista.es.applications.Rule;


/**
 * The Class ChangeRules opens a new frame which is necessary to write the rules and save them.
 * 
 * @author Gonçalo Almeida e Joana Cavalheiro
 * @since 2019-11-10
 */
public class ChangeRules {

	/** The define rules. */
	JDialog defineRules;

	/** The frame. */
	Frame frame;

	/** The text loc. */
	JTextField text_loc;
	
	/** The text cyclo. */
	JTextField text_cyclo;
	
	/** The text atfd. */
	JTextField text_atfd;
	
	/** The text laa. */
	JTextField text_laa;

	/** The lm operator. */
	JComboBox<String> lmOperator;
	
	/** The fe operator. */
	JComboBox<String> feOperator;

	/** The loc box. */
	JComboBox<String> locBox;
	
	/** The cyclo box. */
	JComboBox<String> cycloBox;
	
	/** The atfd box. */
	JComboBox<String> atfdBox;
	
	/** The laa box. */
	JComboBox<String> laaBox;

	/** The defined rules. */
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

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() {
		return frame;
	}

	/**
	 * Sets the frame.
	 *
	 * @param frame the new frame
	 */
	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	/**
	 * Checks if is defined rules.
	 *
	 * @return true, if is defined rules
	 */
	public boolean isDefinedRules() {
		return definedRules;
	}

	/**
	 * Sets the defined rules.
	 *
	 * @param definedRules the new defined rules
	 */
	public void setDefinedRules(boolean definedRules) {
		this.definedRules = definedRules;
	}

	/**
	 * Open.
	 */
	public void open() {
		defineRules.setVisible(true);
	}

	/**
	 * Adds the frame content to the frame.
	 */
	private void addFrameContent() {

		String[] operadores = { "-", ">", "<", "=" };

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

		String[] op = { "-", "or", "and" };
		JLabel lm = new JLabel("Operaçăo do Long Method: ");
		lmOperator = new JComboBox(op);
		JLabel fe = new JLabel("Operaçăo do Feature Envy: ");
		feOperator = new JComboBox(op);

		JButton definir = new JButton("Definir");

		definir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveRules();
			}
		});

		JPanel dr = new JPanel();
		dr.setLayout(new GridLayout(7, 1));

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

	/**
	 * Read rules of gui and save them in a list of rules.
	 */
	public void saveRules() {

		Rule auxRule = new Rule();

		if (text_loc.getText().matches("[0-9]+")) 
			auxRule.setLocThreeshold(Integer.parseInt(text_loc.getText()));
	
		if (text_cyclo.getText().matches("[0-9]+"))
			auxRule.setCycloThreeshold(Integer.parseInt(text_cyclo.getText()));

		if (text_atfd.getText().matches("[0-9]+"))
			auxRule.setAtfdThreeshold(Integer.parseInt(text_atfd.getText()));
		
		if (text_laa.getText().matches(".*[0-9]+.*")) 
			auxRule.setLaaThreeshold(Double.parseDouble(text_laa.getText()));
		
		if (!(lmOperator.getSelectedItem().toString() == "null") || !(lmOperator.getSelectedItem().toString() == "-"))
			auxRule.setLongMethodOperator(lmOperator.getSelectedItem().toString());

		if (!(feOperator.getSelectedItem().toString() == "null") || !(feOperator.getSelectedItem().toString() == "-"))
			auxRule.setFeatureEnvyOperator(feOperator.getSelectedItem().toString());

		if (!(locBox.getSelectedItem().toString() == "-")) 
			auxRule.setLocOperator(locBox.getSelectedItem().toString());
		
		if (!(cycloBox.getSelectedItem().toString() == "-"))
			auxRule.setCycloOperator(cycloBox.getSelectedItem().toString());

		if (!(laaBox.getSelectedItem().toString() == "-"))
			auxRule.setLaaOperator(laaBox.getSelectedItem().toString());

		if (!(atfdBox.getSelectedItem().toString() == "-"))
			auxRule.setAtfdOperator(atfdBox.getSelectedItem().toString());

		boolean longMethodValido;
		boolean featureEnvyValido;
		boolean metricasValidas;

		if (auxRule.getLocThreeshold() != -1 && auxRule.getCycloThreeshold() != -1 && (auxRule.getLongMethodOperator().equals("null") || auxRule.getLongMethodOperator().equals("-"))) {
			longMethodValido = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Long Method para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else
			longMethodValido = true;

		if (auxRule.getAtfdThreeshold() != -1 && auxRule.getLaaThreeshold() != -1 && (auxRule.getFeatureEnvyOperator().equals("null") || auxRule.getFeatureEnvyOperator().equals("-"))) {
			featureEnvyValido = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Feature Envy para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else
			featureEnvyValido = true;

		if ((auxRule.getLocThreeshold() != -1 && auxRule.getLocOperator() == null) || (auxRule.getCycloThreeshold() != -1 && auxRule.getCycloOperator() == null) || (auxRule.getAtfdThreeshold() != -1 && auxRule.getAtfdOperator() == null) || (auxRule.getLaaThreeshold() != -1 && auxRule.getLaaOperator() == null)) {
			metricasValidas = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador para as métricas definidas para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else if (auxRule.getLocThreeshold() == -1 && auxRule.getAtfdThreeshold() == -1 && auxRule.getCycloThreeshold() == -1 && Double.compare(auxRule.getLaaThreeshold(), -1) == 0)
			metricasValidas = false;
		else
			metricasValidas = true;
		
		if(auxRule.getLocThreeshold() != -1 || auxRule.getCycloThreeshold() != -1)
			auxRule.setLongMethod(true);
		
		if(auxRule.getAtfdThreeshold() != -1 || auxRule.getLaaThreeshold() != -1)
			auxRule.setFeatureEnvy(true);
		
		Rule rule;
		
		if (longMethodValido && featureEnvyValido && metricasValidas) {

			definedRules = true;
			
			if(auxRule.isLongMethod()) {
				rule = new Rule();
				
				rule.setLongMethod(true);
				
				if(auxRule.getLocThreeshold() != -1) {
					rule.setLocThreeshold(auxRule.getLocThreeshold());
					rule.setLocOperator(auxRule.getLocOperator());
				}
				
				if(auxRule.getCycloThreeshold() != -1) {
					rule.setCycloThreeshold(auxRule.getCycloThreeshold());
					rule.setCycloOperator(auxRule.getCycloOperator());
				}
				
				if(auxRule.getLocThreeshold() != -1 && auxRule.getCycloThreeshold() != -1)
					rule.setLongMethodOperator(auxRule.getLongMethodOperator());		
				
				rule.addRuleToList(frame.getSavedRules());
				
				frame.setLastRuleDefined(rule);
				
				defineRules.setVisible(false);
			}
			
			
			if(auxRule.isFeatureEnvy()) {
				rule = new Rule();
				
				rule.setFeatureEnvy(true);
				
				if(auxRule.getAtfdThreeshold() != -1) {
					rule.setAtfdThreeshold(auxRule.getAtfdThreeshold());
					rule.setAtfdOperator(auxRule.getAtfdOperator());
				}
				
				if(!(Double.compare(auxRule.getLaaThreeshold(), -1) == 0)) {
					rule.setLaaThreeshold(auxRule.getLaaThreeshold());
					rule.setLaaOperator(auxRule.getLaaOperator());
				}
				
				if(auxRule.getAtfdThreeshold() != -1 && !(Double.compare(auxRule.getLaaThreeshold(), -1) == 0))
					rule.setFeatureEnvyOperator(auxRule.getFeatureEnvyOperator());		
		
				rule.addRuleToList(frame.getSavedRules());
				
				frame.setLastRuleDefined(rule);
				
				defineRules.setVisible(false);
			}

			frame.setChooseRule(new ChooseRule(frame));
		}
	}

	/**
	 * When a excel file is imported, is necessary to update methods with the right values of user's long method and user's feature envy.
	 *
	 * @param ruleLongMethod the user's long method rule
	 * @param ruleFeatureEnvy the user's feature envy rule
	 */
	public void updateMethods(Rule ruleLongMethod, Rule ruleFeatureEnvy) {

		if (frame.isExcelImported()) {

			for (Method method : frame.getMethods()) {
				
				if(!(ruleLongMethod.toString().equals(""))) {
					boolean longMethodUser = method.isLongMethodUser(ruleLongMethod.getLocThreeshold(), ruleLongMethod.getLocOperator(), ruleLongMethod.getCycloThreeshold(), ruleLongMethod.getCycloOperator(), ruleLongMethod.getLongMethodOperator());
					method.setLongMethodUserBoolean(longMethodUser);
				}
				
				if(!(ruleFeatureEnvy.toString().equals(""))) {
					boolean featureEnvyUser = method.isFeatureEnvyUser(ruleFeatureEnvy.getAtfdThreeshold(), ruleFeatureEnvy.getAtfdOperator(), ruleFeatureEnvy.getLaaThreeshold(), ruleFeatureEnvy.getLaaOperator(), ruleFeatureEnvy.getFeatureEnvyOperator());
					method.setFeatureEnvyUserBoolean(featureEnvyUser);
				}
			}

			frame.getMethodsJModel().clear();

			for (Method method : frame.getMethods()) {
				if (method.isLongMethodUserBoolean() || method.isFeatureEnvyUserBoolean()) {
					StringBuilder sb = new StringBuilder();
					
					sb.append("MethodID: " + method.getMethodID() + "; ");
					
					if(ruleLongMethod.isLongMethod())
						sb.append("Long Method: " + method.isLongMethodUserBoolean() + "; ");
					
					if(ruleFeatureEnvy.isFeatureEnvy())
						sb.append("Feature Envy: " + method.isFeatureEnvyUserBoolean() + "; ");
					
					frame.getMethodsJModel().addElement(sb.toString());
				}
			}
			
			frame.getMethodsJList().setModel(frame.getMethodsJModel());
		}
	}

	/**
	 * Reset rules in gui.
	 */
	public void resetRules() {

		text_loc.setText("LOC");
		text_cyclo.setText("CYCLO");
		text_atfd.setText("ATFD");
		text_laa.setText("LAA");

		locBox.setSelectedItem("-");
		cycloBox.setSelectedItem("-");
		atfdBox.setSelectedItem("-");
		laaBox.setSelectedItem("-");
		
		lmOperator.setSelectedItem("-");
		feOperator.setSelectedItem("-");
	}	
}