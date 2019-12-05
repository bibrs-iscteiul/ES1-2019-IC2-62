package pt.iul.ista.es.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.iul.ista.es.applications.Rule;

public class ChooseRule {
	
	Frame frame;
	JDialog chooseRule;
	
	JComboBox<Rule> rules;
	JButton chooseButton;

	public ChooseRule(Frame frame) {
		chooseRule = new JDialog();
		this.frame = frame;
		
		addFrameContent();
		chooseRule.pack();
		chooseRule.setSize(500, 300);
		
		
	}
	
	public void open() {
		chooseRule.setVisible(true);
	}
	
	private void addFrameContent() {
		
		System.out.println("tamanho array: " + frame.getSavedRules().toArray().length);
		rules = new JComboBox(frame.getSavedRules().toArray());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		
		chooseButton = new JButton("Escolher");
		
		chooseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		panel.add(new JLabel("Escolha a regra que quer usar para analisar os erros: "));
		panel.add(rules);
		panel.add(chooseButton);
		
		chooseRule.add(panel);
		
	}
/*
	public static void main(String[] args) {
		ChooseRule cr = new ChooseRule(new Frame());
		
		cr.open();
	} */
}
