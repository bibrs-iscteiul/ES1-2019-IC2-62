package pt.iul.ista.es.gui;

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
import javax.swing.JRadioButton;
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

	private JLabel lmLog;
	private JLabel feLog;
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
	private ChooseRule chooseRule;

	private List<Rule> savedRules;

	private Rule lastRuleDefined;

	private int dci=0;
	private int adci=0;
	private int adii=0;
	private int dii=0;


	public ChooseRule getChooseRule() {
		return chooseRule;
	}

	public void setChooseRule(ChooseRule chooseRule) {
		this.chooseRule = chooseRule;
	}

	public boolean isExcelImportado() {
		return excelImportado;
	}

	public void setExcelImportado(boolean excelImportado) {
		this.excelImportado = excelImportado;
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

	public ChangeRules getChangeRules() {
		return changeRules;
	}

	public List<Rule> getSavedRules() {
		return savedRules;
	}

	public void setSavedRules(List<Rule> savedRules) {
		this.savedRules = savedRules;
	}

	public Rule getLastRuleDefined() {
		return lastRuleDefined;
	}

	public void setLastRuleDefined(Rule lastRuleDefined) {
		this.lastRuleDefined = lastRuleDefined;
	}



	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		frame = new JFrame("Deteta Defeitos");
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
	 * Adds the frame content.
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

		escolherFicheiro.addActionListener(new ActionListener() { // adiciona acao ao botao

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

						if(changeRules.isDefinedRules() && lastRuleDefined != savedRules.get(savedRules.size()-1)) {
							changeRules.saveRules();
						}

						if(chooseRule.getSelectedRule() != null)
							changeRules.updateMethods(chooseRule.getSelectedRule());


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


				String[] nStrings = { "Ipmd", "Iplasma", "Regra Escolhida" }; 

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
							if(rules.getSelectedItem().equals("Ipmd")) {
								compare(i.isPmd(), i.isIs_long_method());
							}
							if (rules.getSelectedItem().equals("Iplasma")){
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

		compararFeatureEnvy.addActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dci = 0;
				dii = 0;
				adci = 0;
				adii = 0;

				JFrame f = new JFrame();

				JPanel jpanel = new JPanel();
				jpanel.setLayout(new GridLayout(4,1));

				String[] nStrings = { "Regra Escolhida" }; 

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

							if(rules.getSelectedItem().equals("Regra Escolhida")) {
								compare(i.isFeatureEnvyUserBoolean(), i.isIs_feature_envy()); 
							}
							
						}

						JOptionPane.showMessageDialog(frame, "DCI: " +  dci + "\n" + "DII: " + dii + "\n" + "ADCI: " + adci + "\n" + "ADII: " + adii);
					}
				});
			}
		});

		JButton escolherRegra = new JButton("Escolher Regra");
		escolherRegra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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

		// South.West (valores thresholds)
		painelThresholds.add(label);
		painelThresholds.add(tLoc, BorderLayout.NORTH);
		painelThresholds.add(tCyclo, BorderLayout.CENTER);
		painelThresholds.add(tAtfd, BorderLayout.CENTER);
		painelThresholds.add(tLaa, BorderLayout.SOUTH);
		painelThresholds.add(lmLog, BorderLayout.SOUTH);
		painelThresholds.add(feLog, BorderLayout.SOUTH);

		// South.East (restantes botoes)
		painelBotoes.add(escolherFicheiro);
		painelBotoes.add(definirRegras);
		painelBotoes.add(compararLongMethod);
		painelBotoes.add(compararFeatureEnvy);
		painelBotoes.add(escolherRegra);


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

	public void updateRulesInGUI(Rule rule) {

		if(!(rule.getLocThreeshold() == -1) && !(rule.getLocOperator().equals("-")))
			tLoc.setText("LOC: " + rule.getLocOperator() + " que " + rule.getLocThreeshold());

		if(!(rule.getCycloThreeshold() == -1) && !(rule.getCycloOperator().equals("-")))
			tCyclo.setText("CYCLO: " + rule.getCycloOperator() + " que " + rule.getCycloThreeshold());

		if(!(rule.getAtfdThreeshold() == -1) && !(rule.getAtfdOperator().equals("-")))
			tAtfd.setText("ATFD: " + rule.getAtfdOperator() + " que " + rule.getAtfdThreeshold());

		if(!(rule.getLaaThreeshold() == -1) && !(rule.getLaaOperator().equals("-")))
			tLaa.setText("LAA: " + rule.getLaaOperator() + " que " + rule.getLaaThreeshold());

		if(!(rule.getLongMethodOperator().equals("-")))
			lmLog.setText("Operaçăo Lógica do Long Method do Utilizador: " + rule.getLongMethodOperator());

		if(!(rule.getFeatureEnvyOperator().equals("-")))
			feLog.setText("Operaçăo Lógica do Feature Envy do Utilizador: "+ rule.getFeatureEnvyOperator());

	}

	public void resetRulesInGUI()  {

		tLoc = new JLabel("LOC: " );
		tCyclo = new JLabel("CYCLO: ");
		tAtfd = new JLabel("ATFD: ");
		tLaa = new JLabel("LAA: " );
		lmLog = new JLabel("Operaçăo Lógica do Long Method do Utilizador: ");
		feLog = new JLabel("Operaçăo Lógica do Feature Envy do Utilizador: ");
	}

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
	 * The main method.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		Frame window = new Frame();
		window.open();
	}
}