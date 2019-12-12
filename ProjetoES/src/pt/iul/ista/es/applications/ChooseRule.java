package pt.iul.ista.es.applications;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.iul.ista.es.applications.Rule;

/**
 * The Class ChooseRule.
 * @author Joana Cavalheiro
 * @since 2019-11-14
 */
public class ChooseRule {

	/** The frame. */
	Frame frame;

	/** The choose rule. */
	JDialog chooseRule;

	/** The rules. */
	JComboBox<Rule> rules;

	/** The rules long method. */
	JComboBox<Rule> rulesLongMethod;

	/** The rules feature envy. */
	JComboBox<Rule> rulesFeatureEnvy;

	/** The choose button. */
	JButton chooseButton;

	/** The selected rule long method. */
	private Rule selectedRuleLongMethod;

	/** The selected rule feature envy. */
	private Rule selectedRuleFeatureEnvy;


	/**
	 * Instantiates a new choose rule.
	 *
	 * @param frame the frame
	 */
	public ChooseRule(Frame frame) {
		chooseRule = new JDialog();
		this.frame = frame;

		addFrameContent();
		chooseRule.pack();
		chooseRule.setSize(500, 300);

	}

	/**
	 * Gets the selected rule long method.
	 *
	 * @return the selected rule long method
	 */
	public Rule getSelectedRuleLongMethod() {
		return selectedRuleLongMethod;
	}

	/**
	 * Sets the selected rule long method.
	 *
	 * @param selected rule long method the new selected rule long method
	 */
	public void setSelectedRuleLongMethod(Rule selectedRuleLongMethod) {
		this.selectedRuleLongMethod = selectedRuleLongMethod;
	}

	/**
	 * Gets the selected rule feature envy.
	 *
	 * @return the selected rule feature envy
	 */
	public Rule getSelectedRuleFeatureEnvy() {
		return selectedRuleFeatureEnvy;
	}

	/**
	 * Sets the selected rule feature envy.
	 *
	 * @param selected rule feature envy the new selected rule feature envy
	 */
	public void setSelectedRuleFeatureEnvy(Rule selectedRuleFeatureEnvy) {
		this.selectedRuleFeatureEnvy = selectedRuleFeatureEnvy;
	}

	/**
	 * Open.
	 */
	public void open() {
		chooseRule.setVisible(true);
	}

	/**
	 * Adds the frame content.
	 */
	private void addFrameContent() {

		List<Rule> rulesLongMethodList = new ArrayList<Rule>();
		List<Rule> rulesFeatureEnvyList = new ArrayList<Rule>();

		Rule r = new Rule();
		//System.out.println("regra:" + r.toString());
		rulesLongMethodList.add(r);
		rulesFeatureEnvyList.add(r);

		if(frame.getSavedRules().size() != 0) {

			for (Rule rule : frame.getSavedRules()) {

				System.out.println(rule.isLongMethod() + " " + rule.isFeatureEnvy());

				if(rule.isLongMethod()) {
					System.out.println("adicionei long method");
					rulesLongMethodList.add(rule);
				}

				if(rule.isFeatureEnvy())
					rulesFeatureEnvyList.add(rule);
			}

			this.rulesLongMethod = new JComboBox(rulesLongMethodList.toArray());
			this.rulesFeatureEnvy = new JComboBox(rulesFeatureEnvyList.toArray());

		} else {
			this.rulesLongMethod = new JComboBox<Rule>();
			this.rulesFeatureEnvy = new JComboBox<Rule>();
		}

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1));

		chooseButton = new JButton("Escolher");

		chooseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//frame.resetRulesInGUI();

				if( !(rulesLongMethod.getSelectedItem().toString().equals("")) ) {
					selectedRuleLongMethod = (Rule)rulesLongMethod.getSelectedItem();
					System.out.println("selecionada long method: " + selectedRuleLongMethod);
				} else 
					selectedRuleLongMethod = new Rule();

				if( !(rulesFeatureEnvy.getSelectedItem().toString().equals("")) ) {
					selectedRuleFeatureEnvy = (Rule)rulesFeatureEnvy.getSelectedItem();
					System.out.println("selecionada feature envy: " + selectedRuleFeatureEnvy);
				} else
					selectedRuleFeatureEnvy = new Rule();

				frame.getChangeRules().updateMethods(selectedRuleLongMethod, selectedRuleFeatureEnvy);
				frame.updateRulesInGUI((Rule)rulesLongMethod.getSelectedItem(), (Rule)rulesFeatureEnvy.getSelectedItem());

				chooseRule.setVisible(false);
			}
		});

		panel.add(new JLabel("Escolha a regra que quer usar para analisar os erros: "));

		panel.add(new JLabel("Long Method: "));
		panel.add(this.rulesLongMethod);

		panel.add(new JLabel("Feature Envy: "));
		panel.add(this.rulesFeatureEnvy);

		panel.add(chooseButton);

		chooseRule.add(panel);

	}
}