package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;


public class Game2048WithoutParamsTest {
	
	/**
	 * Casos de uso:
	 * 1- El tablero se crea correctamente con el tamaño por defecto (3x3) y relleno de 0.
	 */
	
	
	//1- El tablero se crea correctamente
	@Test
	public void game2048WithoutParams() {
		int[][] board = new Game2048().getBoardForTesting();
		assertEquals(board.length, Game2048.DEFAULT_SIZE_BOARD);  // se comprueba que el tablero tiene el tañamo esperado (3x3)
		assertEquals(board[0].length, Game2048.DEFAULT_SIZE_BOARD);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				assertEquals(board[i][j], 0);   //se coprueba que todas las posiciones contienen 0 por defecto
			}
		}
	}
	
}
