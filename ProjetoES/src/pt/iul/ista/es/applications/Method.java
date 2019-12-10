package pt.iul.ista.es.applications;


/**
 * The Class Method which represents a method specific.
 * @author Joana Cavalheiro
 * @since 2019-11-04
 * 
 */
public class Method {

	/** The Method ID. */
	int MethodID;
	
	/** The package name. */
	String packageName;
	
	/** The class name. */
	String className;
	
	/** The method name. */
	String methodName;
	
	/** The loc represents the number of lines of method code. */
	int loc;
	
	/** The cyclo represents the cyclomatic complexity of the code. */
	int cyclo;
	
	/** The atfd represents the acesses that the method makes to methods of other classes. */
	int atfd;
	
	/** The laa represents the method acesses to attributes of the class itself. */
	double laa;
	
	/** The long method. */
	boolean is_long_method;
	
	/** The iplasma. */
	boolean iplasma;
	
	/** The pmd. */
	boolean pmd;
	
	/** The feature envy. */
	boolean is_feature_envy;
	
	/** The user's long method. */
	boolean isLongMethodUserBoolean;
	
	/** The user's feature envy. */
	boolean isFeatureEnvyUserBoolean;
	
	
	/**
	 * Checks if is checks if is long method.
	 *
	 * @return true, if is checks if is long method
	 */
	public boolean isIs_long_method() {
		return is_long_method;
	}

