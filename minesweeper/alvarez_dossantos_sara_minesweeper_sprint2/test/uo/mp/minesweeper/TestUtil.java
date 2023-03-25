package uo.mp.minesweeper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uo.mp.minesweeper.game.square.actions.BlowUpAction;
import uo.mp.minesweeper.game.square.actions.ClearAction;
import uo.mp.minesweeper.game.square.actions.NullAction;
import uo.mp.minesweeper.model.Board;
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
	
	public static char[][] clear_baseMatrixTwoMines = {
			{'#','#','#','#','#'},
			{'#','#','#','#','#'},
			{'1','1','1','#','#'},
			{' ',' ','1','#','#'},
			{' ',' ','1','#','#'}
	};
	
	/*
	 *      {1,1,1,0,0},
			{1,-1,1,0,0},
			{1,1,1,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
	 */
//	public static char[][] stateMixedOneMine = {
//			{'¶','#','#','#','#'},
//			{'1','@','1',' ',' '},
//			{'1','1','1',' ',' '},
//			{' ',' ',' ',' ',' '},
//			{' ',' ',' ',' ',' '}
//		
//	};
	
	public static char[][] stateOpenedOneMine= {
			{'1','1','1',' ',' '},
			{'1','@','1',' ',' '},
			{'1','1','1',' ',' '},
			{' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' '}
		
	};
	
	public static char[][] stateMixedOneMine= {
		{'¶','#','1',' ',' '},
		{'1','#','1',' ',' '},
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
		Square[][] board = new Square[m.length][m[0].length];  //CUIDADO VALORES ARRAY; por qué soy así
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
	
	/**
	 * Método que será utilizado en los casos de test para establecer las acciones de cada casilla,
	 * una vez instanciado el tablero inicial para el test (inicialmente tiene un array de squares sin
	 * acción asociada)
	 * @param board el tablero con casillas a las que se les asocian las acciones
	 */
	public static void setBoardActions(Board board) {
		Square[][] aux = board.getSquares();
		List<Square> neighbours;
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				switch(aux[i][j].getValue()) {
					case -1:  //para asignar a cada casilla su acción asociada
						aux[i][j].setAction(new BlowUpAction(board));
						break;
					case 0:
						neighbours = getNeighbours(i, j, aux);  //en este caso se obtiene su lista de vecinos
						aux[i][j].setAction(new ClearAction(neighbours));
						break;
					default:
						aux[i][j].setAction(new NullAction());
				}
			}
		}
	}
	
	/**
	 * Método que será utilizado por el método setBoardAction para obtener la lista de vecinos de una
	 * casilla asociada a la acción ClearAction
	 * @param i coordenada de la casilla
	 * @param j coordenada de la casilla
	 * @param aux array de Squares copia del tablero
	 * @return lista de Squares vecinas de la casilla [i][j]
	 */
	public static List<Square> getNeighbours(int i, int j, Square[][] aux) {
		List<Square> neighbours = new ArrayList<Square>();
		//para mirar las posiciones que rodeana  una casilla (se comprueba que no se salen de rango)
		for(int k = (i-1 < 0 ? 0 : i-1); k <= i+1 && k < aux.length; k++) {
			for (int l = (j-1 < 0 ? 0 : j-1); l <= j+1 && l < aux[0].length; l++) {
				if(!(i == k && j == l)) {  //si no es la propia casilla, se añade como vecino
					neighbours.add(aux[k][l]);   //tengo de vecino a Spiderman
				}
			}
		}
		return neighbours;
	}
			
	
}
