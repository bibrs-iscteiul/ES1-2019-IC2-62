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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import pt.iul.ista.es.applications.Method;
import pt.iul.ista.es.applications.ReadFromFile;
import pt.iul.ista.es.applications.ErrorDetection;

/**
 * The Class Frame.
 * @author Beatriz Ragageles e Bernardo Gameiro
 * @since 2019-11-03
 */
public class Frame {


	/** The frame. */
	private JFrame frame;

	/** The threshold loc. */
	private int thresholdLoc = 0;

	/** The threshold cyclo. */
	private int thresholdCyclo = 0;

	/** The threshold atfd. */
	private int thresholdAtfd = 0;

	/** The threshold laa. */
	private double thresholdLaa = 0;


	private String sloc = ("");

	private String scyclo = ("");

	private String satfd = ("");

	private String slaa = ("");

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
	private JList<Method> methodsJList;

	/** The methods J model. */
	private DefaultListModel<Method> methodsJModel;

	/** The change rules. */
	private ChangeRules changeRules;

	/** The error det. */
	private ErrorDetection errorDet;
	
	private int dci=0;
	private int adci=0;
	private int adii=0;
	private int dii=0;

	/**
	 * Gets the methods.
	 *
	 * @return the methods
	 */
	public List<Method> getMethods() {
		return methods;
	}
	

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}


	/**
	 * Gets the methods J list.
	 *
	 * @return the methods J list
	 */
	public JList<Method> getMethodsJList() {
		return methodsJList;
	}

	/**
	 * Gets the methods J model.
	 *
	 * @return the methods J model
	 */
	public DefaultListModel<Method> getMethodsJModel() {
		return methodsJModel;
	}

	/**
	 * Gets the error detection
	 *
	 * @return the error detection
	 */
	public ErrorDetection getErrorDet() {
		return errorDet;
	}

	/**
	 * Gets the threshold loc.
	 *
	 * @return the threshold loc
	 */
	public int getThresholdLoc() {
		return thresholdLoc;
	}

	/**
	 * Sets the threshold loc.
	 *
	 * @param thresholdLoc the new threshold loc
	 */
	public void setThresholdLoc(int thresholdLoc) {
		this.thresholdLoc = thresholdLoc;
	}

	/**
	 * Gets the threshold cyclo.
	 *
	 * @return the threshold cyclo
	 */
	public int getThresholdCyclo() {
		return thresholdCyclo;
	}

	/**
	 * Sets the threshold cyclo.
	 *
	 * @param thresholdCyclo the new threshold cyclo
	 */
	public void setThresholdCyclo(int thresholdCyclo) {
		this.thresholdCyclo = thresholdCyclo;
	}

	/**
	 * Gets the threshold atfd.
	 *
	 * @return the threshold atfd
	 */
	public int getThresholdAtfd() {
		return thresholdAtfd;
	}

	/**
	 * Sets the threshold atfd.
	 *
	 * @param thresholdAtfd the new threshold atfd
	 */
	public void setThresholdAtfd(int thresholdAtfd) {
		this.thresholdAtfd = thresholdAtfd;
	}

	/**
	 * Gets the threshold laa.
	 *
	 * @return the threshold laa
	 */
	public double getThresholdLaa() {
		return thresholdLaa;
	}

	/**
	 * Sets the threshold laa.
	 *
	 * @param thresholdLaa the new threshold laa
	 */
	public void setThresholdLaa(double thresholdLaa) {
		this.thresholdLaa = thresholdLaa;
	}


	public String getSloc() {
		return sloc;
	}

	public void setSloc(String sloc) {
		this.sloc = sloc;
	}

	public String getScyclo() {
		return scyclo;
	}

	public void setScyclo(String scyclo) {
		this.scyclo = scyclo;
	}

	public String getSatfd() {
		return satfd;
	}

	public void setSatfd(String satfd) {
		this.satfd = satfd;
	}

	public String getSlaa() {
		return slaa;
	}

	public void setSlaa(String slaa) {
		this.slaa = slaa;
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

		this.errorDet = new ErrorDetection(this);
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
		JPanel painel = new JPanel(); // o q esta dentro da janela
		painel.setLayout(new BorderLayout());
		JTextField thresholds1 = new JTextField("");
		JTextField thresholds2 = new JTextField("");
		JDialog dialog = new JDialog(); // janela

		JPanel painelThresholds = new JPanel();
		painelThresholds.setLayout(new GridLayout(0, 1));
		JLabel label = new JLabel("Valores Thresholds:");
		tLoc = new JLabel("LOC: " + thresholdLoc);
		tCyclo = new JLabel("CYCLO: " + thresholdCyclo);
		tAtfd = new JLabel("ATFD: " + thresholdAtfd);
		tLaa = new JLabel("LAA: " + thresholdLaa);
		lmLog = new JLabel("Operação Lógica do long_method_user: ");
		feLog = new JLabel("Operação Lógica do feature_envy_user: ");

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(3, 1));

		// JButtons
		JButton compararFeatureEnvy = new JButton("Comparar Feature Envy");
		JButton compararLongMethod = new JButton("Comparar Long Method");
		JButton escolherFicheiro = new JButton("Excel");
		JButton definirRegras = new JButton("Definir Regras"); // falta definir
		JButton visualizarRegras = new JButton("Visualizar Regras"); // falta definir
		
		escolherFicheiro.addActionListener(new ActionListener() { // adiciona acao ao botao
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser excel = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				excel.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue1 = excel.showOpenDialog(null); // linha default
				if (excel.getSelectedFile().toString().endsWith(".xlsx")) { // se ficheiro escolhido é excel
					fileExcel = excel.getSelectedFile();

					readFile = new ReadFromFile();

					try {
						methods = readFile.read(fileExcel.getName(), 0); // qqr cena para a sheet

						for (Method method : methods) 
							methodsJModel.addElement(method);

						methodsJList.setModel(methodsJModel);

						errorDet.start();
						errorDet.work();
						errorDet.update();

						excelImportado = true;

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
					else
						
						JOptionPane.showMessageDialog(frame,"Ficheiro não suportado");
			}
		});

		definirRegras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeRules.open();
				
				if(excelImportado) {
					errorDet.start();
					errorDet.work();
					errorDet.update();
				}
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
				JRadioButton r1=new JRadioButton("A) iPlasma");    
				JRadioButton r2=new JRadioButton("B) PMD"); 
				JRadioButton r3=new JRadioButton("C) Long_Method_User"); 
				JButton x = new JButton("Comparar");
				r1.setBounds(75,50,100,30);    
				r2.setBounds(75,100,100,30);
				r3.setBounds(75,150,200,30);
				x.setBounds(75,200,100,30);
				f.add(r1);
				f.add(r2); 
				f.add(r3);
				f.add(x);
				f.add(jpanel);
				f.setSize(300,300);    
				f.setLayout(null);    
				f.setVisible(true);

				x.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						f.setVisible(false);
						for(Method i: methods) {
							if(r1.isSelected()) {
								compare(i.isIplasma(), i.isIs_long_method());
							}
							if (r2.isSelected()){
								compare(i.isPmd(), i.isIs_long_method());
							}
							if(r3.isSelected()) {
								compare(i.isIs_long_method_user(), i.isIs_long_method());
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
				JRadioButton r1=new JRadioButton("A) Feature_Envy_User");    
				JRadioButton r2=new JRadioButton("B) regra2blablabla"); 
				JRadioButton r3=new JRadioButton("C) regra3blablabla"); 
				JButton x = new JButton("Comparar");
				r1.setBounds(75,50,200,30);    
				r2.setBounds(75,100,200,30);
				r3.setBounds(75,150,200,30);
				x.setBounds(75,200,100,30);
				f.add(r1);
				f.add(r2); 
				f.add(r3);
				f.add(x);
				f.add(jpanel);
				f.setSize(300,300);    
				f.setLayout(null);    
				f.setVisible(true);

				x.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						f.setVisible(false);
						for(Method i: methods) {
							if(r1.isSelected()) {
								compare(i.isIs_feature_envy_user(), i.isIs_feature_envy());
							}
							if (r2.isSelected()){
								compare(i.isPmd(), i.isIs_feature_envy()); //ALTERAR
							}
							if(r3.isSelected()) {
								compare(i.isIs_long_method_user(), i.isIs_feature_envy()); //ALTERAR
							}
						}

						JOptionPane.showMessageDialog(frame, "DCI: " +  dci + "\n" + "DII: " + dii + "\n" + "ADCI: " + adci + "\n" + "ADII: " + adii);
					}
				});
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
		painelBotoes.add(visualizarRegras);
		painelBotoes.add(compararLongMethod);
		painelBotoes.add(compararFeatureEnvy);

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
	 * Threshold update.
	 */
	public void thresholdUpdate() {
		if(!(sloc.equals("")))
			tLoc.setText("LOC: " + sloc + " que/a "+ thresholdLoc);
		if(!(scyclo.equals("")))
			tCyclo.setText("CYCLO: " + scyclo + " que/a "+ thresholdCyclo);
		if(!(satfd.equals("")))
			tAtfd.setText("ATFD: " + satfd + " que/a " + thresholdAtfd);
		if(!(slaa.equals("")))
			tLaa.setText("LAA: " + slaa + " que/a " + thresholdLaa);
		if(!(sloc.equals("") && !(scyclo.equals(""))))
			lmLog.setText("Operação Lógica do long_method_user: "+ errorDet.getLm_box());
		if(!(satfd.equals("") && !(slaa.equals(""))))
			feLog.setText("Operação Lógica do feature_envy_user: "+ errorDet.getFe_box());
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