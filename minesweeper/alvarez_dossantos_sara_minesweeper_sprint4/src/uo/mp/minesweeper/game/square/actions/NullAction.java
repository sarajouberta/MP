package uo.mp.minesweeper.game.square.actions;

public class NullAction implements Action{

	/**
	 * Clase que implementa la funcionalidad NullAction: la casilla asociada a esta acción
	 * no hace nada cuando la llamada a stepOn sobre esta, a su vez, llama a execute().
	 */
	@Override
	public void execute() {
	}

}
