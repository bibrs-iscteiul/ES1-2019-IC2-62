package pt.iul.ista.es.applications;

import java.util.List;


/**
 * The Class ErrorDetection.
 * @author Gonçalo Almeida
 * @since 2019-11-10
 */
public class ErrorDetection {

	/** The methods. */
	private List<Method> methods;
	
	/** The auxiliar List */
	private List<Method> aux;

	/**
	 * Instantiates a new error detection.
	 *
	 * @param methods the methods
	 */
	public ErrorDetection(List<Method> methods) {
		this.methods = methods;
		this.aux = methods;
	}

	/**
	 * Segundo criterio.
	 *
	 * @param longM the long M
	 * @return the list
	 */
	public List<Method> segundoCriterio(boolean longM) {

		for(Method m: methods)
			for(Method au: aux)
				if(m.getMethodID() == au.getMethodID()) {

					if(longM)	
						au.setIs_long_method_user(m.is_long_method_user);
					else	
						au.setIs_feature_envy_user(m.is_feature_envy_user);

				}	return aux;
	}

	/**
	 * Thresholds loc.
	 *
	 * @param loc the loc
	 * @param locmaior the locmaior
	 */
	public void thresholds_Loc(int loc, boolean locmaior) {

		for(Method method: methods) {

			if(locmaior == true) {
				if(method.getLoc() >= loc)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
			} else {
				if(method.getLoc() < loc)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
			}
		}
	}

	/**
	 * Thresholds cyclo.
	 *
	 * @param cyclo the cyclo
	 * @param cyclomaior the cyclomaior
	 */
	public void thresholds_Cyclo(int cyclo, boolean cyclomaior) {

		for(Method method: methods) {

			if(cyclomaior == true) {
				if(method.getCyclo() >= cyclo)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
			} else {
				if(method.getCyclo() < cyclo)
					method.setIs_long_method_user(true);
				else
					method.setIs_long_method_user(false);
			}
		}
	}

	/**
	 * Thresholds atfd.
	 *
	 * @param atfd the atfd
	 * @param atfdmaior the atfdmaior
	 */
	public void thresholds_Atfd(int atfd, boolean atfdmaior) {

		for(Method method: methods) {

			if(atfdmaior == true) {
				if(method.getAtfd() >= atfd)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
			} else {
				if(method.getAtfd() < atfd)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
			}
		}
	}

	/**
	 * Thresholds laa.
	 *
	 * @param laa the laa
	 * @param laamaior the laamaior
	 */
	public void thresholds_Laa(double laa, boolean laamaior) {

		for(Method method: methods) {
			
			if(laamaior == true) {
				if(method.getLaa() >= laa)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
			} else {
				if(method.getLaa() < laa)
					method.setIs_feature_envy_user(true);
				else
					method.setIs_feature_envy_user(false);
			}
		}
	}

}
