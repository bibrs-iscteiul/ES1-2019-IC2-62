/*
 * 
 */
package pt.iul.ista.es.applications;

import java.util.List;

/**
 * The Class Rule.
 * @author Joana Cavalheiro
 * @since 2019-11-12
 */
public class Rule {

	/** The loc threeshold. */
	private int locThreeshold = -1;
	
	/** The loc operator. */
	private String locOperator;

	/** The cyclo threeshold. */
	private int cycloThreeshold = -1;
	
	/** The cyclo operator. */
	private String cycloOperator;

	/** The long method operator. */
	private String longMethodOperator = "";
	
	/** The long method. */
	private boolean longMethod; 

	/** The atfd threeshold. */
	private int atfdThreeshold = -1;
	
	/** The atfd operator. */
	private String atfdOperator;

	/** The laa threeshold. */
	private Double laaThreeshold = (double) -1;
	
	/** The laa operator. */
	private String laaOperator;

	/** The feature envy operator. */
	private String featureEnvyOperator = "";
	
	/** The feature envy. */
	private boolean featureEnvy;

	
	/**
	 * Instantiates a new rule.
	 */
	public Rule() {
	
	}

	/**
	 * Instantiates a new rule.
	 *
	 * @param locThreeshold the loc threeshold
	 * @param locOperator the loc operator
	 * @param cycloThreeshold the cyclo threeshold
	 * @param cycloOperator the cyclo operator
	 * @param longMethodOperator the long method operator
	 * @param atfdThreeshold the atfd threeshold
	 * @param atfdOperator the atfd operator
	 * @param laaThreeshold the laa threeshold
	 * @param laaOperator the laa operator
	 * @param featureEnvyOperator the feature envy operator
	 */
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

	
	/**
	 * Gets the loc threeshold.
	 *
	 * @return the loc threeshold
	 */
	public int getLocThreeshold() {
		return locThreeshold;
	}

	/**
	 * Sets the loc threeshold.
	 *
	 * @param locThreeshold the new loc threeshold
	 */
	public void setLocThreeshold(int locThreeshold) {
		this.locThreeshold = locThreeshold;
	}

	/**
	 * Gets the loc operator.
	 *
	 * @return the loc operator
	 */
	public String getLocOperator() {
		return locOperator;
	}

	/**
	 * Sets the loc operator.
	 *
	 * @param locOperator the new loc operator
	 */
	public void setLocOperator(String locOperator) {
		this.locOperator = locOperator;
	}

	/**
	 * Gets the cyclo threeshold.
	 *
	 * @return the cyclo threeshold
	 */
	public int getCycloThreeshold() {
		return cycloThreeshold;
	}

	/**
	 * Sets the cyclo threeshold.
	 *
	 * @param cycloThreeshold the new cyclo threeshold
	 */
	public void setCycloThreeshold(int cycloThreeshold) {
		this.cycloThreeshold = cycloThreeshold;
	}

	/**
	 * Gets the cyclo operator.
	 *
	 * @return the cyclo operator
	 */
	public String getCycloOperator() {
		return cycloOperator;
	}

	/**
	 * Sets the cyclo operator.
	 *
	 * @param cycloOperator the new cyclo operator
	 */
	public void setCycloOperator(String cycloOperator) {
		this.cycloOperator = cycloOperator;
	}

	/**
	 * Gets the long method operator.
	 *
	 * @return the long method operator
	 */
	public String getLongMethodOperator() {
		return longMethodOperator;
	}

	/**
	 * Sets the long method operator.
	 *
	 * @param longMethodOperator the new long method operator
	 */
	public void setLongMethodOperator(String longMethodOperator) {
		this.longMethodOperator = longMethodOperator;
	}

	/**
	 * Gets the atfd threeshold.
	 *
	 * @return the atfd threeshold
	 */
	public int getAtfdThreeshold() {
		return atfdThreeshold;
	}

	/**
	 * Sets the atfd threeshold.
	 *
	 * @param atfdThreeshold the new atfd threeshold
	 */
	public void setAtfdThreeshold(int atfdThreeshold) {
		this.atfdThreeshold = atfdThreeshold;
	}

	/**
	 * Gets the atfd operator.
	 *
	 * @return the atfd operator
	 */
	public String getAtfdOperator() {
		return atfdOperator;
	}

	/**
	 * Sets the atfd operator.
	 *
	 * @param atfdOperator the new atfd operator
	 */
	public void setAtfdOperator(String atfdOperator) {
		this.atfdOperator = atfdOperator;
	}

	/**
	 * Gets the laa threeshold.
	 *
	 * @return the laa threeshold
	 */
	public Double getLaaThreeshold() {
		return laaThreeshold;
	}

	/**
	 * Sets the laa threeshold.
	 *
	 * @param laaThreeshold the new laa threeshold
	 */
	public void setLaaThreeshold(Double laaThreeshold) {
		this.laaThreeshold = laaThreeshold;
	}

	/**
	 * Gets the laa operator.
	 *
	 * @return the laa operator
	 */
	public String getLaaOperator() {
		return laaOperator;
	}

	/**
	 * Sets the laa operator.
	 *
	 * @param laaOperator the new laa operator
	 */
	public void setLaaOperator(String laaOperator) {
		this.laaOperator = laaOperator;
	}

	/**
	 * Gets the feature envy operator.
	 *
	 * @return the feature envy operator
	 */
	public String getFeatureEnvyOperator() {
		return featureEnvyOperator;
	}

	/**
	 * Sets the feature envy operator.
	 *
	 * @param featureEnvyOperator the new feature envy operator
	 */
	public void setFeatureEnvyOperator(String featureEnvyOperator) {
		this.featureEnvyOperator = featureEnvyOperator;
	}
	
	/**
	 * Checks if is long method.
	 *
	 * @return true, if is long method
	 */
	public boolean isLongMethod() {
		return longMethod;
	}

	/**
	 * Sets the long method.
	 *
	 * @param longMethod the new long method
	 */
	public void setLongMethod(boolean longMethod) {
		this.longMethod = longMethod;
	}

	/**
	 * Checks if is feature envy.
	 *
	 * @return true, if is feature envy
	 */
	public boolean isFeatureEnvy() {
		return featureEnvy;
	}

	/**
	 * Sets the feature envy.
	 *
	 * @param featureEnvy the new feature envy
	 */
	public void setFeatureEnvy(boolean featureEnvy) {
		this.featureEnvy = featureEnvy;
	}

	
	/**
	 * To string.
	 *
	 * @return the string
	 */
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

	/**
	 * Adds the rule to list.
	 *
	 * @param savedRules the saved rules
	 */
	public void addRuleToList(List<Rule> savedRules) {
		savedRules.add(this);
		
		for (Rule rule : savedRules) 
			System.out.println(rule.toString());
			
	}
}
