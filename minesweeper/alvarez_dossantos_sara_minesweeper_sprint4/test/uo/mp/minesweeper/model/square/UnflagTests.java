package uo.mp.minesweeper.model.square;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.session.GameException;
import uo.mp.minesweeper.square.Square;

public class UnflagTests {

    Square square;
	
	@BeforeEach
	public void setUp() {
		square = new Square();  //por defecto: closed y valor 0 (empty)
	}
	
	/**
	 * Casos de uso:
	 * 1. Unflag() en casilla OPENED
	 * 2. Unflag() en casilla CLOSED
	 * 3. Unflag() en casilla FLAGGED
	 */
	
	/**
	 * 1.
	 * GIVEN opened square
	 * WHEN unflag()
	 * THEN the square remains opened
	 * @throws GameException 
	 */
	@Test
	public void unflagOpenedSquare() throws GameException {
		square.open();
		square.unflag();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 2.
	 * GIVEN closed square
	 * WHEN unflag()
	 * THEN the square remains closed
	 */
	@Test
	public void unflagClosedSquare() {
		square.unflag();
		assertFalse(square.isOpened());
	}
	
	/**
	 * 3.
	 * GIVEN flagged square
	 * WHEN unflag()
	 * THEN the square changes to closed
	 * @throws GameException 
	 */
	@Test
	public void unflagFlaggedSquare() throws GameException {
		square.flag();  //por defecto estaba closed: cambia a flagged
		square.unflag();
		assertFalse(square.isOpened());  //la casilla debe estar closed
	}
}
