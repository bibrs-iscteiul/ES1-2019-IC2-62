package pt.iul.ista.es.gui;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton chooseButton;
	
	private Rule selectedRule;

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
		
		if(frame.getSavedRules().size() != 0)
			rules = new JComboBox(frame.getSavedRules().toArray());
		else
			rules = new JComboBox<Rule>();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		
		chooseButton = new JButton("Escolher");
		
		chooseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				if(rules.getSelectedItem() == null)
					System.out.println("nada selecionado");
				
				else {
					System.out.println("selecionada " + rules.getSelectedItem().toString());
					frame.getChangeRules().updateMethods((Rule)rules.getSelectedItem());
					selectedRule = (Rule)rules.getSelectedItem();
				
					//frame.resetRulesInGUI();
					frame.updateRulesInGUI(selectedRule);
				}
				
				chooseRule.setVisible(false);
			}
		});
		
		panel.add(new JLabel("Escolha a regra que quer usar para analisar os erros: "));
		panel.add(rules);
		panel.add(chooseButton);
		
		chooseRule.add(panel);
		
	}
}
