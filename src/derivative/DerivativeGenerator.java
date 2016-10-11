package derivative;


public class DerivativeGenerator implements TermCreator{
	private String output = "";

	@Override
	public void createTerm(Multiplier dterm) {
		if(output.isEmpty()){
			output += dterm.toString();
		}else{
			if(dterm.getFactor() < 0){
				double d = dterm.getFactor();
				d += -1.0;
				dterm.setFactor(d);
				output += "-" + dterm.toString();
			}else{
				output += "+" + dterm.toString();
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
		if(!expression.isEmpty()){
			output += expression;
		}
	}
	
	@Override
	public String getOutputString(){
		return output;
	}

}
