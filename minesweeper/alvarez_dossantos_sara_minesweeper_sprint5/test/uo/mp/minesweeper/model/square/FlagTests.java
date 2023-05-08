package uo.mp.minesweeper.model.square;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.session.GameException;
import uo.mp.minesweeper.square.Square;

public class FlagTests {

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
	public void flagOpenedSquare() throws GameException {
		square.open();  //default:closed
		square.flag();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 2.
	 * GIVEN closed square
	 * WHEN flag()
	 * THEN the square change
	 * @throws GameException 
	 */
	@Test
	public void flagClosedSquare() throws GameException {
		square.flag();  //default: closed
		assertTrue(square.isFlagged());
	}
	
	/**
	 * 3.
	 * GIVEN flagged square
	 * WHEN flag()
	 * THEN GameException and the square remains flagged
	 * @throws GameException 
	 */
	@Test
	public void flagFlaggedSquare() throws GameException {
		square.flag();  //default: closed 
		try {
			square.flag();
		} catch (GameException e) {
			assertTrue(square.isFlagged());  //square must be flagged
		}  
	}
}
