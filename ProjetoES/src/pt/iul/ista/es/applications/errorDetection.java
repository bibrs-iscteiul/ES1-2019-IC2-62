package pt.iul.ista.es.applications;

public class errorDetection {
	
	public Method[] methods;
	
	public errorDetection(Method[] methods) {
		
		this.methods = methods;
		
	}

	public void thresholds_isLM(int loc, int cyclo,
			boolean locmaior, boolean cyclomaior) {
		
		for(int i = 0; i<methods.length - 1; i++) {
			
			if(locmaior == true) {
				if(methods[i].getLoc() >= loc)
					methods[i].setIs_long_method_user(true);
				else
					methods[i].setIs_long_method_user(false);
			} else {
				if(methods[i].getLoc() < loc)
					methods[i].setIs_long_method_user(true);
				else
					methods[i].setIs_long_method_user(false);
			}
			
			if(cyclomaior == true) {
				if(methods[i].getCyclo() >= cyclo)
					methods[i].setIs_long_method_user(true);
				else
					methods[i].setIs_long_method_user(false);
			} else {
				if(methods[i].getCyclo() < cyclo)
					methods[i].setIs_long_method_user(true);
				else
					methods[i].setIs_long_method_user(false);
			}
		}
	}
	
public void thresholds_isFE(int atfd, int laa,
		boolean atfdmaior, boolean laamaior) {
		
		for(int i = 0; i<methods.length - 1; i++) {
			
			if(atfdmaior == true) {
				if(methods[i].getAtfd() >= atfd)
					methods[i].setIs_feature_envy_user(true);
				else
					methods[i].setIs_feature_envy_user(false);
			} else {
				if(methods[i].getAtfd() < atfd)
					methods[i].setIs_feature_envy_user(true);
				else
					methods[i].setIs_feature_envy_user(false);
			}
			
			if(laamaior == true) {
				if(methods[i].getLaa() >= laa)
					methods[i].setIs_feature_envy_user(true);
				else
					methods[i].setIs_feature_envy_user(false);
			} else {
				if(methods[i].getLaa() < laa)
					methods[i].setIs_feature_envy_user(true);
				else
					methods[i].setIs_feature_envy_user(false);
			}
		}
	}

}
