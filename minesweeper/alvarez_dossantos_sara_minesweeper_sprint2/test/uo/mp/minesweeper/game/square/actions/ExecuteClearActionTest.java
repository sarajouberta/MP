package uo.mp.minesweeper.game.square.actions;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import uo.mp.minesweeper.TestUtil;
import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class ExecuteClearActionTest {

	Board board;
	
	/**
	 * EXECUTE()
	 * 
	 * Casos de uso: casilla con acción ClearAction:
	 * se ejecuta execute(), provocando que se execute stepOn de las casillas adyacentes
	 * (vecinas)
	 * 
	 */
	
	/**
	 * GIVEN stepOn sobre casilla con mina (casilla con blowUp action asociada)
	 * WHEN execute()
	 * THEN casilla destapada y tablero ha explotado (fin partida)
	 * 
	 */
	@Test
	public void executeBlowUpSquare() {
		Square[][] ts = TestUtil.getBoardByMatrix(TestUtil.baseMatrixTwoMines);
		board = new Board(2, ts);  //tablero con dos minas
		TestUtil.setBoardActions(board); //se establece las acciones asociadas al tablero
		board.stepOn(4, 0); //stepOn llama al execute de la acción que tiene asociada
		char[][] boardToCompare = board.getState();  //se obtiene el estado para verificar
		for (int i = 0; i < boardToCompare.length; i++) {
			assertArrayEquals(boardToCompare[i], TestUtil.clear_baseMatrixTwoMines[i]); //se compara el estado obtenido con el estado deseado
		}
	}
}
