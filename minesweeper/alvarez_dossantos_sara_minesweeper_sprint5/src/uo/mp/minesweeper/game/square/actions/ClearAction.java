package uo.mp.minesweeper.game.square.actions;

import java.util.List;

import uo.mp.minesweeper.session.GameException;
import uo.mp.minesweeper.square.Square;

public class ClearAction implements Action{

	private List<Square>  neighbours; //lista de casillas vecinas

	/**
	 * Clase que implementa la funcionalidad ClearAction: cuando se ejecuta stepOn sobre 
	 * una casilla con esta acción, a su vez, se propaga la llamada a stepOn de las casillas
	 * vecinas
	 */
	
	/**
	 * COnstructor de ClearAction
	 * @param neighbours lista de casillas vecinas
	 */
	public ClearAction(List<Square> neighbours) {
		this.neighbours = neighbours;
	}	
	
	/**
	 * Cuando se ejecuta, se llama al método stepOn de las casillas vecinas
	 * @throws GameException 
	 */
	@Override
	public void execute() throws GameException {
		for(Square neighbour : neighbours) {
			if(!neighbour.isOpened()) {
				neighbour.stepOn();	
			}
			
		}
	}

}
