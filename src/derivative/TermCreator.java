package derivative;

public interface TermCreator {
	
	public void createTerm(Multiplier term);
	public void setPlus();
	public void setMinus();
	public void set(String expression);
	public String getOutputString();

}
