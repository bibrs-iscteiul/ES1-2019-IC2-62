package pt.iul.ista.es.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * The Class ChangeRules.
 * @author Gonçalo Almeida
 * @since 2019-11-10
 */
public class ChangeRules {

	/** The define rules. */
	JDialog defineRules = new JDialog();

	/** The threshold loc. */
	int thresholdLoc;

	/** The threshold cyclo. */
	int thresholdCyclo;

	/** The threshold atfd. */
	int thresholdAtfd;

	/** The threshold laa. */
	double thresholdLaa;

	/** The frame. */
	Frame frame;

	
	boolean usado_lm = false;
	boolean usado_fe = false;

	public boolean isUsado_lm() {
		return usado_lm;
	}

	public void setUsado_lm(boolean usado_lm) {
		this.usado_lm = usado_lm;
	}

	public boolean isUsado_fe() {
		return usado_fe;
	}

	public void setUsado_fe(boolean usado_fe) {
		this.usado_fe = usado_fe;
	}


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

		this.thresholdLoc = frame.getThresholdLoc();
		this.thresholdCyclo = frame.getThresholdCyclo();
		this.thresholdAtfd = frame.getThresholdAtfd();
		this.thresholdLaa = frame.getThresholdLaa();

		this.frame = frame;
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

		String[] mmi = {" - ", "maior", "menor", "igual"};

		JLabel loc = new JLabel();
		loc.setText("Valor do LOC: ");
		JTextField text_loc = new JTextField("LOC");
		JComboBox<String> locBox = new JComboBox(mmi);

		JLabel cyclo = new JLabel();
		cyclo.setText("Valor do CYCLO: ");
		JTextField text_cyclo = new JTextField("CYCLO");
		JComboBox<String> cycloBox = new JComboBox(mmi);

		JLabel atfd = new JLabel();
		atfd.setText("Valor do ATFD: ");
		JTextField text_atfd = new JTextField("ATDF");
		JComboBox<String> atfdBox = new JComboBox(mmi);

		JLabel laa = new JLabel();
		laa.setText("Valor do LAA: ");
		JTextField text_laa = new JTextField("LAA");
		JComboBox<String> laaBox = new JComboBox(mmi);


		String[] op = {" - ", "or", "and"};
		JLabel lm_op = new JLabel("long_method operation: ");
		JComboBox<String> lm_box = new JComboBox(op);
		JLabel fe_op = new JLabel("feature_envy operation: ");
		JComboBox<String> fe_box = new JComboBox(op);

		JButton definir = new JButton("Definir");

		definir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (text_loc.getText().matches("[0-9]+")) {
					thresholdLoc = Integer.parseInt(text_loc.getText());
					frame.setThresholdLoc(thresholdLoc);

					String sloc = (String) locBox.getSelectedItem();
					frame.setSloc(sloc);

					frame.getErrorDet().setLongM(true);
				}

				if (text_cyclo.getText().matches("[0-9]+")) {
					thresholdCyclo = Integer.parseInt(text_cyclo.getText());
					frame.setThresholdCyclo(thresholdCyclo);

					String scyclo = (String) cycloBox.getSelectedItem();
					frame.setScyclo(scyclo);

					usado_lm = true;
				}


				if (text_atfd.getText().matches("[0-9]+")) {
					thresholdAtfd = Integer.parseInt(text_atfd.getText());
					frame.setThresholdAtfd(thresholdAtfd);

					String satfd = (String) atfdBox.getSelectedItem();
					frame.setSatfd(satfd);

					frame.getErrorDet().setFeatureE(true);
				}

				if (text_laa.getText().matches("[0-9]+")) {
					thresholdLaa = Double.parseDouble(text_laa.getText());
					frame.setThresholdLaa(thresholdLaa);

					String slaa = (String) laaBox.getSelectedItem();
					frame.setSlaa(slaa);
					
					usado_fe = true;
				}
				
				if(usado_lm) {
					String s = (String) lm_box.getSelectedItem();
					frame.getErrorDet().setLm_box(s);
				}
				
				if(usado_fe) {
					String s = (String) fe_box.getSelectedItem();
					frame.getErrorDet().setFe_box(s);
				}

				frame.thresholdUpdate();
				defineRules.setVisible(false);
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

		dr.add(lm_op);
		dr.add(lm_box);
		dr.add(fe_op);
		dr.add(fe_box);

		dr.add(definir, BorderLayout.SOUTH);
		defineRules.add(dr);
	}

}
