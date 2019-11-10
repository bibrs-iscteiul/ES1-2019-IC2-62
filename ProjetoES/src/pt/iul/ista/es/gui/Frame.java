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
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import pt.iul.ista.es.applications.Method;
import pt.iul.ista.es.applications.ReadFromFile;
import pt.iul.ista.es.applications.ErrorDetection;

public class Frame {
	private JFrame frame;
	
	private int intThresholdLoc;
	private int intThresholdCyclo;
	private int intThresholdAtfd;
	private int intThresholdLaa;
	
	private File fileExcel;

	private ReadFromFile readFile;
	
	private List<Method> methods;
	private JList<Method> methodsJList;
	private DefaultListModel<Method> methodsJModel;
	
	private ChangeRules changeRules;
	private ErrorDetection errorDet;

	public List<Method> getMethods() {
		return methods;
	}

	public JList<Method> getMethodsJList() {
		return methodsJList;
	}

	public DefaultListModel<Method> getMethodsJModel() {
		return methodsJModel;
	}

	public ErrorDetection getErrorDet() {
		return errorDet;
	}
	
	public Frame() {
		frame = new JFrame("Deteta Defeitos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		frame.setSize(700, 400);
		frame.setVisible(true);
		
		this.changeRules = new ChangeRules(this);
		
		// errorDet = new errorDetection(methods);
	}

	public void open() {
		frame.setVisible(true);
	}

	private void addFrameContent() {

		// JLists
		methodsJList = new JList();
		this.methodsJModel = new DefaultListModel();
		
		// JTextFields
		JPanel painel = new JPanel(); // o q esta dentro da janela
		painel.setLayout(new BorderLayout());
		JTextField thresholds1 = new JTextField("");
		JTextField thresholds2 = new JTextField("");
		JDialog dialog = new JDialog(); // janela

		JPanel painelThresholds = new JPanel();
		painelThresholds.setLayout(new GridLayout(4, 1));
		JLabel label = new JLabel("Valores Thresholds:");
		JLabel valor1 = new JLabel("10");
		JLabel valor2 = new JLabel("80");

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(3, 1));

		// JButtons
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
						
						errorDet = new ErrorDetection(methods);
						
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
		painelThresholds.add(valor1);
		painelThresholds.add(valor2);

		// South.East (restantes botoes)
		painelBotoes.add(escolherFicheiro);
		painelBotoes.add(definirRegras);
		painelBotoes.add(visualizarRegras);

		// painel South
		JPanel painelSouth = new JPanel();
		painelSouth.setLayout(new GridLayout(1, 2));
		painelSouth.add(painelBotoes, BorderLayout.WEST);
		painelSouth.add(painelThresholds, BorderLayout.EAST);

		// painel principal
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new GridLayout(2, 1));
		painelPrincipal.add(methodsJList);
		painelPrincipal.add(painelSouth);

		frame.add(painelPrincipal);
	}

	public static void main(String[] args) {
		Frame window = new Frame();
		window.open();
	}
}