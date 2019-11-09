package pt.iul.ista.es.gui;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import pt.iul.ista.es.applications.errorDetection;


public class Frame{
	private JFrame frame;

	private int intThreshold1 = 10;//LOC
	private int intThreshold2 = 80;//CYCLO
	private int intThreshold3; //ATFD
	private int intThreshold4; //LAA

	private File fileExcel;
	private JFrame frameDialog;

	private ReadFromFile readFile;

	private List<Method> methods;
	private JList<Method> methodsJList;
	private DefaultListModel<Method> methodsJModel;


	private errorDetection errorDet;

	public Frame() {
		frame = new JFrame("Deteta Efeitos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		frame.setSize(1500, 900);
		frame.setVisible(true);

		//		errorDet = new errorDetection(methods);
	}

	public void open() {
		frame.setVisible(true);
	}

	private void addFrameContent() {

		//JLists
		methodsJList = new JList();
		this.methodsJModel = new DefaultListModel();

		//JTextFields
		JPanel painel = new JPanel(); //o q esta dentro da janela
		painel.setLayout(new BorderLayout());
		JTextField thresholds1 = new JTextField("");
		JTextField thresholds2 = new JTextField("");
		JDialog dialog = new JDialog(); //janela
		JDialog defineRules = new JDialog();

		JPanel painelThresholds= new JPanel();
		painelThresholds.setLayout(new GridLayout(4, 1));
		JLabel label= new JLabel("Valores Thresholds:");
		JLabel valor1 = new JLabel("10");
		JLabel valor2 = new JLabel("80");

		//Definir Regras Box
		JLabel loc = new JLabel();
		loc.setText("Valor do LOC: ");
		JTextField text_loc = new JTextField("loc");
		JCheckBox check_loc = new JCheckBox("maior");

		JLabel cyclo = new JLabel();
		cyclo.setText("Valor do CYCLO: ");
		JTextField text_cyclo = new JTextField("cyclo");
		JCheckBox check_cyclo = new JCheckBox("maior");

		JLabel atfd = new JLabel();
		atfd.setText("Valor do ATFD: ");
		JTextField text_atfd = new JTextField("atfd");
		JCheckBox check_atfd = new JCheckBox("maior");

		JLabel laa = new JLabel();
		laa.setText("Valor do LAA: ");
		JTextField text_laa = new JTextField("laa");
		JCheckBox check_laa = new JCheckBox("maior");


		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(3,1));


		//JButtons
		JButton escolherFicheiro = new JButton("Excel");
		JButton atualizaThresholds = new JButton("Thresholds"); //abre outra janela
		JButton atualizar = new JButton("Atualizar");
		JButton definirRegras = new JButton("Definir Regras");
		JButton visualizarRegras = new JButton("Visualizar Regras"); //falta definir
		JButton definir = new JButton("Definir");

		escolherFicheiro.addActionListener(new ActionListener() {  //adiciona acao ao botao
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser excel = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				excel.setFileSelectionMode(JFileChooser.FILES_ONLY); 
				int returnValue1 = excel.showOpenDialog(null); //linha default
				if(excel.getSelectedFile().toString().endsWith(".xlsx")) { //se ficheiro escolhido é excel
					fileExcel = excel.getSelectedFile();

					readFile = new ReadFromFile();

					try {
						methods = readFile.read(fileExcel.getName(), 0); // qqr cena para a sheet

						for (Method method : methods) 
							methodsJModel.addElement(method);

						methodsJList.setModel(methodsJModel);

						errorDet = new errorDetection(methods);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		atualizaThresholds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setSize(700, 300);
				dialog.setVisible(true); //equivalente a open
			}
		});

		atualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				intThreshold1= Integer.parseInt(thresholds1.getText()); //p n dar string e dar int
				intThreshold2= Integer.parseInt(thresholds2.getText());
				valor1.setText(thresholds1.getText()); //pq n atualiza valor sozinho
				valor2.setText(thresholds2.getText());
				dialog.setVisible(false);
			}
		});

		definirRegras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				defineRules.setSize(700, 300);
				defineRules.setVisible(true);
			}
		});

		definir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int valor; int i = 0; 
				List<Method> aux1 = null;
				boolean usado = false;

				if(text_loc.getText().matches("[0-9]+")) {
					valor = Integer.parseInt(text_loc.getText());

					if(check_loc.isSelected())
						errorDet.thresholds_Loc(valor, true);
					else
						errorDet.thresholds_Loc(valor, false);

					usado = true; i++;
				}

				if(text_cyclo.getText().matches("[0-9]+")) {
					valor = Integer.parseInt(text_cyclo.getText());

					if(check_cyclo.isSelected()) {
						if(usado == false) {
							errorDet.thresholds_Cyclo(valor, true);
							usado = true;

						}	else {
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Cyclo(valor, true);
						}

					}	else {
						if(usado == false) {
							errorDet.thresholds_Cyclo(valor, false);
							usado = true;

						}	else {
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Cyclo(valor, false);
						}

					}	i++;
				}

				if(text_atfd.getText().matches("[0-9]+") && i!=2) {
					valor = Integer.parseInt(text_atfd.getText());

					if(check_atfd.isSelected()) {
						if(!usado) {
							errorDet.thresholds_Atfd(valor, true);
							usado = true;

						}	else {	
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Atfd(valor, true);
						}

					}	else {
						if(!usado) {
							errorDet.thresholds_Atfd(valor, false);
							usado = true;

						}	else {
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Atfd(valor, false);
						}

					}	i++;
				}	

				if(text_laa.getText().matches("[0-9]+") && i!=2) {
					valor = Integer.parseInt(text_laa.getText());

					if(check_cyclo.isSelected()) {
						if(!usado)	{
							errorDet.thresholds_Laa(valor, true);
							usado = true;

						}	else {
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Laa(valor, true);
						}

					}	else {
						if(!usado)	errorDet.thresholds_Laa(valor, false);
						else {
							aux1 = errorDet.segundoCriterio();
							errorDet.thresholds_Laa(valor, false);
						}

					}	i++;
				}


				if(aux1 != null) {
					for(Method m: methods) {
						for(Method a1: aux1) {
							if( m.getMethodID() == a1.getMethodID() ) {
								if(m.isIs_long_method_user() == true && a1.isIs_long_method_user() == true)
									m.setIs_long_method_user(true);
								else	m.setIs_long_method_user(false);
							}
						}
					}
				}

				for(Method method: methods)
					methodsJModel.addElement(method);
				methodsJList.setModel(methodsJModel);

				defineRules.setVisible(false);
			}
		});

		//Painel com JButtons e JTextFields

		//DefineRules
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

		//Dialog
		painel.add(new JLabel("Valores de Thresholds"), BorderLayout.NORTH);
		JPanel painelTextField = new JPanel();
		painelTextField.setLayout(new GridLayout(2,1));
		painelTextField.add(thresholds1);
		painelTextField.add(thresholds2);
		painel.add(painelTextField, BorderLayout.NORTH);
		painel.add(atualizar, BorderLayout.SOUTH);
		dialog.add(painel);

		//South.West (valores thresholds)
		painelThresholds.add(label);
		painelThresholds.add(valor1);
		painelThresholds.add(valor2);
		painelThresholds.add(atualizaThresholds);

		//South.East (restantes botoes)
		painelBotoes.add(escolherFicheiro);
		painelBotoes.add(definirRegras);
		painelBotoes.add(visualizarRegras);

		//painel South
		JPanel painelSouth = new JPanel();
		painelSouth.setLayout(new BorderLayout());
		painelSouth.add(painelThresholds, BorderLayout.EAST);
		painelSouth.add(painelBotoes, BorderLayout.WEST);

		//painel principal
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
