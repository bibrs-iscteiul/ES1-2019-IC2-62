package pt.iul.ista.es.applications;

/**
 * The Class Method which represents a method specific.
 * @author Joana Cavalheiro
 * @since 2019-11-05
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
	
	/** The loc. */
	int loc;
	
	/** The cyclo. */
	int cyclo;
	
	/** The atfd. */
	int atfd;
	
	/** The laa. */
	double laa;
	
	/** The is long method. */
	boolean is_long_method;
	
	/** The iplasma. */
	boolean iplasma;
	
	/** The pmd. */
	boolean pmd;
	
	/** The is feature envy. */
	boolean is_feature_envy;
	
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
	 */
	public Method(int methodID, String packageName, String className, String methodName, int loc, int cyclo, int atfd,
			double laa, boolean is_long_method, boolean iplasma, boolean pmd, boolean is_feature_envy) {
	
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
	}
	
	/**
	 * Instantiates a new method.
	 */
	public Method() {
		
	}
	
	/**
	 * Checks if is long method.
	 *
	 * @param thresholdLOC the threshold LOC
	 * @param thresholdCYCLO the threshold CYCLO
	 * @return true, if is long method
	 */
	public boolean isLongMethod (int thresholdLOC, int thresholdCYCLO) {
		if (this.loc > thresholdLOC && this.cyclo > thresholdCYCLO)
			return true;
		else 
			return false;
	}
	
	/**
	 * Checks if is feature envy.
	 *
	 * @param thresholdATFD the threshold ATFD
	 * @param thresholdLAA the threshold LAA
	 * @return true, if is feature envy
	 */
	public boolean isFeatureEnvy (int thresholdATFD, int thresholdLAA) {
		if (this.atfd > thresholdATFD && this.laa < thresholdLAA) 
			return true;
		else 
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
				"; M�todo: " + this.methodName + "; LOC: " + this.loc + "; CYCLO: " + this.cyclo + "; ATFD: " + this.atfd + "; LAA: " 
				+ this.laa + "; isLongMethod: " + this.is_long_method + "; iPlasma: " + this.iplasma + "; PMD: " 
				+ this.pmd + "; isFeatureEnvy: " + this.is_feature_envy);

		return sb.toString();
	}
	
}
