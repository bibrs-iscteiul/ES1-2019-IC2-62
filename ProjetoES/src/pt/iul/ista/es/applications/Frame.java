package pt.iul.ista.es.applications;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import pt.iul.ista.es.applications.Method;
import pt.iul.ista.es.applications.ReadFromFile;
import pt.iul.ista.es.applications.Rule;

/**
 * The Class Frame.
 * @author Beatriz Ragageles e Bernardo Gameiro
 * @since 2019-11-03
 */
public class Frame {

	/** The frame. */
	private JFrame frame;

	/** The lm log. */
	private JLabel lmLog;
	
	/** The fe log. */
	private JLabel feLog;
	
	/** The rules. */
	JComboBox<Rule> rules;

	/** The excel importado. */
	private boolean excelImportado;

	/** The t loc. */
	private JLabel tLoc;

	/** The t cyclo. */
	private JLabel tCyclo;

	/** The t atfd. */
	private JLabel tAtfd;

	/** The t laa. */
	private JLabel tLaa;

	/** The file excel. */
	private File fileExcel;

	/** The read file. */
	private ReadFromFile readFile;

	/** The methods. */
	private List<Method> methods;

	/** The methods J list. */
	private JList<String> methodsJList;

	/** The methods J model. */
	private DefaultListModel<String> methodsJModel;

	/** The change rules. */
	private ChangeRules changeRules;
	
	/** The choose rule. */
	private ChooseRule chooseRule;

	/** The saved rules. */
	private List<Rule> savedRules;

	/** The last rule defined. */
	private Rule lastRuleDefined;

	/** The dci. */
	private int dci=0;
	
	/** The adci. */
	private int adci=0;
	
	/** The adii. */
	private int adii=0;
	
	/** The dii. */
	private int dii=0;
	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Sets the frame.
	 *
	 * @param frame the new frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Gets the lm log.
	 *
	 * @return the lm log
	 */
	public JLabel getLmLog() {
		return lmLog;
	}

	/**
	 * Sets the lm log.
	 *
	 * @param lmLog the new lm log
	 */
	public void setLmLog(JLabel lmLog) {
		this.lmLog = lmLog;
	}

	/**
	 * Gets the fe log.
	 *
	 * @return the fe log
	 */
	public JLabel getFeLog() {
		return feLog;
	}

	/**
	 * Sets the fe log.
	 *
	 * @param feLog the new fe log
	 */
	public void setFeLog(JLabel feLog) {
		this.feLog = feLog;
	}

	/**
	 * Gets the rules.
	 *
	 * @return the rules
	 */
	public JComboBox<Rule> getRules() {
		return rules;
	}

	/**
	 * Sets the rules.
	 *
	 * @param rules the new rules
	 */
	public void setRules(JComboBox<Rule> rules) {
		this.rules = rules;
	}
	
	/**
	 * Checks if is excel imported.
	 *
	 * @return true, if is excel imported
	 */
	public boolean isExcelImported() {
		return excelImportado;
	}

	/**
	 * Sets the excel imported.
	 *
	 * @param excelImportado the new excel imported
	 */
	public void setExcelImported(boolean excelImportado) {
		this.excelImportado = excelImportado;
	}
	
	/**
	 * Gets the read file.
	 *
	 * @return the read file
	 */
	public ReadFromFile getReadFile() {
		return readFile;
	}

	/**
	 * Sets the read file.
	 *
	 * @param readFile the new read file
	 */
	public void setReadFile(ReadFromFile readFile) {
		this.readFile = readFile;
	}

	/**
	 * Gets the methods.
	 *
	 * @return the methods
	 */
	public List<Method> getMethods() {
		return methods;
	}

	/**
	 * Gets the methods J list.
	 *
	 * @return the methods J list
	 */
	public JList<String> getMethodsJList() {
		return methodsJList;
	}

	/**
	 * Gets the methods J model.
	 *
	 * @return the methods J model
	 */
	public DefaultListModel<String> getMethodsJModel() {
		return methodsJModel;
	}

