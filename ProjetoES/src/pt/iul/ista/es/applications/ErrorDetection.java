package pt.iul.ista.es.applications;

import java.util.List;

import pt.iul.ista.es.gui.ChangeRules;
import pt.iul.ista.es.gui.Frame;


/**
 * The Class ErrorDetection.
 * @author Gonçalo Almeida
 * @since 2019-11-10
 */
public class ErrorDetection {

	private Frame frame;

	/** The methods. */
	private List<Method> methods;

	/** The auxiliar List */
	private List<Method> aux;


	private boolean longM;
	private boolean featureE;

	private int loc;
	private int cyclo;
	private int atfd;
	private double laa;

	private String sloc;
	private String scyclo;
	private String satfd;
	private String slaa;

	private String lm_box = ("");
	private String fe_box = ("");

	public boolean isLongM() {
		return longM;
	}

	public void setLongM(boolean longM) {
		this.longM = longM;
	}

	public boolean isFeatureE() {
		return featureE;
	}

	public void setFeatureE(boolean featureE) {
		this.featureE = featureE;
	}

	public String getLm_box() {
		return lm_box;
	}

	public String getFe_box() {
		return fe_box;
	}

	public void setLm_box(String lm_box) {
		this.lm_box = lm_box;
	}

	public void setFe_box(String fe_box) {
		this.fe_box = fe_box;
	}

	/**
	 * Instantiates a new error detection.
	 *
	 * @param methods the methods
	 */
	public ErrorDetection(Frame frame) {
		this.frame = frame;
	}


	public void start() {
		this.methods = frame.getMethods();
		this.aux = frame.getMethods();
		
		this.loc = frame.getThresholdLoc();
		this.cyclo = frame.getThresholdCyclo();
		this.atfd = frame.getThresholdAtfd();
		this.laa = frame.getThresholdLaa();

		this.sloc = frame.getSloc();
		this.scyclo = frame.getScyclo();
		this.satfd = frame.getSatfd();
		this.slaa = frame.getSlaa();

	}

	public void work() {

		if(!(sloc.equals("")))
			thresholds_Loc();

		if(!(scyclo.equals("")))
			thresholds_Cyclo();

		if(!(satfd.equals("")))
			thresholds_Atfd();

		if(!(slaa.equals("")))
			thresholds_Laa();

		if (frame.getChangeRules().isUsado_lm())
			joinLM();

		if (frame.getChangeRules().isUsado_fe())
			joinFE();

		frame.getChangeRules().setUsado_lm(false);
		frame.getChangeRules().setUsado_fe(false);
		
	}

	public void update() {
		
		for (Method method : methods)
			frame.getMethodsJModel().addElement(method);
		frame.setMethods(methods);
		frame.getMethodsJList().setModel(frame.getMethodsJModel());
	}
	
	/**
	 * Segundo criterio.
	 *
	 * @param longM the long M
	 * @return the list
	 */
	public void segundoCriterio(boolean b) {

		for(Method m: methods)
			for(Method au: aux)
				if(m.getMethodID() == au.getMethodID()) {

					if(longM && b)	
						au.setIs_long_method_user(m.is_long_method_user);
					if(featureE && !b)	
						au.setIs_feature_envy_user(m.is_feature_envy_user);

				}
	}

	/**
	 * Thresholds loc.
	 *
	 * @param loc the loc
	 * @param locmaior the locmaior
	 */
	public void thresholds_Loc() {

		for(Method method: methods) {

			switch (sloc) {

			case "maior":
				if(method.getLoc() > loc)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			case "menor":
				if(method.getLoc() < loc)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			case "igual":
				if(method.getLoc() == loc)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Thresholds cyclo.
	 *
	 * @param cyclo the cyclo
	 * @param cyclomaior the cyclomaior
	 */
	public void thresholds_Cyclo() {

		if(longM) {
			segundoCriterio(true);
			longM = false;
		}

		for(Method method: methods) {

			switch (scyclo) {

			case "maior":
				if(method.getCyclo() > cyclo)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			case "menor":
				if(method.getCyclo() < cyclo)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			case "igual":
				if(method.getCyclo() == cyclo)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Thresholds atfd.
	 *
	 * @param atfd the atfd
	 * @param atfdmaior the atfdmaior
	 */
	public void thresholds_Atfd() {

		for(Method method: methods) {

			switch (satfd) {

			case "maior":
				if(method.getAtfd() > atfd)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			case "menor":
				if(method.getAtfd() < atfd)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			case "igual":
				if(method.getAtfd() == atfd)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Thresholds laa.
	 *
	 * @param laa the laa
	 * @param laamaior the laamaior
	 */
	public void thresholds_Laa() {

		if(featureE) {
			segundoCriterio(false);
			featureE = false;
		}

		for(Method method: methods) {

			switch (slaa) {

			case "maior":
				if(Double.compare(method.getLaa(), laa) > 0)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			case "menor":
				if(Double.compare(method.getLaa(), laa) < 0)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			case "igual":
				if(Double.compare(method.getLaa(), laa) == 0)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
				break;

			default:
				break;
			}
		}
	}

	public void joinLM() {

		for (Method m : methods)
			for (Method a1 : aux)
				if (m.getMethodID() == a1.getMethodID()) {

					if(lm_box.equals("or")) {
						if (m.isIs_long_method_user() == true || a1.isIs_long_method_user() == true) 
							m.setIs_long_method_user(true);
						
//						else {
//							if (a1.isIs_long_method_user() == true) 
//								m.setIs_long_method_user(true);
//							
//							else 
//								m.setIs_long_method_user(false);
//						}
					}
					
					if(lm_box.equals("and")) {
						if (m.isIs_long_method_user() == true && a1.isIs_long_method_user() == true)
							m.setIs_long_method_user(true);

						else
							m.setIs_long_method_user(false);
					}
				}
		
		
	}

	public void joinFE() {

		for (Method m : methods)
			for (Method a2 : aux)
				if (m.getMethodID() == a2.getMethodID()) {

					if(fe_box.equals("or")) {
						if (m.isIs_feature_envy_user() == true || a2.isIs_feature_envy_user() == true)
							m.setIs_feature_envy_user(true);
						else
							m.setIs_feature_envy_user(false);
					}
					
					if(fe_box.equals("and")) {
						if (m.isIs_feature_envy_user() == true && a2.isIs_feature_envy_user() == true)
							m.setIs_feature_envy_user(true);
						else
							m.setIs_feature_envy_user(false);
					}
				}
		
		
	}

}
