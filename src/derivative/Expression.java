package derivative;

import java.util.ArrayList;
import java.util.List;

public class Expression extends Term{
	private List<Term> termList = new ArrayList<Term>();

	@Override
	public void putOnStack(Term calc) {
		termList.add(calc);
		
	}
	
	
	@Override
	public void clearList(){
		termList.clear();
	}
	

	@Override
	public Term getOriginalTerm() {
		boolean var = false;
		double fac = 1.0, exp = 0.0;
		Multiplier t = new Multiplier(0,false,0,false);
		
		if (!termList.isEmpty()) {
			
			for (Term calc : termList) {
				t = (Multiplier)calc;
				fac = fac * t.getFactor();
				exp = exp + t.getExponent();
				if (t.getVariable()) {
					var = true;
				}
			}
			if (exp == 0.0)
				var = false;
			if (fac != 0.0){
					return new Multiplier(fac, var, exp, t.hasExpression);
			}
				
		}
		return null;
	}

	
	@Override
	public Term getDerivativeOfTerm() {
		List<Multiplier> erg = new ArrayList<Multiplier>();
		Multiplier[][] solid = new Multiplier[termList.size()][termList.size()];

		for (int i = 0; i < termList.size(); i++) {
			for (int j = 0; j < termList.size(); j++) {
				if (i == j) {
					solid[i][j] = (Multiplier)termList.get(j).getDerivativeOfTerm();
				} else {
					solid[i][j] = (Multiplier)termList.get(j).getOriginalTerm();
				}
			}
		}

		erg = multiply(solid);
		return summing(erg);
		

	}

	private List<Multiplier> multiply(Multiplier[][] trm) {
		double factor, exponent;
		Multiplier erg = null;
		List<Multiplier> ls = new ArrayList<Multiplier>();
		
		for (Multiplier[] t : trm) {
			erg = new Multiplier(1.0, true, 0.0, isExpression());
			factor = erg.getFactor();
			exponent = erg.getExponent();
			
			for (Multiplier p : t) {
				factor *= p.getFactor();
				exponent += p.getExponent();
			}

			erg.setFactor(factor);
			erg.setExponent(exponent);
			
			if (exponent == 0.0) {
				erg.setVariable(false);
			}

			ls.add(erg);
			erg = null;
		}
		
		return ls;

	}

	private Multiplier summing(List<Multiplier> ls) {
		double factor, exponent;
		Multiplier temp = new Multiplier(0.0, true, 1.0, isExpression());

		factor = temp.getFactor();
		exponent = temp.getExponent();
		
		for (int i = 0; i < ls.size(); i++) {
			factor = factor + ls.get(i).getFactor();
			exponent = ls.get(i).getExponent();
		}

		
		if (factor != 0.0) {
			return new Multiplier(factor, true, exponent, isExpression());
		}
		else{
			return null;
		}
	}

}
