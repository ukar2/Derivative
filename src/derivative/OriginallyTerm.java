package derivative;


public class OriginallyTerm implements TermCreator{
	private String output = "";
	
	@Override
	public void createTerm(Multiplier term){
		if(output.isEmpty()){
			output += term.toString();
		}else{
			if(term.getFactor() < 0){
				double d = term.getFactor();
				d += -1.0;
				term.setFactor(d);
				output += "-" + term.toString();
			}else{
				output += "+" + term.toString();
			}
		}		
	}
	
	@Override
	public void setPlus(){
		output += "+";
	}
	
	@Override
	public void setMinus(){
		output += "-";
	}
	
	@Override
	public void set(String expression){
		
	}
	
	@Override
	public String getOutputString(){
		return output;
	}
	
}
