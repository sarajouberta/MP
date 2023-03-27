package uo.mp.minesweeper.game.square.actions;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.model.Board;

public class BlowUpAction implements Action{
	
	private Board board;  //tablero asociado a la acción BlowUp

	/**
	 * Clase que señala el tablero como explotado cuando se descubre una casilla con mina.
	 * Será asociada a una casilla con mina.
	 */
	
	
	/**
	 * Constructor que recibe un objeto board y apunta a la instancia del tablero que contiene la casilla
	 * a la que se asocia esta acción
	 * @param board
	 */
	public BlowUpAction(Board board) {
		ArgumentChecks.isTrue(board != null, "Invalid board");
		this.board = board;
	}
	
	/**
	 * Provoca que el tablero se marque como explotado.
	 */
	@Override
	public void execute() {
		board.markAsExploded();
	}

	
}
