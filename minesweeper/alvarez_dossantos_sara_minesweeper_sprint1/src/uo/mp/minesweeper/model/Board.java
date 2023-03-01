package uo.mp.minesweeper.model;

import uo.mp.lab.util.check.ArgumentChecks;

public class Board {
	
	public static final int DEFAULT_DIMENSION = 9;
	public static final int DEFAULT_PERCENTAGE = 12;  //redondear alza
	private Square[][] board;
	
	
	/**
	 * Construye un tablero de width x height posiciones, en la que el porcentaje de
	 * las casillas que contiene una mina lo marca percentage. El número de minas se
	 * redondeará al alza a partir del porcentaje. Incluye las minas de forma aleatoria y
	 * da un valor entero entre -1 y 8 a todas las casillas.
	 * @param width
	 * @param height
	 * @param percentage
	 */
	public Board(int width, int height, int percentage) {
		//ArgumentChecks.
		board = new Square[width][height];
		double numberOfMines = (width*height)*0.12;  //calcular nº de minas que corresponden (12%)
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				
			}
		}
		
	}
	
	/**
	 * Este constructor se utilizará únicamente para casos de test. Mines marca la
	 * cantidad de minas, y squares se asigna directamente a la referencia interna al array
	 * de casillas (Square).
	 * @param mines
	 * @param squares
	 */
	public Board(int mines, Square[][] squares) {
		
	}
	
	/**
	 * Devuelve true si ha explotado alguna mina en el tablero, false en caso contrario.
	 * 
	 * @return
	 */
	public boolean hasExploded() {
		
		return false;
	}
	
	/**
	 * Si no está descubierta, descubre la casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void stepOn(int x, int y) {
		
	}
	
	/**
	 * Si no hay ya una bandera y la casilla no está descubierta, coloca una bandera en la
	 * casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void flag(int x, int y) {
		
	}
	
	/**
	 * Si hay una bandera, retira una bandera en la casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void unflag(int x, int y) {
		
	}
	
	/**
	 * Descubre todas las casillas del tablero. Si una casilla está cerrada (CLOSED) pasa a
	 * estado OPENED.
	 */
	public void unveil() {
		
	}
	
	/**
	 * Devuelve el número de banderas que aún no han sido colocadas. Distinto de
	 * getlMinesLeft().
	 * @return
	 */
	public int getNumberOfFlagsLeft() {
		
		return 0;
	}
	
	/**
	 * Devuelve el número de minas que aún no ha sido cubierto con una bandera.
	 * @return
	 */
	public int getNumberOfMinesLeft() {
		
		return 0;
	}
	
	/**
	 * Sitúa al estado interno del tablero como explotado (debido a que se ha descubierto
	alguna mina).
	 */
	public void markAsExploded() {
		
	}
	
	/**
	 * Devuelve un array de caracteres que representa el estado del tablero de juego.
	 * Cada posición del array que devuelve, contendrá el carácter que representa la
	 * casilla gráficamente de acuerdo a su valor y estado actual.
	 * @return
	 */
	public char[][] getState(){
		
		return null;
	}
	
	/**
	 * Devuelve una copia del array de Square manejado internamente. Se puede usar
	 * este método para realizar los tests.
	 * @return
	 */
	public Square[][] getSquares(){
		
		return null;
	}

	/**
	 * 
	 * @return
	 */
	private Square[][] getBoard() {
		return board;
	}

	/**
	 * 
	 * @param board
	 */
	private void setBoard(Square[][] board) {
		//ArgumentChecks.isTrue();
		this.board = board;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
