package uo.mp.minesweeper.model.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.square.Square;

public class UncoverWelcomeAreaTests {

	Board board;
	
	/**
	 * Caso 1:
	 * Situación inicial del tablero:
	 * -110
	 *  110
	 *  000
	 *  En este caso, hay que comprobar que todas las casillas están
	 *  abiertas excepto la posición (0,0).
	 *  
	 *  Caso 2:
	 *  Situación inicial del tablero:
	 *  -1 1 0 2 -1 2
	 *   1 1 0 3 -1 3
	 *   0 0 0 2 -1 2
	 *  En este caso, hay que comprobar qué casillas quedan abiertas y cuales 
	 *  quedan cerradas.
	 */
	
	@Test
	public void uncoverWelcomeArea3x3OneMine() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrix3x3_unveil_welcome);
		board = new Board(1, ts);  //tablero con dos minas
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		board.uncoverWelcomeArea();
		char[][] aux = board.getState();  //se obtiene el estado de todas las casillas del tablero
		for (int i = 0; i < board.getNumberOfRows(); i++) {
			for (int j = 0; j <board.getNumberOfColumns(); j++) {
				assertEquals(aux[i][j], TestUtil.state3x3_unveil_welcome[i][j]);
			}
		}
	}
	
	@Test
	public void uncoverWelcomeArea6x3FourMines() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrix6x3_unveil_welcome);
		board = new Board(4, ts);  //tablero con 4 minas
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		board.uncoverWelcomeArea();
		char[][] aux = board.getState();  //se obtiene el estado de todas las casillas del tablero
		for (int i = 0; i < board.getNumberOfRows(); i++) {
			for (int j = 0; j <board.getNumberOfColumns(); j++) {
				assertEquals(aux[i][j], TestUtil.state6x3_unveil_welcome[i][j]);
			}
		}
	}
}
