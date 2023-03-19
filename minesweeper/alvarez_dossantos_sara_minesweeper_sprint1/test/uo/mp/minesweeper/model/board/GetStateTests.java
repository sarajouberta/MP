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
	 * THEN se muestra el estado de cada casilla correctamente
	 */
	@Test
	public void getStateMiddleGameBoard() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		//se pone el tablero en un estado mixto:
		board.flag(0, 0);
		for (int i = 1; i < ts.length; i++) {
			for (int j = 0; j < ts[0].length; j++) {
				board.stepOn(i, j);  //se destapa tood el tablero menos la primera fila
			}	
		}
		char[][] aux = board.getState(); 
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				assertEquals(TestUtil.stateMixedOneMine[i][j], aux[i][j]);
			}
		}
	}
	
	
	
	
	
	
	
}
