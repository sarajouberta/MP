package uo.mp.minesweeper.model;

import java.util.Random;

import uo.mp.lab.util.check.ArgumentChecks;

public class Board {
	
	public static final int DEFAULT_DIMENSION = 9;
	public static final int DEFAULT_PERCENTAGE = 12;  //redondear alza
	private Square[][] board;
	private boolean boardState = true; //por defecto el estado es true (no ha explotado ninguna mina)
	private int numberOfFlags;
	private Random rdn = new Random();   // para no tener que instanciar random en los métodos
	
	/**
	 * Construye un tablero de width x height posiciones, en la que el porcentaje de
	 * las casillas que contiene una mina lo marca percentage. El número de minas se
	 * redondeará al alza a partir del porcentaje. Incluye las minas de forma aleatoria y
	 * da un valor entero entre -1 y 8 a todas las casillas.
	 * @param width
	 * @param height
	 * @param percentage
	 * 
	 * ¿REDONDEO?
	 */
	public Board(int width, int height, int percentage) {
		//ArgumentChecks.
		board = new Square[height][width];
		double numberOfMines = Math.ceil((height*width)*0.12);  //calcular nº de minas(12%), redondeo alza
		numberOfFlags = (int)numberOfMines;  //se establece el mismo número de banderas que de minas
		//primero: asignar el 12% aleatorio:
		for (int i = 0; i < numberOfMines; i++) {  //
			int rdnI = rdn.nextInt(height);   //generar posición i aleatoria
			int rdnJ = rdn.nextInt(width);     //generar posición j aleatoria
			board[rdnI][rdnJ].setValue(-1);  //asignar mina
		}
		//asignar al resto de posiciones un valor aleatorio entre (1 y 8)
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == null) {
					board[i][j].setValue(rdn.nextInt(9));
				}
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
		return !boardState; //si el estado es true: devuelve false (no ha explotado nada)
	}
	
	/**
	 * Si no está descubierta, descubre la casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void stepOn(int x, int y) {
		ArgumentChecks.isTrue(x >= 0 && x < board.length, "Invalid x");
		ArgumentChecks.isTrue(y >= 0 && y < board[0].length, "Invalid y");
		if(!board[x][y].isOpened()) {
			board[x][y].open();  //si no estaba descubierta, la abre
		}
	}
	
	/**
	 * Si no hay ya una bandera y la casilla no está descubierta, coloca una bandera en la
	 * casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void flag(int x, int y) {
		ArgumentChecks.isTrue(x >= 0 && x < board.length, "Invalid x");
		ArgumentChecks.isTrue(y >= 0 && y < board[0].length, "Invalid y");
		if(!board[x][y].isOpened() && !board[x][y].isFlagged()) {
			board[x][y].flag();
			numberOfFlags --; //se decrementa el contador de banderas del tablero
		}
	}
	
	/**
	 * Si hay una bandera, retira una bandera en la casilla de coordenadas (x, y).
	 * @param x
	 * @param y
	 */
	public void unflag(int x, int y) {
		ArgumentChecks.isTrue(x >= 0 && x < board.length, "Invalid x");
		ArgumentChecks.isTrue(y >= 0 && y < board[0].length, "Invalid y");
		if(board[x][y].isFlagged()) {
			board[x][y].unflag();
			numberOfFlags ++; //se incrementa el número de banderas del tablero
		}
	}
	
	/**
	 * Descubre todas las casillas del tablero. Si una casilla está cerrada (CLOSED) pasa a
	 * estado OPENED.
	 */
	public void unveil() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(!board[i][j].isOpened()) {
					board[i][j].open();   //destapa todas las casillas cerradas del tablero
				}
			}
		}
	}
	
	/**
	 * Devuelve el número de banderas que aún no han sido colocadas. Distinto de
	 * getlMinesLeft().
	 * @return
	 */
	public int getNumberOfFlagsLeft() {
		return numberOfFlags;
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
		boardState = false;  //se marca el tablero como explotado (false)
	}
	
	/**
	 * Devuelve un array de caracteres que representa el estado del tablero de juego.
	 * Cada posición del array que devuelve, contendrá el carácter que representa la
	 * casilla gráficamente de acuerdo a su valor y estado actual. 
	 * 0: casilla vacía
	 * 1-8: pista numérica
	 * -1: casilla con mina                  REVISAR ESTO
	 * @return
	 */
	public char[][] getState(){
		char[][] stateBoard = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j].getValue() == -1) { //si tiene mina
					stateBoard[i][j]= 'm';        // no puedo poner -1 en char
				}else if(board[i][j].getValue() >= 1 && board[i][j].getValue() <= 8) { //si tiene pista numérica
					stateBoard[i][j] = 'p'; 
				}else { // casilla vacía
					stateBoard[i][j] = '0'; 
				}
			}
		}
		return stateBoard;
	}
	
	/**
	 * Devuelve una copia del array de Square manejado internamente. Se puede usar
	 * este método para realizar los tests.
	 * @return
	 */
	public Square[][] getSquares(){
		Square[][] boardCopy = new Square[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardCopy[i][j] = board[i][j];    //copia el contenido el tablero en uno auxiliar
			}
		}
		return boardCopy; //se devuelve la copia del tablero
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
