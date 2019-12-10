package pt.iul.ista.es.applications;

import java.util.List;

public class Rule {

	private int locThreeshold = -1;
	private String locOperator;

	private int cycloThreeshold = -1;
	private String cycloOperator;

	private String longMethodOperator = "";
	
	private boolean longMethod; 

	private int atfdThreeshold = -1;
	private String atfdOperator;

	private Double laaThreeshold = (double) -1;
	private String laaOperator;

	private String featureEnvyOperator = "";
	
	private boolean featureEnvy;

	
	public Rule() {
	
	}

	public Rule(int locThreeshold, String locOperator, int cycloThreeshold, String cycloOperator,
			String longMethodOperator, int atfdThreeshold, String atfdOperator, Double laaThreeshold, String laaOperator,
			String featureEnvyOperator) {

		this.locThreeshold = locThreeshold;
		this.locOperator = locOperator;
		this.cycloThreeshold = cycloThreeshold;
		this.cycloOperator = cycloOperator;
		this.longMethodOperator = longMethodOperator;
		
		this.atfdThreeshold = atfdThreeshold;
		this.atfdOperator = atfdOperator;
		this.laaThreeshold = laaThreeshold;
		this.laaOperator = laaOperator;
		this.featureEnvyOperator = featureEnvyOperator;
	}

	
	public int getLocThreeshold() {
		return locThreeshold;
	}

	public void setLocThreeshold(int locThreeshold) {
		this.locThreeshold = locThreeshold;
	}

	public String getLocOperator() {
		return locOperator;
	}

	public void setLocOperator(String locOperator) {
		this.locOperator = locOperator;
	}

	public int getCycloThreeshold() {
		return cycloThreeshold;
	}

	public void setCycloThreeshold(int cycloThreeshold) {
		this.cycloThreeshold = cycloThreeshold;
	}

	public String getCycloOperator() {
		return cycloOperator;
	}

	public void setCycloOperator(String cycloOperator) {
		this.cycloOperator = cycloOperator;
	}

	public String getLongMethodOperator() {
		return longMethodOperator;
	}

	public void setLongMethodOperator(String longMethodOperator) {
		this.longMethodOperator = longMethodOperator;
	}

	public int getAtfdThreeshold() {
		return atfdThreeshold;
	}

	public void setAtfdThreeshold(int atfdThreeshold) {
		this.atfdThreeshold = atfdThreeshold;
	}

	public String getAtfdOperator() {
		return atfdOperator;
	}

	public void setAtfdOperator(String atfdOperator) {
		this.atfdOperator = atfdOperator;
	}

	public Double getLaaThreeshold() {
		return laaThreeshold;
	}

	public void setLaaThreeshold(Double laaThreeshold) {
		this.laaThreeshold = laaThreeshold;
	}

	public String getLaaOperator() {
		return laaOperator;
	}

	public void setLaaOperator(String laaOperator) {
		this.laaOperator = laaOperator;
	}

	public String getFeatureEnvyOperator() {
		return featureEnvyOperator;
	}

	public void setFeatureEnvyOperator(String featureEnvyOperator) {
		this.featureEnvyOperator = featureEnvyOperator;
	}
	
	public boolean isLongMethod() {
		return longMethod;
	}

	public void setLongMethod(boolean longMethod) {
		this.longMethod = longMethod;
	}

	public boolean isFeatureEnvy() {
		return featureEnvy;
	}

	public void setFeatureEnvy(boolean featureEnvy) {
		this.featureEnvy = featureEnvy;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		if(locThreeshold != -1)
			sb.append("LOC " + locOperator + " " + locThreeshold + " ");
		
		if(locThreeshold != -1 && cycloThreeshold != -1)
			sb.append(longMethodOperator + " ");
	
		if(cycloThreeshold != -1)
			sb.append("CYCLO " + cycloOperator + " " + cycloThreeshold + " ");
		
		if(atfdThreeshold != -1)
			sb.append("ATFD " + atfdOperator + " " + atfdThreeshold + " ");
		
		if(atfdThreeshold != -1 && laaThreeshold != -1)
			sb.append(featureEnvyOperator + " ");
		
		if(laaThreeshold != -1)
			sb.append("LAA " + laaOperator + " " + laaThreeshold + " ");

		return sb.toString();
	}

	public void addRuleToList(List<Rule> savedRules) {
		savedRules.add(this);
		
		for (Rule rule : savedRules) 
			System.out.println(rule.toString());
			
	}
}