	/**
	 * Gets the change rules.
	 *
	 * @return the change rules
	 */
	public ChangeRules getChangeRules() {
		return changeRules;
	}

	/**
	 * Gets the choose rule.
	 *
	 * @return the choose rule
	 */
	public ChooseRule getChooseRule() {
		return chooseRule;
	}

	/**
	 * Sets the choose rule.
	 *
	 * @param chooseRule the new choose rule
	 */
	public void setChooseRule(ChooseRule chooseRule) {
		this.chooseRule = chooseRule;
	}
	
	/**
	 * Gets the saved rules.
	 *
	 * @return the saved rules
	 */
	public List<Rule> getSavedRules() {
		return savedRules;
	}

	/**
	 * Sets the saved rules.
	 *
	 * @param savedRules the new saved rules
	 */
	public void setSavedRules(List<Rule> savedRules) {
		this.savedRules = savedRules;
	}

	/**
	 * Gets the last rule defined.
	 *
	 * @return the last rule defined
	 */
	public Rule getLastRuleDefined() {
		return lastRuleDefined;
	}

	/**
	 * Sets the last rule defined.
	 *
	 * @param lastRuleDefined the new last rule defined
	 */
	public void setLastRuleDefined(Rule lastRuleDefined) {
		this.lastRuleDefined = lastRuleDefined;
	}

	/**
	 * Gets the dci.
	 *
	 * @return the dci
	 */
	public int getDci() {
		return dci;
	}

	/**
	 * Sets the dci.
	 *
	 * @param dci the new dci
	 */
	public void setDci(int dci) {
		this.dci = dci;
	}

	/**
	 * Gets the adci.
	 *
	 * @return the adci
	 */
	public int getAdci() {
		return adci;
	}

	/**
	 * Sets the adci.
	 *
	 * @param adci the new adci
	 */
	public void setAdci(int adci) {
		this.adci = adci;
	}

	/**
	 * Gets the adii.
	 *
	 * @return the adii
	 */
	public int getAdii() {
		return adii;
	}

	/**
	 * Sets the adii.
	 *
	 * @param adii the new adii
	 */
	public void setAdii(int adii) {
		this.adii = adii;
	}

	/**
	 * Gets the dii.
	 *
	 * @return the dii
	 */
	public int getDii() {
		return dii;
	}

	/**
	 * Sets the dii.
	 *
	 * @param dii the new dii
	 */
	public void setDii(int dii) {
		this.dii = dii;
	}

	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		frame = new JFrame("Deteta Defeitos");
		
		this.tLoc = new JLabel();
		this.tCyclo = new JLabel();
		this.tAtfd = new JLabel();
		this.tLaa = new JLabel();
		
		this.lmLog = new JLabel();
		this.feLog = new JLabel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		frame.setSize(1500, 700);
		frame.setVisible(true);

		
		
		this.savedRules = new ArrayList<Rule>();

