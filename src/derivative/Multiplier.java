package derivative;

public class Multiplier extends Term {
	private double factor = 1.0;
	private boolean variable = true;
	private double exponent = 1.0;
	private String expression = "";
	

	public Multiplier(double faktor, boolean variable, double exp,
			boolean isexpression) {
		hasExpression = isexpression;
		this.factor = faktor;
		this.variable = variable;
		this.exponent = exp;

	}

	public Multiplier(String faktor, String var, String exponent, boolean isexpression) {
		hasExpression = isexpression;

		if (faktor != "") {
			this.factor = Double.parseDouble(faktor);
		}

		if (var == "") {
			this.variable = false;
			this.exponent = 0.0;
		}

		if (exponent != "") {
			this.exponent = Double.parseDouble(exponent);
		}

	}

	@Override
	public Term getOriginalTerm() {
		return new Multiplier(this.factor, this.variable, this.exponent,
				hasExpression);
	}

	@Override
	public Term getDerivativeOfTerm() {
		double new_faktor;
		boolean new_variable;
		double new_potenz;

		new_faktor = factor * exponent;
		new_potenz = exponent - 1;

		if (new_potenz == 0 || new_faktor == 0) {
			new_variable = false;
		} else {
			new_variable = variable;
		}

		return new Multiplier(new_faktor, new_variable, new_potenz, hasExpression);

	}

	@Override
	public String toString() {
		String erg = "";

		if (variable == true) {
			if (exponent == 0.0) {
				erg = erg + factor + "";
			} else if (exponent == 1.0) {
				erg = erg + factor + "x";
			} else {
				erg = erg + factor + expression + "^" + exponent;
			}
		} else {
			erg = erg + factor;
		}

		return erg;

	}

	public double getFactor() {
		return factor;
	}

	public double getExponent() {
		return exponent;
	}

	public boolean getVariable() {
		return this.variable;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public void setExponent(double exp) {
		this.exponent = exp;
	}

	public void setVariable(boolean value) {
		this.variable = value;
	}
	
	public void setExpression(String expr){
		this.expression = expr;
	}

}
