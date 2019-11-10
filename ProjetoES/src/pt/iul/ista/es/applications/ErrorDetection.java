package pt.iul.ista.es.applications;

import java.util.List;

public class ErrorDetection {

	private List<Method> methods;
	private List<Method> aux;

	public ErrorDetection(List<Method> methods) {
		this.methods = methods;
		this.aux = methods;
	}

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
