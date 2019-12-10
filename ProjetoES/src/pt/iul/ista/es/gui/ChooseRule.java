package pt.iul.ista.es.gui;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pt.iul.ista.es.applications.Rule;

public class ChooseRule {
	
	Frame frame;
	JDialog chooseRule;
	
	JComboBox<Rule> rules;
	
	JComboBox<Rule> rulesLongMethod;
	JComboBox<Rule> rulesFeatureEnvy;
	
	JButton chooseButton;
	
	private Rule selectedRule;
	
	private Rule selectedRuleLongMethod;
	private Rule selectedRuleFeatureEnvy;
	

	public ChooseRule(Frame frame) {
		chooseRule = new JDialog();
		this.frame = frame;
		
		addFrameContent();
		chooseRule.pack();
		chooseRule.setSize(500, 300);
		
	}
	
	public Rule getSelectedRule() {
		return selectedRule;
	}

	public void open() {
		chooseRule.setVisible(true);
	}
	
	private void addFrameContent() {
		
		List<Rule> rulesLongMethodList = new ArrayList<Rule>();
		List<Rule> rulesFeatureEnvyList = new ArrayList<Rule>();
		
		Rule r = new Rule();
		System.out.println("regra:" + r.toString());
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
								
				if( !(rulesLongMethod.getSelectedItem().toString().equals("")) ) {
					selectedRuleLongMethod = (Rule)rulesLongMethod.getSelectedItem();
					System.out.println("selecionada long method: " + selectedRuleLongMethod);
				}
				
				if( !(rulesFeatureEnvy.getSelectedItem().toString().equals("")) ) {
					selectedRuleFeatureEnvy = (Rule)rulesFeatureEnvy.getSelectedItem();
					System.out.println("selecionada feature envy: " + selectedRuleFeatureEnvy);
				}
				
			//		frame.getChangeRules().updateMethods((Rule)rules.getSelectedItem());
				
					//frame.updateRulesInGUI(selectedRule);
				
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
