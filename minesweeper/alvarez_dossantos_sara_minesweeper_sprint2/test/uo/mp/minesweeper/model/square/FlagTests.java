package uo.mp.minesweeper.model.square;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.model.Square;

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
	 */
	@Test
	public void flagOpenedSquare() {
		square.open();  //default:closed
		square.flag();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 2.
	 * GIVEN closed square
	 * WHEN flag()
	 * THEN the square change
	 */
	@Test
	public void flagClosedSquare() {
		square.flag();  //default: closed
		assertTrue(square.isFlagged());
	}
	
	/**
	 * 3.
	 * GIVEN flagged square
	 * WHEN flag()
	 * THEN the square remains flagged
	 */
	@Test
	public void flagFlaggedSquare() {
		square.flag();  //default: closed 
		square.flag();  
		assertTrue(square.isFlagged());  //square must be flagged
	}
}
