package derivative;

public class Calculator extends Worker{
	Term term = new Expression();
	TermCreator dg = new DerivativeGenerator();
	TermCreator ot = new OriginallyTerm();
	
	
	// 1.
	public void addNewTerm(Multiplier mltp){
		term.putOnStack(mltp);
	}
	
	
	// 2.
	public void createTerm(String originally){
		setTermCreator(dg);
		Multiplier mltp = (Multiplier)term.getDerivativeOfTerm();
		mltp.setExpression(originally);
		tc.createTerm(mltp);
		
		setTermCreator(ot);
		mltp = null;
		mltp = (Multiplier)term.getOriginalTerm();
		tc.createTerm(mltp);
		
		term.clearList();
	}
	
	
	// 4.
	public void setVorzeichen(String s){
		setTermCreator(dg);
		if(s == "+")
			tc.setPlus();
		else
			tc.setMinus();
		
		setTermCreator(ot);
		if(s == "+")
			tc.setPlus();
		else
			tc.setMinus();
	}
	
	public String getOriginallyExpression(){
		setTermCreator(ot);
		
		return ot.getOutputString();
	}
	
	public String getDerivativeExpression(){
		setTermCreator(dg);
		
		return dg.getOutputString();
	}
	
	
	// 3.
	public void set(String expr){
		dg.set(expr);
		
	}

}
