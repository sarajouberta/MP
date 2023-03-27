package uo.mp.minesweeper.game.square.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.square.Square;

public class ExecuteBlowUpActionTest {

	Board board;
	
	/**
	 * EXECUTE()
	 * 
	 * Casos de uso: casilla con acción BlowUpAction:
	 * se ejecuta execute(), dejando la casilla abierta y el tablero marcado como
	 * explotado
	 * 
	 */
	
	/**
	 * GIVEN stepOn sobre casilla con mina (casilla con blowUp action asociada)
	 * WHEN execute()
	 * THEN casilla destapada y tablero ha explotado (fin partida)
	 * 
	 */
	@Test
	public void executeClearSquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixOneMine);
		board = new Board(1, ts);  //tablero con una mina en [1,1]
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		board.stepOn(1, 1); //stepOn llama al execute de la acción que tiene asociada
		Square[][] aux = board.getSquares();  //se obtiene el estado de todas las casillas del tablero
		assertTrue(aux[1][1].isOpened());  //se comprueba que la casilla se ha abierto
		assertTrue(board.hasExploded()); //se commprueba que execute ha marcadl el tablero como explotado
		
	}
}
