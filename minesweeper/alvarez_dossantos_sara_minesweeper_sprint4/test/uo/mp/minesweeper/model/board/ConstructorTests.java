package uo.mp.minesweeper.model.board;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import uo.mp.minesweeper.game.Board;

public class ConstructorTests {

	Board board;

	/**
	 * Casos de uso:
	 * 1. Height below limit: IllegalArgumentException
	 * 2. Width below limit: IllegalArgumentException
	 * 3. Percentage below limit: IllegalArgumentException
	 * 4. Percentage beyond limit: IllegalArgumentException
	 * 5. One wrong parameter: IllegalArgumentException
	 * 6: Valid parameters: creates the Board correctly
	 * 
	 */
	
	/**
	 * 1.
	 * GIVEN wrong parameter (height)
	 * WHEN Board(int height, int width, int percentage)
	 * THEN IllegalArgumentException
	 */
	@Test
	public void boardHeigtBelowLimit() {
		try {
			board = new Board(0, 9, 12);
			fail("Exception expected");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid height", e.getMessage());
		}
	}
	
	
	/**
	 * 2.
	 * GIVEN wrong parameter (width)
	 * WHEN Board(int height, int width, int percentage)
	 * THEN IllegalArgumentException
	 */
	@Test
	public void boardWidthBelowLimit() {
		try {
			board = new Board(9, 0, 12);
			fail("Exception expected");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid width", e.getMessage());
		}
	}
	
	
	/**
	 * 4.
	 * GIVEN wrong parameter (percentage below limit)
	 * WHEN Board(int height, int width, int percentage)
	 * THEN IllegalArgumentException
	 */
	@Test
	public void boardPercentageBelowLimit() {
		try {
			board = new Board(9, 9, 0);
			fail("Exception expected");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid percentage", e.getMessage());
		}
	}
	
	/**
	 * 5.
	 * GIVEN wrong parameter (percentage beyond limit)
	 * WHEN Board(int height, int width, int percentage)
	 * THEN IllegalArgumentException
	 */
	@Test
	public void boardPercentageBeyondLimit() {
		try {
			board = new Board(9, 9, 101);
			fail("Exception expected");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid percentage", e.getMessage());
		}
	}
	
	
	/**
	 * 6.
	 * GIVEN all correct parameters
	 * WHEN Board(int height, int width, int percentage)
	 * THEN board with atributte values given as parameters
	 */
	@Test
	public void boardValidParameters() {
		board = new Board(9,9,12);  //se crea tablero con valores por defecto
		assertEquals(9,board.getHeight()); 
		assertEquals(9,board.getWidth());
		assertEquals(10 ,board.getNumberOfFlagsLeft()); //tiene 10 banderas (10 minas)
	}
	
	
	
	
}
