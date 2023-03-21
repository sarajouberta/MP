package uo.mp.minesweeper.model.square;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.model.Square;

public class StepOnTests {

	Square square;
	
	@BeforeEach
	public void setUp() {
		square = new Square();  //por defecto: closed y valor 0 (empty)
	}
	
	/**
	 * Casos de uso:
	 * 1. stepOn() en casilla OPENED
	 * 2. stepOn() en casilla CLOSED
	 * 3. stepOn() en casilla FLAGGED
	 */
	
	/**
	 * 1.
	 * GIVEN opened square
	 * WHEN stepOn()
	 * THEN the square remains opened
	 */
	@Test
	public void stepOnOpenedSquare() {
		square.open();
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 2.
	 * GIVEN closed square
	 * WHEN stepOn()
	 * THEN the square changes to opened
	 */
	@Test
	public void stepOnClosedSquare() {
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 3.
	 * GIVEN flagged square
	 * WHEN stepOn()
	 * THEN the square remains flagged
	 */
	@Test
	public void stepOnFlaggedSquare() {
		square.flag();  //por defecto estaba closed: cambia a flagged
		square.stepOn();
		assertTrue(square.isFlagged());
	}
	
	
}
