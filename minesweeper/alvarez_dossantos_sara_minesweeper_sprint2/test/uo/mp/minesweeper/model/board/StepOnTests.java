package uo.mp.minesweeper.model.board;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class StepOnTests {

	Board board;
	
	/**
	 * Casos de uso:
	 * 1. Casilla ya descubierta: no hace nada
	 * 2. Casilla con bandera con mina: destapa correctamente
	 * 3. Casilla con bandera sin mina: destapa correctamente
	 * 4. Casilla con mina: destapa correctamente
	 * 5. Casilla con pista numérica: destapa correctamente
	 * 6. Casilla vacía: destapa correctamente
	 * 
	 */
	
	/**
	 * 1.
	 * GIVEN Casilla ya descubierta
	 * WHEN stepOn()
	 * THEN no hace nada
	 */
	@Test
	public void stepOnOpenedSquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixTwoMines);
		board = new Board(2, ts);  //tablero con dos minas y dos banderas
		board.unveil();  //se destapa todo el tablero
		board.stepOn(0, 0); //se intenta destapar una casilla ya destapada
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[0][0].isOpened());  //se comprueba que la posición establecida tiene bandera
		
	}
	
	/**
	 * 2.
	 * GIVEN Casilla con bandera con mina
	 * WHEN stepOn()
	 * THEN destapa la casilla correctamente
	 */
	@Test
	public void stepOnFlaggedMineSquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero 1 mina y 1 bandera
		board.flag(1, 1); //se marca la casilla con bandera
		board.stepOn(1, 1); //se destapa la casilla con bandera
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[1][1].isOpened());  //se comprueba que la posición establecida está destapada
		
	}
	
	/**
	 * 3.
	 * GIVEN Casilla con bandera sin mina
	 * WHEN stepOn()
	 * THEN destapa la casilla correctamente
	 */
	@Test
	public void stepOnFlaggedEmptySquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero 1 mina y 1 bandera
		board.stepOn(0, 0); //se destapa una casilla sin mina
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[0][0].isOpened());  //se comprueba que la posición establecida está destapada
		
	}
	
	/**
	 * 4.
	 * GIVEN Casilla con mina
	 * WHEN stepOn()
	 * THEN destapa la casilla correctamente
	 */
	@Test
	public void stepOnMineSquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero 1 mina y 1 bandera
		board.stepOn(1, 1); //se destapa la casilla con  mina
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[1][1].isOpened());  //se comprueba que la posición establecida está destapada
		
	}
	
	/**
	 * 5.
	 * GIVEN  Casilla con pista numérica
	 * WHEN stepOn()
	 * THEN destapa la casilla correctamente
	 */
	@Test
	public void stepOnSquareWithClue() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero 1 mina y 1 bandera
		board.stepOn(0, 0); //se destapa una casilla con pista numérica
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[0][0].isOpened());  //se comprueba que la posición establecida está destapada
		
	}
	
	/**
	 * 6.
	 * GIVEN Casilla vacía
	 * WHEN stepOn()
	 * THEN destapa la casilla correctamente
	 */
	@Test
	public void stepOnEmptySquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero 1 mina y 1 bandera
		board.stepOn(0, 4); //se destapa una casilla sin pista numérica
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[0][4].isOpened());  //se comprueba que la posición establecida está destapada
		
	}
}
