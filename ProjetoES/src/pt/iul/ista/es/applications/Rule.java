package pt.iul.ista.es.applications;

import java.util.List;

public class Rule {

	private int locThreeshold = -1;
	private String locOperator;

	private int cycloThreeshold = -1;
	private String cycloOperator;

	private String longMethodOperator;

	private int atfdThreeshold = -1;
	private String atfdOperator;

	private int laaThreeshold = -1;
	private String laaOperator;

	private String featureEnvyOperator;
	
	public Rule() {
		
	}

	public Rule(int locThreeshold, String locOperator, int cycloThreeshold, String cycloOperator,
			String longMethodOperator, int atfdThreeshold, String atfdOperator, int laaThreeshold, String laaOperator,
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

	// construtor quando só se tem 1 métrica
	public Rule(int threeshold, String operator, String metricOption) {

		switch (metricOption) {

		case "loc":
			this.locThreeshold = threeshold;
			this.locOperator = operator;
			break;

		case "cyclo":
			this.cycloThreeshold = threeshold;
			this.cycloOperator = operator;
			break;

		case "atfd":
			this.atfdThreeshold = threeshold;
			this.atfdOperator = operator;
			break;

		case "laa":
			this.laaThreeshold = threeshold;
			this.laaOperator = operator;
			break;
		}
	}

	// construtor quando se tem tudo LM ou tudo FE
	public Rule(String rule, int metric1Threeshold, String metric1Operator, String metric2, int metric2Threeshold,
			String metric2Operator, String ruleOperator) {

		switch (rule) {

		case "longMethod":
			this.locThreeshold = metric1Threeshold;
			this.locOperator = metric1Operator;
			this.cycloThreeshold = metric2Threeshold;
			this.cycloOperator = metric2Operator;
			this.longMethodOperator = ruleOperator;
			break;

		case "featureEnvy":
			this.atfdThreeshold = metric1Threeshold;
			this.atfdOperator = metric1Operator;
			this.laaThreeshold = metric2Threeshold;
			this.laaOperator = metric2Operator;
			this.featureEnvyOperator = ruleOperator;
			break;
		}
	}

	// construtor quando se tem 2 metricas
	public Rule(String metric1, int metric1Threeshold, String metric1Operator, String metric2, int metric2Threeshold,
			String metric2Operator) {

		switch (metric1) {

		case "loc":
			this.locThreeshold = metric1Threeshold;
			this.locOperator = metric1Operator;
			break;

		case "cyclo":
			this.cycloThreeshold = metric1Threeshold;
			this.cycloOperator = metric1Operator;
			break;

		case "atfd":
			this.atfdThreeshold = metric1Threeshold;
			this.atfdOperator = metric1Operator;
			break;

		case "laa":
			this.laaThreeshold = metric1Threeshold;
			this.laaOperator = metric1Operator;
			break;
		}

		switch (metric2) {

		case "loc":
			this.locThreeshold = metric2Threeshold;
			this.locOperator = metric2Operator;
			break;

		case "cyclo":
			this.cycloThreeshold = metric2Threeshold;
			this.cycloOperator = metric2Operator;
			break;

		case "atfd":
			this.atfdThreeshold = metric2Threeshold;
			this.atfdOperator = metric2Operator;
			break;

		case "laa":
			this.laaThreeshold = metric2Threeshold;
			this.laaOperator = metric2Operator;
			break;
		}
	}

	// construtor quando se tem 3 metricas
	public Rule(String metric1, int metric1Threeshold, String metric1Operator, String metric2, int metric2Threeshold,
			String metric2Operator, String metric3, int metric3Threeshold, String metric3Operator, String ruleOperator,
			String rule) {

		if (rule == "longMethod") {

			switch (metric1) {

			case "loc":
				this.locThreeshold = metric1Threeshold;
				this.locOperator = metric1Operator;
				break;

			case "cyclo":
				this.cycloThreeshold = metric1Threeshold;
				this.cycloOperator = metric1Operator;
				break;

			default:
				break;
			}

			switch (metric2) {

			case "loc":
				this.locThreeshold = metric2Threeshold;
				this.locOperator = metric2Operator;
				break;

			case "cyclo":
				this.cycloThreeshold = metric2Threeshold;
				this.cycloOperator = metric2Operator;
				break;

			default:
				break;
			}

			switch (metric3) {

			case "loc":
				this.locThreeshold = metric3Threeshold;
				this.locOperator = metric3Operator;
				break;

			case "cyclo":
				this.cycloThreeshold = metric3Threeshold;
				this.cycloOperator = metric3Operator;
				break;

			default:
				break;
			}
		}

		else if (rule == "featureEnvy") {

			switch (metric1) {

			case "atfd":
				this.atfdThreeshold = metric1Threeshold;
				this.atfdOperator = metric1Operator;
				break;

			case "laa":
				this.laaThreeshold = metric1Threeshold;
				this.laaOperator = metric1Operator;
				break;

			default:
				break;
			}

			switch (metric2) {

			case "atfd":
				this.atfdThreeshold = metric2Threeshold;
				this.atfdOperator = metric2Operator;
				break;

			case "laa":
				this.laaThreeshold = metric2Threeshold;
				this.laaOperator = metric2Operator;
				break;

			default:
				break;
			}

			switch (metric3) {

			case "atfd":
				this.atfdThreeshold = metric3Threeshold;
				this.atfdOperator = metric3Operator;
				break;

			case "laa":
				this.laaThreeshold = metric3Threeshold;
				this.laaOperator = metric3Operator;
				break;

			default:
				break;
			}
		}
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

	public int getLaaThreeshold() {
		return laaThreeshold;
	}

	public void setLaaThreeshold(int laaThreeshold) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("REGRAS - " + "LOC " + locOperator + " " + locThreeshold + " " + longMethodOperator + " " + "CYCLO "
				+ cycloOperator + " " + cycloThreeshold + "; " + "ATFD " + atfdOperator + " " + atfdThreeshold + " "
				+ featureEnvyOperator + " " + "LAA " + laaOperator + " " + laaThreeshold + "\n");

		return sb.toString();
	}

	public void addRuleToList(List<Rule> savedRules) {
		savedRules.add(this);
		
		for (Rule rule : savedRules) 
			System.out.println(rule.toString());
			
	}
}
