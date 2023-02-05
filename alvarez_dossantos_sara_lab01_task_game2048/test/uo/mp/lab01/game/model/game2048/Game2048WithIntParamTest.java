package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;


public class Game2048WithIntParamTest {
	
	/**
	 * Casos de uso:
	 * 1- Parámetro por debajo del mínimo --> se crea tablero por defecto
	 * 2- Parámetro por encima del máximo --> se crea tablero por defecto
	 * 3- Parámetro en el mínimo --> se crea tablero del tamaño indicado como parámetro
	 * 4- Parámetro en el máximo --> se crea tablero del tamaño indicado como parámetro
	 * 5- Parámetro dentro de límites --> se crea tablero del tamaño indicado como parámetro
	 * 
	 */
	
	//1- Parámetro por debajo del mínimo --> se crea tablero por defecto
	@Test
	public void game2048WithIntParamBelowMin() {
		int[][] board = new Game2048(1).getBoardForTesting();  //se guarda el tablero creado con un parámetro por debajo del mínimo
		assertEquals(board.length, Game2048.DEFAULT_SIZE_BOARD); //se comprueba que se creó el tablero con tamaño por defecto (3)
		assertEquals(board[0].length, Game2048.DEFAULT_SIZE_BOARD);
	}
	
	//2- Parámetro por encima del máximo --> se crea tablero por defecto
	@Test
	public void game2048WithIntParamBeyondMax() {
		int[][] board = new Game2048(6).getBoardForTesting();  //se guarda el tablero creado con un parámetro por debajo del mínimo
		assertEquals(board.length, Game2048.DEFAULT_SIZE_BOARD); //se comprueba que se creó el tablero con tamaño por defecto (3)
		assertEquals(board[0].length, Game2048.DEFAULT_SIZE_BOARD);
	}
	
	//3- Parámetro en el mínimo --> se crea tablero del tamaño indicado como parámetro
	@Test
	public void game2048WithIntParamInMin() {
		int[][] board = new Game2048(2).getBoardForTesting();  //se guarda el tablero creado con un parámetro por debajo del mínimo
		assertEquals(board.length, 2); //se comprueba que se creó el tablero con tamaño 2x2
		assertEquals(board[0].length, 2);
	}
	
	//4- Parámetro en el máximo --> se crea tablero del tamaño indicado como parámetro
	@Test
	public void game2048WithIntParamInMax() {
		int[][] board = new Game2048(5).getBoardForTesting();  //se guarda el tablero creado con un parámetro por debajo del mínimo
		assertEquals(board.length, 5); //se comprueba que se creó el tablero con tamaño 3x3
		assertEquals(board[0].length, 5);
	}
	
	//5- Parámetro dentro de límites --> se crea tablero del tamaño indicado como parámetro
	@Test
	public void game2048WithIntParamInLimits() {
		int[][] board = new Game2048(3).getBoardForTesting();  //se guarda el tablero creado con un parámetro por debajo del mínimo
		assertEquals(board.length, 3); //se comprueba que se creó el tablero con tamaño 3x3
		assertEquals(board[0].length, 3);
	}
	
}
