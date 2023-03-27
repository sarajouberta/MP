package uo.mp.minesweeper.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.game.square.actions.BlowUpAction;
import uo.mp.minesweeper.game.square.actions.ClearAction;
import uo.mp.minesweeper.game.square.actions.NullAction;

public class Board {
	
	public static final int DEFAULT_DIMENSION = 9;
	public static final int DEFAULT_PERCENTAGE = 12;  //redondear alza
	private Square[][] board;
	private boolean boardState = true; //por defecto el estado es true (no ha explotado ninguna mina)
	private int numberOfMines;
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
	 */
	public Board(int height,int width, int percentage) {
		ArgumentChecks.isTrue(height > 0, "Invalid height");
		ArgumentChecks.isTrue(width > 0, "Invalid width");
		ArgumentChecks.isTrue(percentage > 0 && percentage <= 100, "Invalid percentage");
		board = new Square[height][width];
		this.numberOfMines = Math.round(((width*height)*percentage)/100.0f);
		numberOfFlags = numberOfMines;  //se establece el mismo número de banderas que de minas
		//se instancian todas las casillas del tablero
		initialiseSquares();
		//asignar el % aleatorio:
		setInitialMines();
		//asignar al resto de posiciones un valor según el nº de minas que tenga alrededor
		setInitialHints();
	}
	
	
	private void setInitialHints() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j].getValue() != -1) {   //si no tiene mina
					List<Square> neighbours = new ArrayList<Square>();
					int value = 0;
					//recorre las casillas vecinas en busca de minas, comprobando que no se salga del tablero
					for(int k = (i-1 < 0 ? 0 : i-1); k <= i+1 && k < board.length; k++) {  
						for (int l = (j-1 < 0 ? 0 : j-1); l <= j+1 && l < board[0].length; l++) {
							//si no es la propia casilla, se añade como vecino
							if(!(i == k && j == l)) {
								neighbours.add(board[k][l]);   //tenog de vecino a Spiderman
								//si es una casilla ya instanciada con mina
								if(board[k][l] != null && board[k][l].getValue() == -1) {
									value++;
								}	
							}
						}
					}
					board[i][j].setValue(value); // asigna pista numérica (minas alrededor)
					//asigna acción: como está dentro del if ya no puede ser -1(mina)
					board[i][j].setAction(value == 0 ? new ClearAction(neighbours) : new NullAction());
				}
			}
		}
	}

	private void setInitialMines() {
		int minesToSet = numberOfMines;
		do {
			int rdnI = rdn.nextInt(board.length);   //generar posición i aleatoria
			int rdnJ = rdn.nextInt(board[0].length);     //generar posición j aleatoria
			if(board[rdnI][rdnJ].getValue() != -1) {  //si no hay mina ya (por si sale posición aleatoria repetida)
				board[rdnI][rdnJ].setValue(-1);  //asigna mina
				board[rdnI][rdnJ].setAction(new BlowUpAction(this));
				minesToSet--;
			}
		}while(minesToSet > 0);
	}

	private void initialiseSquares() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Square();
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
		ArgumentChecks.isTrue(squares != null, "Invalid matrix of squares");
		ArgumentChecks.isTrue(mines >= 0, "Invalid number of mines");
		ArgumentChecks.isTrue(mines == getNumberOfMines(squares)); //comprobar que hay las minas indicadas
		board = squares;
		numberOfFlags = mines; //el número de minas es el mismo que el número de banderas
		numberOfMines = mines;
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
		board[x][y].stepOn();
	}
	
	/**
	 * Método para saber si se ha ganado la partida
	 * @return
	 */
	public boolean winner() {
		int closedSquares = 0;  
		//se recorre el tablero para saber el nº de casillas que quedan cerradas
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j].getSquareState() == SquareState.CLOSED || board[i][j].getSquareState() == SquareState.FLAGGED) {
					closedSquares++;
				}
			}			
		}
		//si el nº de casilas cerradas == minas: banderas puestas correctamente sobre minas
		if(closedSquares == numberOfMines && numberOfFlags == 0) {
			return true;
		}else {
			return false;
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
		return numberOfFlags; //si quedan banderas significa que queda el mismo nº de minas por cubrir
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
	 * 0: casilla vacía (" ")
	 * 1-8: pista numérica
	 * -1: casilla con mina                 
	 * @return
	 */
	public char[][] getState(){
		char[][] stateBoard = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j].getSquareState().equals(SquareState.OPENED)) {
					if(board[i][j].getValue() == -1) { //si tiene mina
						stateBoard[i][j]= '@';        // no puedo poner -1 en char
					}else if(board[i][j].getValue() >= 1 && board[i][j].getValue() <= 8) { //si tiene pista numérica
						stateBoard[i][j] = Character.forDigit(board[i][j].getValue(), 10); 
					}else {
						stateBoard[i][j] = ' ';
					}
				}else if(board[i][j].getSquareState().equals(SquareState.FLAGGED)) {
					stateBoard[i][j] = (char) 182;
				}else {
					stateBoard[i][j] = '#';
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
	 * @param board
	 */
	private void setBoard(Square[][] board) {
		//ArgumentChecks.isTrue();
		this.board = board;
	}

	public int getWidth() {
		return board[0].length;
	}

	public int getHeight() {
		return board.length;
	}

	@Override
	public String toString() {
		char[][] boardToPrint = getState();  //se guarda el estado del tablero
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < boardToPrint.length; i++) {  //bucle para añadir el estado línea por línea
			str.append("[");
			for (int j = 0; j < boardToPrint[0].length; j++) {
				str.append(boardToPrint[i][j]);
				if(j < boardToPrint[0].length -1) {  //para separar los elementos intermedios
					str.append(",");
				}else {   //si ya es el último elemento
					str.append("]\n");
				}
			}
		}
		return str.toString();
	}
	
	/**
	 * Método privado para validar parámetro del constructor para tests
	 * @return número de casillas con mina de la matriz de squares
	 */
	private int getNumberOfMines(Square[][] squares) {
		int mines = 0;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[0].length; j++) {
				if(squares[i][j].getValue() == -1) {
					mines++;
				}
			}
		}
		return mines;
	}
	
	
	
	
}
