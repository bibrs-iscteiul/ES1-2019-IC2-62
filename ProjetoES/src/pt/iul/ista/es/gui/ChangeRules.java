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
import pt.iul.ista.es.applications.Rule;

/**
 * The Class ChangeRules.
 * 
 * @author Gonçalo Almeida
 * @since 2019-11-10
 */
public class ChangeRules {

	/** The define rules. */
	JDialog defineRules;

	/** The frame. */
	Frame frame;

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
				frame.setChooseRule(new ChooseRule(frame));
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

		Rule rule = new Rule();

		if (text_loc.getText().matches("[0-9]+"))
			rule.setLocThreeshold(Integer.parseInt(text_loc.getText()));

		if (text_cyclo.getText().matches("[0-9]+"))
			rule.setCycloThreeshold(Integer.parseInt(text_cyclo.getText()));

		if (text_atfd.getText().matches("[0-9]+"))
			rule.setAtfdThreeshold(Integer.parseInt(text_atfd.getText()));

		if (text_laa.getText().matches("[0-9]+"))
			rule.setLaaThreeshold(Integer.parseInt(text_laa.getText()));

		if (!(lmOperator.getSelectedItem().toString() == "null") || !(lmOperator.getSelectedItem().toString() == "-"))
			rule.setLongMethodOperator(lmOperator.getSelectedItem().toString());

		if (!(feOperator.getSelectedItem().toString() == "null") || !(feOperator.getSelectedItem().toString() == "-"))
			rule.setFeatureEnvyOperator(feOperator.getSelectedItem().toString());

		if (!(locBox.getSelectedItem().toString() == "-"))
			rule.setLocOperator(locBox.getSelectedItem().toString());

		if (!(cycloBox.getSelectedItem().toString() == "-"))
			rule.setCycloOperator(cycloBox.getSelectedItem().toString());

		if (!(laaBox.getSelectedItem().toString() == "-"))
			rule.setLaaOperator(laaBox.getSelectedItem().toString());

		if (!(atfdBox.getSelectedItem().toString() == "-"))
			rule.setAtfdOperator(atfdBox.getSelectedItem().toString());

		boolean longMethodValido;
		boolean featureEnvyValido;
		boolean metricasValidas;

		if (rule.getLocThreeshold() != -1 && rule.getCycloThreeshold() != -1 && (rule.getLongMethodOperator().equals("null") || rule.getLongMethodOperator().equals("-"))) {
			longMethodValido = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Long Method para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else
			longMethodValido = true;

		if (rule.getAtfdThreeshold() != -1 && rule.getLaaThreeshold() != -1 && (rule.getFeatureEnvyOperator().equals("null") || rule.getFeatureEnvyOperator().equals("-"))) {
			featureEnvyValido = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador do Feature Envy para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else
			featureEnvyValido = true;

		if ((rule.getLocThreeshold() != -1 && rule.getLocOperator() == null) || (rule.getCycloThreeshold() != -1 && rule.getCycloOperator() == null) || (rule.getAtfdThreeshold() != -1 && rule.getAtfdOperator() == null) || (rule.getLaaThreeshold() != -1 && rule.getLaaOperator() == null)) {
			metricasValidas = false;
			JOptionPane.showMessageDialog(defineRules, "É necessário que introduza um operador para as métricas definidas para continuar.", "Error!", JOptionPane.ERROR_MESSAGE);
		} else
			metricasValidas = true;

		if (longMethodValido && featureEnvyValido && metricasValidas) {

			definedRules = true;

			System.out.println("adicionar: " + rule.toString());
			rule.addRuleToList(frame.getSavedRules());
			System.out.println(frame.getSavedRules().size());

			frame.updateRulesInGUI();

			if (frame.isExcelImportado()) {

				for (Method method : frame.getMethods()) {

					boolean longMethodUser = method.isLongMethodUser(rule.getLocThreeshold(), rule.getLocOperator(), rule.getCycloThreeshold(), rule.getCycloOperator(), rule.getLongMethodOperator());
					method.setLongMethodUserBoolean(longMethodUser);

					boolean featureEnvyUser = method.isFeatureEnvyUser(rule.getAtfdThreeshold(), rule.getAtfdOperator(), rule.getAtfdThreeshold(), rule.getAtfdOperator(), rule.getFeatureEnvyOperator());
					method.setFeatureEnvyUserBoolean(featureEnvyUser);
				}

				frame.getMethodsJModel().clear();

				for (Method method : frame.getMethods())
					if (method.isLongMethodUserBoolean() || method.isFeatureEnvyUserBoolean())
						frame.getMethodsJModel().addElement("MethodID: " + method.getMethodID() + "; Long Method: " + method.isLongMethodUserBoolean() + "; Feature Envy: " + method.isFeatureEnvyUserBoolean());

				frame.getMethodsJList().setModel(frame.getMethodsJModel());
			}

			//frame.setChooseRule(new ChooseRule(frame));
			defineRules.setVisible(false);
		}
	}
	/*
	 * public void resetRules() {
	 * 
	 * locThreeshold = -1; cycloThreeshold = -1; atfdThreeshold = -1; laaThreeshold
	 * = -1;
	 * 
	 * locOperator = null; cycloOperator = null; atfdOperator = null; laaOperator =
	 * null;
	 * 
	 * longMethodOperator = null; featureEnvyOperator = null;
	 * 
	 * }
	 */
}
