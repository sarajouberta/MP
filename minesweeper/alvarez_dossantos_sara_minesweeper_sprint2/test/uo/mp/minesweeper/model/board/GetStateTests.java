package uo.mp.minesweeper.model.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class GetStateTests {

	Board board;
	
	/**
	 * Casos de uso:
	 * 1. Tablero completamente cubierto: devuelve tablero lleno de '#'
	 * 2: Tablero completamente descubierto: devuelve tablero con el estado de cada casilla
	 * 3. Tablero en situación de juego intermedia: devuelve tablero con el estado de cada
	 *    casilla
	 */
	
	/**
	 * 1.
	 * GIVEN Tablero completamente cubierto
	 * WHEN getState()
	 * THEN tablero lleno de '#'
	 */
	@Test
	public void getStateClosedBoard() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		char[][] aux = board.getState(); 
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				assertEquals('#', aux[i][j]);
			}
		}
	}
	
	/**
	 * 2.
	 * GIVEN Tablero completamente descubierto
	 * WHEN getState()
	 * THEN se muestra el estado de cada casilla correctamente
	 */
	@Test
	public void getStateOpenedBoard() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		board.unveil();
		char[][] aux = board.getState(); 
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				assertEquals(TestUtil.stateOpenedOneMine[i][j], aux[i][j]);
			}
		}
	}
	
	/**
	 * 3.
	 * GIVEN Tablero en estado intermedio de juego (closed/opened/flagged)
	 * WHEN getState()
	 * THEN se muestra el estado de cada casilla correctamente:
			{'¶','#','1',' ',' '},
			{'1','#','1',' ',' '},
			{'1','1','1',' ',' '},
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '}
	 */
	@Test
	public void getStateMiddleGameBoard() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		//se pone el tablero en un estado mixto:
		board.flag(0, 0);   //se pone una bandera
		board.stepOn(1, 0);  //se destata una casilla con pista
		board.stepOn(0, 4);  //se destapa una casilla vacía: destapa casillas vecinas
		char[][] aux = board.getState(); 
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				assertEquals(TestUtil.stateMixedOneMine[i][j], aux[i][j]);
			}
		}
	}
	
	
	
	
	
	
	
}