	/**
	 * Sets the checks if is long method.
	 *
	 * @param is_long_method the new checks if is long method
	 */
	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}

	/**
	 * Checks if is iplasma.
	 *
	 * @return true, if is iplasma
	 */
	public boolean isIplasma() {
		return iplasma;
	}

	/**
	 * Sets the iplasma.
	 *
	 * @param iplasma the new iplasma
	 */
	public void setIplasma(boolean iplasma) {
		this.iplasma = iplasma;
	}

	/**
	 * Checks if is pmd.
	 *
	 * @return true, if is pmd
	 */
	public boolean isPmd() {
		return pmd;
	}

	/**
	 * Sets the pmd.
	 *
	 * @param pmd the new pmd
	 */
	public void setPmd(boolean pmd) {
		this.pmd = pmd;
	}

	/**
	 * Checks if is checks if is feature envy.
	 *
	 * @return true, if is checks if is feature envy
	 */
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}

	/**
	 * Sets the checks if is feature envy.
	 *
	 * @param is_feature_envy the new checks if is feature envy
	 */
	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}

	/**
	 * Instantiates a new method.
	 *
	 * @param methodID the method ID
	 * @param packageName the package name
	 * @param className the class name
	 * @param methodName the method name
	 * @param loc the loc
	 * @param cyclo the cyclo
	 * @param atfd the atfd
	 * @param laa the laa
	 * @param is_long_method the is long method
	 * @param iplasma the iplasma
	 * @param pmd the pmd
	 * @param is_feature_envy the is feature envy
	 * @param is_long_method_user the is long method user
	 * @param is_feature_envy_user the is feature envy user
	 */
	public Method(int methodID, String packageName, String className, String methodName, int loc, int cyclo, int atfd,
			double laa, boolean is_long_method, boolean iplasma, boolean pmd, boolean is_feature_envy, boolean is_long_method_user, 
			boolean is_feature_envy_user) {
	
		this.MethodID = methodID;
		this.packageName = packageName;
		this.className = className;
		this.methodName = methodName;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atfd = atfd;
		this.laa = laa;
		this.is_long_method = is_long_method;
		this.iplasma = iplasma;
		this.pmd = pmd;
		this.is_feature_envy = is_feature_envy;

		this.isLongMethodUserBoolean= is_long_method_user;
		this.isFeatureEnvyUserBoolean = is_feature_envy_user;
	}
	
	/**
	 * Instantiates a new method.
	 */
	public Method() {
		
	}
	
	/**
	 * Gets the method ID.
	 *
	 * @return the method ID
	 */
	public int getMethodID() {
		return MethodID;
	}

	/**
	 * Checks if is long method user boolean.
	 *
	 * @return true, if is long method user boolean
	 */
	public boolean isLongMethodUserBoolean() {
		return isLongMethodUserBoolean;
	}

	/**
	 * Sets the long method user boolean.
	 *
	 * @param isLongMethodUserBoolean the new long method user boolean
	 */
	public void setLongMethodUserBoolean(boolean isLongMethodUserBoolean) {
		this.isLongMethodUserBoolean = isLongMethodUserBoolean;
	}

	/**
	 * Checks if is feature envy user boolean.
	 *
	 * @return true, if is feature envy user boolean
	 */
	public boolean isFeatureEnvyUserBoolean() {
		return isFeatureEnvyUserBoolean;
	}

	/**
	 * Sets the feature envy user boolean.
	 *
	 * @param isFeatureEnvyUserBoolean the new feature envy user boolean
	 */
	public void setFeatureEnvyUserBoolean(boolean isFeatureEnvyUserBoolean) {
		this.isFeatureEnvyUserBoolean = isFeatureEnvyUserBoolean;
	}

	/**
	 * Checks if is long method.
	 *
	 * @param thresholdLOC the threshold LOC
	 * @param operatorLOC the operator LOC
	 * @param thresholdCYCLO the threshold CYCLO
	 * @param operatorCYCLO the operator CYCLO
	 * @param operatorLongMethod the operator long method
	 * @return true, if is long method
	 */
	public boolean isLongMethodUser (int thresholdLOC, String operatorLOC, int thresholdCYCLO, String operatorCYCLO, String operatorLongMethod) {
	
		if (operatorLongMethod == "and" && thresholdLOC != -1 && thresholdCYCLO != -1) {
			//System.out.println("tem tudo long method and");
			
			if(operatorLOC == ">" && operatorCYCLO == ">") {
				if (this.loc > thresholdLOC && this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == "<") {
				if (this.loc < thresholdLOC && this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == "=") {
				if (this.loc == thresholdLOC && this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == ">" && operatorCYCLO == "<") {
				if (this.loc > thresholdLOC && this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == ">") {
				if (this.loc < thresholdLOC && this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == ">" && operatorCYCLO == "=") {
				if (this.loc > thresholdLOC && this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == "=") {
				if (this.loc < thresholdLOC && this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == ">") {
				if (this.loc == thresholdLOC && this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == "<") {
				if (this.loc == thresholdLOC && this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
		}
		
		else if (operatorLongMethod == "or" && thresholdLOC != -1 && thresholdCYCLO != -1) {
			//System.out.println("tem tudo long method or");
			
			if(operatorLOC == ">" && operatorCYCLO == ">") {
				if (this.loc > thresholdLOC || this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == "<") {
				if (this.loc < thresholdLOC || this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == "=") {
				if (this.loc == thresholdLOC || this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == ">" && operatorCYCLO == "<") {
				if (this.loc > thresholdLOC || this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == ">") {
				if (this.loc < thresholdLOC || this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == ">" && operatorCYCLO == "=") {
				if (this.loc > thresholdLOC || this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "<" && operatorCYCLO == "=") {
				if (this.loc < thresholdLOC || this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == ">") {
				if (this.loc == thresholdLOC || this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
			}
			
			else if(operatorLOC == "=" && operatorCYCLO == "<") {
				if (this.loc == thresholdLOC || this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
			}
		}
		
		else if (thresholdLOC != -1) {
			switch (operatorLOC) {
			
			case ">":
				if (this.loc > thresholdLOC)
					return true;
				else 
					return false;
				
			case "<":
				if (this.loc < thresholdLOC)
					return true;
				else 
					return false;
				
			case "=":
				if (this.loc == thresholdLOC)
					return true;
				else 
					return false;
			}
		}
		else if (thresholdCYCLO != -1) {
			switch (operatorCYCLO) {
			
			case ">":
				if (this.cyclo > thresholdCYCLO)
					return true;
				else 
					return false;
				
			case "<":
				if (this.cyclo < thresholdCYCLO)
					return true;
				else 
					return false;
				
			case "=":
				if (this.cyclo == thresholdCYCLO)
					return true;
				else 
					return false;
			}
		}
		
		return false;	
	}
	
	/**
	 * Checks if is feature envy.
	 *
	 * @param thresholdATFD the threshold ATFD
	 * @param operatorATFD the operator ATFD
	 * @param thresholdLAA the threshold LAA
	 * @param operatorLAA the operator LAA
	 * @param operatorFeatureEnvy the operator feature envy
	 * @return true, if is feature envy
	 */
	
	public boolean isFeatureEnvyUser (int thresholdATFD, String operatorATFD, double thresholdLAA, String operatorLAA, String operatorFeatureEnvy) {
		
		System.out.println("Valor laa: " + laa + "; valor threeshold: " + thresholdLAA + "; " + Double.compare(laa, thresholdLAA));
		
		if (operatorFeatureEnvy == "and" && thresholdATFD != -1 && thresholdLAA != -1) {
			
			if(operatorATFD == ">" && operatorLAA == ">") {
				if (this.atfd > thresholdATFD && Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == "<") {
				if (this.atfd < thresholdATFD && Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == "=") {
				if (this.atfd == thresholdATFD && Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == ">" && operatorLAA == "<") {
				if (this.atfd > thresholdATFD && Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == ">") {
				if (this.atfd < thresholdATFD && Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == ">" && operatorLAA == "=") {
				if (this.atfd > thresholdATFD && Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == "=") {
				if (this.atfd < thresholdATFD && Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == ">") {
				if (this.atfd == thresholdATFD && Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == "<") {
				if (this.atfd == thresholdATFD && Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
		}
		
		else if (operatorFeatureEnvy == "or" && thresholdATFD != -1 && thresholdLAA != -1) {
	
			if(operatorATFD == ">" && operatorLAA == ">") {
				if (this.atfd > thresholdATFD || Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == "<") {
				if (this.atfd < thresholdATFD || Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == "=") {
				if (this.atfd == thresholdATFD || Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == ">" && operatorLAA == "<") {
				if (this.atfd > thresholdATFD || Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == ">") {
				if (this.atfd < thresholdLAA || Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == ">" && operatorLAA == "=") {
				if (this.atfd > thresholdATFD || Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "<" && operatorLAA == "=") {
				if (this.atfd < thresholdATFD || Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == ">") {
				if (this.atfd == thresholdATFD || Double.compare(this.laa, thresholdLAA) == 1)
					return true;
				else 
					return false;
			}
			
			else if(operatorATFD == "=" && operatorLAA == "<") {
				if (this.atfd == thresholdATFD || Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
			}
		}
		
		else if (thresholdATFD != -1) {
			switch (operatorATFD) {
			
			case ">":
				if (this.atfd > thresholdATFD)
					return true;
				else 
					return false;
				
			case "<":
				if (this.atfd < thresholdATFD)
					return true;
				else 
					return false;
				
			case "=":
				if (this.atfd == thresholdATFD)
					return true;
				else 
					return false;
			}
		}
		
		else if (thresholdLAA != -1) {
			switch (operatorLAA) {
			
			case ">":
				if(Double.compare(this.laa, thresholdLAA) == 1) 
					return true;
				else 
					return false;
				
			case "<":
				if (Double.compare(this.laa, thresholdLAA) == -1)
					return true;
				else 
					return false;
				
			case "=":
				if (Double.compare(this.laa, thresholdLAA) == 0)
					return true;
				else 
					return false;
			}
		}
		
		return false;	
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.MethodID + "; Package: " + this.packageName + "; Classe: " + this.className + 
				"; Método: " + this.methodName + "; LOC: " + this.loc + "; CYCLO: " + this.cyclo + "; ATFD: " + this.atfd + "; LAA: " 
				+ this.laa + "; isLongMethod: " + this.is_long_method + "; iPlasma: " + this.iplasma + "; PMD: " 
				+ this.pmd + "; isFeatureEnvy: " + this.is_feature_envy);

		return sb.toString();
	}
}