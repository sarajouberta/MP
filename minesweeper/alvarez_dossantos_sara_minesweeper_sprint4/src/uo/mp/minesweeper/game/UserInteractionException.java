package uo.mp.minesweeper.game;

@SuppressWarnings("serial")
public class UserInteractionException extends Exception{
	
	private char op;
	
	public UserInteractionException(char op, String msg) {
		super(msg);
		//ArgumentChecks.isTrue();
		this.op = op;
	}
	
	@Override
	public String getMessage() {
		return "INVALID OPTION" + op + super.getMessage();
	}
	
}