		this.changeRules = new ChangeRules(this);
		this.chooseRule = new ChooseRule(this);

	}

	/**
	 * Open.
	 */
	public void open() {
		frame.setVisible(true);
	}

	/**
	 * Adds the frame content to the gui.
	 */
	private void addFrameContent() {

		// JLists
		methodsJList = new JList();
		this.methodsJModel = new DefaultListModel();
		JScrollPane scroll = new JScrollPane(methodsJList);

		// JTextFields
		JPanel painel = new JPanel(); 
		painel.setLayout(new BorderLayout());
		JTextField thresholds1 = new JTextField("");
		JTextField thresholds2 = new JTextField("");
		JDialog dialog = new JDialog(); // janela

		JPanel painelThresholds = new JPanel();
		painelThresholds.setLayout(new GridLayout(0, 1));

		JLabel label = new JLabel("Valores Thresholds:");
		resetRulesInGUI();

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(3, 1));

		// JButtons
		JButton compararFeatureEnvy = new JButton("Comparar Feature Envy");
		JButton compararLongMethod = new JButton("Comparar Long Method");
		JButton escolherFicheiro = new JButton("Excel");
		JButton definirRegras = new JButton("Definir Regras"); 
		JButton escolherRegra = new JButton("Escolher Regra");

		escolherFicheiro.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {

				excelImportado = false;

				methodsJModel.clear();
				methodsJList.clearSelection();

				JFileChooser excel = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				excel.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue1 = excel.showOpenDialog(null); // linha default

				if (excel.getSelectedFile().toString().endsWith(".xlsx")) { // se ficheiro escolhido é excel
					fileExcel = excel.getSelectedFile();

					readFile = new ReadFromFile();

					try {
						methods = readFile.read(fileExcel.getName(), 0);

						for (Method method : methods) 
							methodsJModel.addElement(method.toString());

						methodsJList.setModel(methodsJModel);

						excelImportado = true;

						if(changeRules.isDefinedRules() && lastRuleDefined != savedRules.get(savedRules.size()-1))
							changeRules.saveRules();

						if(chooseRule.getSelectedRuleLongMethod() != null || chooseRule.getSelectedRuleFeatureEnvy() != null)
							changeRules.updateMethods(chooseRule.getSelectedRuleLongMethod(), chooseRule.getSelectedRuleFeatureEnvy()); 

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(frame,"Ficheiro não suportado", "Erro!", JOptionPane.ERROR_MESSAGE);				
			}
		});


		definirRegras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeRules.resetRules();
				changeRules.open();
			}
		});

		compararLongMethod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dci = 0;
				dii = 0;
				adci = 0;
				adii = 0;

				JFrame f = new JFrame();

				JPanel jpanel = new JPanel();
				jpanel.setLayout(new GridLayout(4,1));


				String[] nStrings = { "PMD", "iPlasma", "Regra Escolhida" }; 

				rules = new JComboBox(nStrings);


				JButton x = new JButton("Comparar");


				rules.setBounds(75,100,100,30);
				x.setBounds(75,200,100,30);

				f.add(rules);
				f.add(x);
				f.setSize(300,300);    
				f.setLayout(null);    
				f.setVisible(true);

				x.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						f.setVisible(false);

						for(Method i: methods) {
							if(rules.getSelectedItem().equals("PMD")) {
								compare(i.isPmd(), i.isIs_long_method());
							}
							if (rules.getSelectedItem().equals("iPlasma")){
								compare(i.isIplasma(), i.isIs_long_method());
							}

							if(rules.getSelectedItem().equals("Regra Escolhida")) {
								compare(i.isLongMethodUserBoolean(), i.isIs_long_method());
							}

						}
						JOptionPane.showMessageDialog(frame, "DCI: " +  dci + "\n" + "DII: " + dii + "\n" + "ADCI: " + adci + "\n" + "ADII: " + adii);
					}
				});
			}
		});


		compararFeatureEnvy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dci = 0;
				dii = 0;
				adci = 0;
				adii = 0;

				for(Method i: methods) {
					compare(i.isFeatureEnvyUserBoolean(), i.isIs_feature_envy());
				}

				JOptionPane.showMessageDialog(frame, "DCI: " +  dci + "\n" + "DII: " + dii + "\n" + "ADCI: " + adci + "\n" + "ADII: " + adii);

			}

		});


		escolherRegra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resetRulesInGUI();
				
				if(savedRules.size() != 0) 
					chooseRule.open();
				
				else
					JOptionPane.showMessageDialog(frame,"Não existem regras guardadas, terá de criar primeiro.", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});


		// Painel com JButtons e JTextFields

		// Dialog
		painel.add(new JLabel("Valores de Thresholds"), BorderLayout.NORTH);
		JPanel painelTextField = new JPanel();
		painelTextField.setLayout(new GridLayout(2, 1));
		painelTextField.add(thresholds1);
		painelTextField.add(thresholds2);
		painel.add(painelTextField, BorderLayout.NORTH);
		dialog.add(painel);

		// South.East (valores thresholds)
		painelThresholds.add(label);
		painelThresholds.add(tLoc, BorderLayout.NORTH);
		painelThresholds.add(tCyclo, BorderLayout.CENTER);
		painelThresholds.add(tAtfd, BorderLayout.CENTER);
		painelThresholds.add(tLaa, BorderLayout.SOUTH);
		painelThresholds.add(lmLog, BorderLayout.SOUTH);
		painelThresholds.add(feLog, BorderLayout.SOUTH);

		// South.West (restantes botoes)

		painelBotoes.add(definirRegras);
		painelBotoes.add(escolherRegra);
		painelBotoes.add(compararLongMethod);
		painelBotoes.add(compararFeatureEnvy);
		painelBotoes.add(escolherFicheiro);



		// painel South
		JPanel painelSouth = new JPanel();
		painelSouth.setLayout(new GridLayout(1, 2));
		painelSouth.add(painelBotoes, BorderLayout.WEST);
		painelSouth.add(painelThresholds, BorderLayout.EAST);

		// painel principal
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(2, 1));
		painelPrincipal.add(scroll);
		painelPrincipal.add(painelSouth);

		frame.add(painelPrincipal);
	}

	/**
	 * Update rules in GUI.
	 *
	 * @param ruleLongMethod the rule long method
	 * @param ruleFeatureEnvy the rule feature envy
	 */
	public void updateRulesInGUI(Rule ruleLongMethod, Rule ruleFeatureEnvy) {

		if(!(ruleLongMethod.toString().equals(""))) {
			if(!(ruleLongMethod.getLocThreeshold() == -1) && !(ruleLongMethod.getLocOperator().equals("-")))
				tLoc.setText("LOC: " + ruleLongMethod.getLocOperator() + " que " + ruleLongMethod.getLocThreeshold());
	
			if(!(ruleLongMethod.getCycloThreeshold() == -1) && !(ruleLongMethod.getCycloOperator().equals("-")))
				tCyclo.setText("CYCLO: " + ruleLongMethod.getCycloOperator() + " que " + ruleLongMethod.getCycloThreeshold());
			
			if(!(ruleLongMethod.getLongMethodOperator().toString().equals("")))
				lmLog.setText("Operaçăo Lógica do Long Method do Utilizador: " + ruleLongMethod.getLongMethodOperator());
		}
		
		if(!(ruleFeatureEnvy.toString().equals(""))) {
			if(!(ruleFeatureEnvy.getAtfdThreeshold() == -1) && !(ruleFeatureEnvy.getAtfdOperator().equals("-")))
				tAtfd.setText("ATFD: " + ruleFeatureEnvy.getAtfdOperator() + " que " + ruleFeatureEnvy.getAtfdThreeshold());
	
			if(!(ruleFeatureEnvy.getLaaThreeshold() == -1) && !(ruleFeatureEnvy.getLaaOperator().equals("-")))
				tLaa.setText("LAA: " + ruleFeatureEnvy.getLaaOperator() + " que " + ruleFeatureEnvy.getLaaThreeshold());
	
			if(!(ruleFeatureEnvy.getFeatureEnvyOperator().toString().equals("")))
				feLog.setText("Operaçăo Lógica do Feature Envy do Utilizador: " + ruleFeatureEnvy.getFeatureEnvyOperator());
		}
	}

	/**
	 * Reset rules in GUI.
	 */
	public void resetRulesInGUI()  {
		
		tLoc.setText("LOC: ");
		tCyclo.setText("CYCLO: ");
		tAtfd.setText("ATFD: ");
		tLaa.setText("LAA: " );
		lmLog.setText("Operaçăo Lógica do Long Method do Utilizador: ");
		feLog.setText("Operaçăo Lógica do Feature Envy do Utilizador: ");
	}

	/**
	 * Compare two booleans to know what type of error.
	 *
	 * @param a the a
	 * @param b the b
	 */
	public void compare(boolean a, boolean b){ 

		if(a == true && b == true){
			dci++;
		}
		if(a == true && b == false){
			dii++;
		}
		if(a == false && b == false){
			adci++;
		}
		if(a == false && b == true){
			adii++;
		}
	}

	/**
	 * The main method to open the gui.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		Frame window = new Frame();
		window.open();
	}
}