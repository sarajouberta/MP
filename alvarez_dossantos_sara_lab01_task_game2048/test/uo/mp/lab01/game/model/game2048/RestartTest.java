package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;

public class RestartTest {
	
	/**
	 * Casos de uso:
	 * 1- Tablero con posiciones ocupadas --> todas las posiciones pasan a tener un 0 menos una, 
	 *    que contiene un 2.
	 * 2- Tablero vacío --> se rellena una posición con un 2.
	 */

	//1- Tablero con posiciones ocupadas --> todas las posiciones pasan a tener un 0 menos una, que contiene un 2.
	@Test
	public void restartBoardWithContent() {
		int[][ ]board = ForTesting.SEMIFULL21;  //tablero 3x3 con 2 columnas rellenas (6 posiciones)
		Game2048 game2048 = new Game2048(board);
		game2048.restart();
		int aux = howManyTwo(game2048.getBoardForTesting()); //se llama al método que cuenta el nº de "2" que contiene el tablero
		assertEquals(aux, 1); //se comprueba que solo una posición contiene algo distinto de 0 (2)
	}
	
	
	// 2- Tablero vacío --> se rellena una posición con un 2.
	@Test
	public void restartEmptyBoard() {
		int[][ ]board = ForTesting.EMPTY;  //tablero 3x3 con todas las posiciones a 0
		Game2048 game2048 = new Game2048(board);
		game2048.restart();
		int aux = howManyTwo(game2048.getBoardForTesting()); //se llama al método que cuenta el nº de "2" que contiene el tablero
		assertEquals(aux, 1); //se comprueba que solo una posición contiene algo distinto de 0 (2)
	}
	
	
	//Método privado para contar el número de "2" del tablero:
	
	private int howManyTwo(int[][] board) {
		int contador = 0;
		for(int i = 0; i < board.length; i++) {  //se recorre la matriz para comprobar que contiene 0 en todas las posiciones salvo una
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] != 0) {
					contador ++;
				}
			}
		}
		return contador;
	}
	
	
	
	
	
}
