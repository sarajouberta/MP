package uo.mp.minesweeper.model.board;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.square.Square;
import uo.mp.minesweeper.square.SquareState;

public class UnveilTests {
	
	Board board;
	
	/**
	 * Casos de uso:
	 * 1. Tablero con casillas closed: se destapan todas las casillas
	 * 2: Tablero con casilla flagged: se destapan todas las casillas
	 * 3. Tablero con casillas opened: se destapan las cubiertas
	 */
	
	/**
	 * 1.
	 * GIVEN Tablero con casillas closed
	 * WHEN unveil()
	 * THEN se destapan todas las casillas 
	 */
	@Test
	public void unveilClosedBoard() {
		Square[][] testSquares = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, testSquares);  //se llama al constructor para tests
		board.unveil();
		Square[][] resultSquares = board.getSquares();  //se guarda el estado del tablero
		boolean  allOpened = true;  //variable para comparar que todas las casillas están abiertas
		for (int i = 0; i < resultSquares.length; i++) { 
			for (int j = 0; j < resultSquares[0].length; j++) {
				allOpened = allOpened && resultSquares[i][j].isOpened(); //en el momento que una no esé abierta: false.equals(SquareState.OPENED);
			}
		}
		assertTrue(allOpened);
	}
	
	/**
	 * 2.
	 * GIVEN tablero con casilla flagged
	 * WHEN unveil()
	 * THEN tablero con todas las casillas destapadas
	 */
	@Test
	public void unveilOneFlag() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);
		board.flag(1, 1); //se pone bandera sobre la mina
		board.unveil();
		Square[][] resultSquares = board.getSquares();  //se guarda el estado del tablero
		boolean  allOpened = true;  //variable para comparar que todas las casillas están abiertas
		for (int i = 0; i < resultSquares.length; i++) { 
			for (int j = 0; j < resultSquares[0].length; j++) {
				allOpened = allOpened && resultSquares[i][j].isOpened(); //en el momento que una no esé abierta: false.equals(SquareState.OPENED);
			}
		}
		assertTrue(allOpened);
		
	}
	
	/**
	 * 3.
	 * GIVEN tablero con casillas destapadas
	 * WHEN unveil()
	 * THEN tablero con todas las casillas destapadas
	 */
	@Test
	public void unveilWithOpenedSquares() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixBase);
		board = new Board(0, ts);
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		
		for (int i = 0; i < ts.length; i++) {
			board.stepOn(i, i);  //se abre la diagonal del tablero
		}
		Square[][] resultSquares = board.getSquares();  //se guarda el estado del tablero
		board.unveil();
		boolean  allOpened = true;  //variable para comparar que todas las casillas están abiertas
		for (int i = 0; i < resultSquares.length; i++) { 
			for (int j = 0; j < resultSquares[0].length; j++) {
				allOpened = allOpened && resultSquares[i][j].getSquareState() //en el momento que una no esé abierta: false
						.equals(SquareState.OPENED);
			}
		}
		assertTrue(allOpened);
	}

}
