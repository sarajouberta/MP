package uo.mp.minesweeper.model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.session.GameException;
import uo.mp.minesweeper.square.Square;

public class FlagTests {
	
	Board board;
	
	/**
	 * Casos de uso:
	 * 1. Bandera sobre casilla ya marcada: no cambia de estado
	 * 2: Bandera sobre casilla desmarcada de mina: no cambia de estado
	 * 3. Bandera sobre casilla desmarcada sin mina: no cambia de estado
	 * 4. Bandera sobre casilla dos veces consecutivas: marca la casilla la primera llamada
	 */	

	/**
	 * 1.
	 * GIVEN tablero con minas y banderas
	 * WHEN flag() sobre casilla con bandera
	 * THEN GameException y la casilla sigue marcada con bandera
	 * @throws GameException 
	 */
	@Test
	public void flagFlaggedSquare() throws GameException{
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixTwoMines);
		board = new Board(2, ts);  //tablero con dos minas y dos banderas
		board.flag(0, 0);
		try {
			board.flag(0, 0);  //se intenta llamar al método sobre una casilla con bandera
		}catch(GameException e){
			Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
			assertEquals(1, board.getNumberOfFlagsLeft());  //se comprueba que solo queda 1 bandera
			assertTrue(aux[0][0].isFlagged());  //se comprueba que la posición establecida tiene bandera
		}
	}
	
	/**
	 * 2.
	 * GIVEN casilla desmarcada de mina
	 * WHEN flag()
	 * THEN la casilla pasa a estar marcada con bandera
	 * @throws GameException 
	 */
	@Test
	public void flagUnflaggedMineSquare() throws GameException{
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		board.flag(1, 1); //se marca la casilla con la mina 
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertEquals(0, board.getNumberOfFlagsLeft());  //se comprueba que no quedan banderas
		assertTrue(aux[1][1].isFlagged());  //se comprueba que la posición establecida tiene bandera
		
	}
	
	/**
	 * 3.
	 * GIVEN casilla desmarcada sin mina
	 * WHEN flag()
	 * THEN la casilla pasa a estar marcada con bandera
	 * @throws GameException 
	 */
	@Test
	public void flagUnflaggedEmptySquare() throws GameException{
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina y una bandera
		board.flag(0, 0); //se marca una casilla sin mina 
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertEquals(0, board.getNumberOfFlagsLeft());  //se comprueba que sigue quedando 1 bandera
		assertFalse(aux[1][1].isFlagged());  //se comprueba que la posición establecida no tiene bandera	
	}
	
	
	/**
	 * 4.
	 * GIVEN casilla con mina sin bandera
	 * WHEN flag()
	 * THEN la casilla pasa a estar marcada con bandera
	 * @throws GameException 
	 */
	@Test
	public void flagTwoTimes() throws GameException{
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixTwoMines);
		board = new Board(2, ts);  //tablero con dos minas y dos banderas
		board.flag(1, 1); //se marca una casilla con mina 
			try {
				board.flag(1, 1); //se vuelve a marcar la misma casilla
			} catch (GameException e) {
				Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
				assertTrue(aux[1][1].isFlagged());  //se comprueba que la posición establecida tiene bandera	
			}
			assertEquals(1, board.getNumberOfFlagsLeft());  //se comprueba que queda 1 andera
	}
	
	
	
	
	
	
	
	
	
	
}
