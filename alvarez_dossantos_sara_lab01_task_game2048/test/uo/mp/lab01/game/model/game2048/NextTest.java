package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;

public class NextTest {
	
	
	/**
	 * Casos de uso:
	 * 1- existen posiciones vacías --> añade un 2 en una posición aleatoria vacía
	 * 2- no existen posiciones vacías --> no modifica el tablero
	 */
	
	//1- existen posiciones vacías --> añade un 2 en una posición aleatoria vacía
	@Test
	public void nextTestWithEmptyPositions() {
		int[][] case1Board = ForTesting.generateBoardCase1();
		Game2048 game2048 = new Game2048(case1Board);
		game2048.next();
		int[][] testBoard = game2048.getBoardForTesting();
		int num2s = 0;
		for (int i = 0; i < testBoard.length; i++) {
			for (int j = 0; j < testBoard.length; j++) {
				if(testBoard[i][j] == 2) {
					num2s++;
				}
			}
		}
		assertEquals(num2s, 1);
	}
	
	
	//2- no existen posiciones vacías --> no modifica el tablero
	@Test
	public void nextTestWithoutEmptyPositions() {
		int[][] case2Board = ForTesting.generateBoardCase2();
		Game2048 game2048 = new Game2048(case2Board);
		game2048.next();
		int[][] testBoard = game2048.getBoardForTesting();
		for (int i = 0; i < testBoard.length; i++) {
			for (int j = 0; j < testBoard.length; j++) {
				assertEquals(testBoard[i][j], case2Board[i][j]);
			}
		}
	}
	
	
	
	
}
