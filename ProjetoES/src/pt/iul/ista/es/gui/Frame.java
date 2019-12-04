package pt.iul.ista.es.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import pt.iul.ista.es.applications.Method;
import pt.iul.ista.es.applications.ReadFromFile;

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


	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		frame = new JFrame("Deteta Defeitos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		frame.setSize(900, 500);
		frame.setVisible(true);

		this.changeRules = new ChangeRules(this);

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
		JScrollPane scroll = new JScrollPane (methodsJList) ;

		// JTextFields
		JPanel painel = new JPanel(); 
		painel.setLayout(new BorderLayout());
		JTextField thresholds1 = new JTextField("");
		JTextField thresholds2 = new JTextField("");
		JDialog dialog = new JDialog(); // janela

		JPanel painelThresholds = new JPanel();
		painelThresholds.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Valores Thresholds:");
		tLoc = new JLabel("LOC: " );
		tCyclo = new JLabel("CYCLO: ");
		tAtfd = new JLabel("ATFD: ");
		tLaa = new JLabel("LAA: " );
		lmLog = new JLabel("Operaçăo Lógica do Long Method do Utilizador: ");
		feLog = new JLabel("Operaçăo Lógica do Feature Envy do Utilizador: ");

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(3, 1));

		// JButtons
		JButton escolherFicheiro = new JButton("Excel");
		JButton definirRegras = new JButton("Definir Regras"); 
		
		escolherFicheiro.addActionListener(new ActionListener() { // adiciona acao ao botao
			@Override
			public void actionPerformed(ActionEvent e) {
				
				excelImportado = false;
				methodsJModel.clear();
				
				JFileChooser excel = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				excel.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue1 = excel.showOpenDialog(null); // linha default
				
				if (excel.getSelectedFile().toString().endsWith(".xlsx")) { // se ficheiro escolhido é excel
					fileExcel = excel.getSelectedFile();

					readFile = new ReadFromFile();

					try {
						methods = readFile.read(fileExcel.getName(), 0); // qqr cena para a sheet

						for (Method method : methods) 
							methodsJModel.addElement(method.toString());

						methodsJList.setModel(methodsJModel);
			
						excelImportado = true;
						
						if(changeRules.isDefinedRules()) 
							changeRules.saveRules();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		definirRegras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeRules.open();
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
	
	public void updateRulesInGUI() {
		
		if(!(changeRules.getLocThreeshold() == -1) && !(changeRules.getLocOperator().equals("-")))
			tLoc.setText("LOC: " + changeRules.getLocOperator() + " que "+ changeRules.getLocThreeshold());
		
		if(!(changeRules.getCycloThreeshold() == -1) && !(changeRules.getCycloOperator().equals("-")))
			tCyclo.setText("CYCLO: " + changeRules.getCycloOperator() + " que " + changeRules.getCycloThreeshold());
		
		if(!(changeRules.getAtfdThreeshold() == -1) && !(changeRules.getAtfdOperator().equals("-")))
			tAtfd.setText("ATFD: " + changeRules.getAtfdOperator() + " que " + changeRules.getAtfdThreeshold());
		
		if(!(changeRules.getLaaThreeshold() == -1) && !(changeRules.getLaaOperator().equals("-")))
			tLaa.setText("LAA: " + changeRules.getLaaOperator() + " que " + changeRules.getLaaThreeshold());
		
		if(!(changeRules.getLongMethodOperator().equals("-")))
			lmLog.setText("Operaçăo Lógica do Long Method do Utilizador: " + changeRules.getLongMethodOperator());
		
		if(!(changeRules.getFeatureEnvyOperator().equals("-")))
			feLog.setText("Operaçăo Lógica do Feature Envy do Utilizador: "+ changeRules.getFeatureEnvyOperator());
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