package uo.mp.minesweeper.model.square;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.square.actions.ClearAction;
import uo.mp.minesweeper.game.square.actions.NullAction;
import uo.mp.minesweeper.session.GameException;
import uo.mp.minesweeper.square.Square;
import uo.mp.minesweeper.square.SquareState;

public class StepOnTests {

	Square square;
	
	@BeforeEach
	public void setUp() {
		square = new Square(1, SquareState.CLOSED);  //closed y valor 1 (con pista)
		square.setAction(new NullAction()); //se establece su acción (no hace nada)
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
	 * THEN GameException and the square remains opened
	 * @throws GameException 
	 */
	@Test
	public void stepOnOpenedSquare() throws GameException {
		square.open();
		try {
			square.stepOn();
		} catch (GameException e) {
			assertTrue(square.isOpened());
		}
	}
	
	/**
	 * 2.
	 * GIVEN closed square
	 * WHEN stepOn()
	 * THEN the square changes to opened
	 * @throws GameException 
	 */
	@Test
	public void stepOnClosedSquare() throws GameException {
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * 3.
	 * GIVEN flagged square
	 * WHEN stepOn()
	 * THEN the square remains flagged
	 * @throws GameException 
	 */
	@Test
	public void stepOnFlaggedSquare() throws GameException {
		square.flag();  //por defecto estaba closed: cambia a flagged
		square.stepOn();
		assertTrue(square.isFlagged());
	}
	
	
}
