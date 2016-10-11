package derivative;

public abstract class Worker {
	TermCreator tc;
	
	public void setTermCreator(TermCreator tc){
		this.tc = tc;
	}
	
	public void createTerm(Multiplier term){
		tc.createTerm(term);
	}
	
	public abstract void createTerm(String originally);
	public abstract void addNewTerm(Multiplier mltp);
	public abstract void set(String expr);
	public abstract void setVorzeichen(String s);
	public abstract String getOriginallyExpression();
	public abstract String getDerivativeExpression();

}
