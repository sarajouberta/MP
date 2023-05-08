package uo.mp.minesweeper.session;

@SuppressWarnings("serial")
public class GameException extends Exception{


	public GameException(String msg) {
		super(msg);
		//ArgumentChecks.isTrue();
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
