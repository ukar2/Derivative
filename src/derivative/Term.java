package derivative;

public abstract class Term {
	protected boolean hasExpression;
	
	public abstract Term getOriginalTerm();
	public abstract Term getDerivativeOfTerm();
	
	public void putOnStack(Term calc){
		
	}
	
	public void clearList(){
		
	}
	
	public boolean isExpression(){
		return this.hasExpression;
	}
	
	public void isExpression(boolean isexpression){
		this.hasExpression = isexpression;
	}

}
