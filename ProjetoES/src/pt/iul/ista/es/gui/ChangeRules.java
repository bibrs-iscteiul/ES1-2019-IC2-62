package pt.iul.ista.es.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.iul.ista.es.applications.Method;

public class ChangeRules {
	
	JDialog defineRules = new JDialog();
	/*
	private int intThresholdLoc;
	private int intThresholdCyclo;
	private int intThresholdAtfd;
	private int intThresholdLaa;
	*/
	Frame frame;
	
	public ChangeRules(Frame frame) {
		defineRules = new JDialog();
//		defineRules.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		addFrameContent();
		defineRules.pack();
		defineRules.setSize(700, 300);
		
		this.frame = frame;
	}
	
	public void open() {
		defineRules.setVisible(true);
		
	}
	private void addFrameContent() {
		
		JLabel loc = new JLabel();
		loc.setText("Valor do LOC: ");
		JTextField text_loc = new JTextField("LOC");
		JCheckBox check_loc = new JCheckBox("Maior");

		JLabel cyclo = new JLabel();
		cyclo.setText("Valor do CYCLO: ");
		JTextField text_cyclo = new JTextField("CYCLO");
		JCheckBox check_cyclo = new JCheckBox("Maior");

		JLabel atfd = new JLabel();
		atfd.setText("Valor do ATFD: ");
		JTextField text_atfd = new JTextField("ATDF");
		JCheckBox check_atfd = new JCheckBox("Maior");

		JLabel laa = new JLabel();
		laa.setText("Valor do LAA: ");
		JTextField text_laa = new JTextField("LAA");
		JCheckBox check_laa = new JCheckBox("Maior");
		
		JButton definir = new JButton("Definir");
		
		
		definir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int valor;
				List<Method> aux1 = null;
				List<Method> aux2 = null;
				boolean usado = false;
				boolean usado_lm = false;
				boolean usado_fe = false;

				if (text_loc.getText().matches("[0-9]+")) {
					valor = Integer.parseInt(text_loc.getText());

					if (check_loc.isSelected())
						frame.getErrorDet().thresholds_Loc(valor, true);
					else
						frame.getErrorDet().thresholds_Loc(valor, false);

					usado = true;
				}

				if (text_cyclo.getText().matches("[0-9]+")) {
					valor = Integer.parseInt(text_cyclo.getText());

					if (check_cyclo.isSelected()) {
						if (usado == false)
							frame.getErrorDet().thresholds_Cyclo(valor, true);

						else {
							aux1 = frame.getErrorDet().segundoCriterio(true);
							frame.getErrorDet().thresholds_Cyclo(valor, true);
							usado_lm = true;
						}

					} else {
						if (usado == false)
							frame.getErrorDet().thresholds_Cyclo(valor, false);

						else {
							aux1 = frame.getErrorDet().segundoCriterio(true);
							frame.getErrorDet().thresholds_Cyclo(valor, false);
							usado_lm = true;
						}
					}
				}

				usado = false;
				if (text_atfd.getText().matches("[0-9]+")) {
					valor = Integer.parseInt(text_atfd.getText());

					if (check_atfd.isSelected())
						frame.getErrorDet().thresholds_Atfd(valor, true);
					else
						frame.getErrorDet().thresholds_Atfd(valor, false);

					usado = true;
				}

				if (text_laa.getText().matches("[0-9]+")) {
					double d = Double.parseDouble(text_laa.getText());
					valor = (int) d;

					if (check_cyclo.isSelected()) {
						if (!usado)
							frame.getErrorDet().thresholds_Laa(valor, true);

						else {
							aux2 = frame.getErrorDet().segundoCriterio(false);
							frame.getErrorDet().thresholds_Laa(valor, true);
							usado_fe = true;
						}

					} else {
						if (!usado)
							frame.getErrorDet().thresholds_Laa(valor, false);

						else {
							aux2 = frame.getErrorDet().segundoCriterio(false);
							frame.getErrorDet().thresholds_Laa(valor, false);
							usado_fe = true;
						}
					}
				}

				for (Method m : frame.getMethods()) {

					if (usado_lm) {
						for (Method a1 : aux1)
							if (m.getMethodID() == a1.getMethodID()) {

								if (m.isIs_long_method_user() == true && a1.isIs_long_method_user() == true)
									m.setIs_long_method_user(true);
								else
									m.setIs_long_method_user(false);
							}
					}

					if (usado_fe) {
						for (Method a2 : aux2)
							if (m.getMethodID() == a2.getMethodID()) {

								if (m.isIs_feature_envy_user() == true && a2.isIs_feature_envy_user() == true)
									m.setIs_feature_envy_user(true);
								else
									m.setIs_feature_envy_user(false);
							}
					}
				}

				for (Method method : frame.getMethods())
					frame.getMethodsJModel().addElement(method);
				frame.getMethodsJList().setModel(frame.getMethodsJModel());

				defineRules.setVisible(false);
			}
		});

		
		JPanel dr = new JPanel();
		dr.setLayout(new GridLayout(5, 1));

		JPanel ploc = new JPanel();
		ploc.setLayout(new GridLayout(0, 3));
		ploc.add(loc);
		ploc.add(text_loc);
		ploc.add(check_loc);
		dr.add(ploc);

		JPanel pcyclo = new JPanel();
		pcyclo.setLayout(new GridLayout(0, 3));
		pcyclo.add(cyclo);
		pcyclo.add(text_cyclo);
		pcyclo.add(check_cyclo);
		dr.add(pcyclo);

		JPanel patfd = new JPanel();
		patfd.setLayout(new GridLayout(0, 3));
		patfd.add(atfd);
		patfd.add(text_atfd);
		patfd.add(check_atfd);
		dr.add(patfd);

		JPanel plaa = new JPanel();
		plaa.setLayout(new GridLayout(0, 3));
		plaa.add(laa);
		plaa.add(text_laa);
		plaa.add(check_laa);
		dr.add(plaa);

		dr.add(definir, BorderLayout.SOUTH);
		defineRules.add(dr);
	}
	
}
