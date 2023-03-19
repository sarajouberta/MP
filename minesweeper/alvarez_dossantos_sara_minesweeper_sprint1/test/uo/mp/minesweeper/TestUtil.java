package uo.mp.minesweeper;

import uo.mp.minesweeper.model.Square;
import uo.mp.minesweeper.model.SquareState;

public class TestUtil {
	
	/**
	 * PARA TESTS
	 * Clase que será utilizada para establecer un tablero en el un estado concreto para pasar 
	 * las pruebas unitarias.
	 * Permite crear tableros para casos de test concretos
	 */
	

	public static int[][] emptyFlagged = {{}};
	public static int[][] emptyOpened = {{}};
	
	public static int[][] baseMatrixBase = {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
	};
	//Matrix one Mine
	public static int[][] baseMatrixOneMine = {
			{1,1,1,0,0},
			{1,-1,1,0,0},
			{1,1,1,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
	};
	
	//Matrix two Mines
	public static int[][] baseMatrixTwoMines = {
			{1,1,1,0,0},
			{1,-1,1,0,0},
			{1,1,1,1,1},
			{0,0,1,-1,1},
			{0,0,1,1,1}
	};
	
	public static int[][] OneMineFlagged = {{1,1}};
	public static int[][] OneMineOpened = {{8,8}};
	
	
	
	public static char[][] stateClosed = {
			{'#','#','#','#','#'},
			{'#','#','#','#','#'},
			{'#','#','#','#','#'},
			{'#','#','#','#','#'},
			{'#','#','#','#','#'}
	};
	
	/*
	 *      {1,1,1,0,0},
			{1,-1,1,0,0},
			{1,1,1,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
	 */
	public static char[][] stateMixedOneMine = {
			{'¶','#','#','#','#'},
			{'1','@','1',' ',' '},
			{'1','1','1',' ',' '},
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '}
		
	};
	
	public static char[][] stateOpenedOneMine= {
			{'1','1','1',' ',' '},
			{'1','@','1',' ',' '},
			{'1','1','1',' ',' '},
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '}
		
	};
	
	
	
	/**
	 * Método para establecer un tablero en el estado deseado, según el test que lo utliice
	 * @param m matriz con el estado del tablero deseado
	 * @param flagged
	 * @param opened
	 * @return
	 */
	public static Square[][] getBoardByMatrix(int[][] m, int[][] flagged, int[][] opened){
		Square[][] board = getBoardByMatrix(m); //se llama al método para test de la clase board
		for(int i = 0; i < flagged.length; i++) {
			int x = flagged[i][0];
			int y = flagged[i][1];
			board[x][y].setState(SquareState.FLAGGED);  //establece las banderas
		}
		for(int i = 0; i < opened.length; i++) {
			int x = opened[i][0];
			int y = opened[i][1];
			board[x][y].setState(SquareState.OPENED);  //establece casillas abiertas
		}
		return board;
		
		
	}
	
	/**
	 * Método que establece un tablero a partir de una matriz dada (matriz con el estado específico)
	 * @param m matriz con el estado del tablero deseado
	 * @return
	 */
	public static Square[][] getBoardByMatrix(int[][] m){
		Square[][] board = new Square[m.length][m[0].length];  // MAL PUESTOS LOS VALORES; ME MATO
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				int value = m[i][j];
				Square square = new Square();
				square.setValue(value);
				board[i][j] = square;
			}
			
		}
		return board;
	}
}
