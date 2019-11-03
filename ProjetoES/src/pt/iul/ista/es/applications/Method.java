package pt.iul.ista.es.applications;

public class Method {

	int MethodID;
	String packageName;
	String className;
	String methodName;
	int loc;
	int cyclo;
	int atfd;
	int laa;
	boolean is_long_method;
	boolean iplasma;
	boolean pmd;
	boolean is_feature_envy;
	
	public Method(int methodID, String packageName, String className, String methodName, int loc, int cyclo, int atfd,
			int laa, boolean is_long_method, boolean iplasma, boolean pmd, boolean is_feature_envy) {
		super();
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
	
	public Method() {
		
	}
	
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
