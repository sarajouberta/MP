package uo.mp.lab01.game.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * T�tulo: Clase Game2048
 * </p>
 * <p>
 * Descripci�n: A partir de un array bidimensional de n�meros y a trav�s de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Sara Álvarez Dos Santos
 * @version 3/2/2023
 */
public class Game2048 {

	public static final int MIN_SIZE_BOARD = 2;
	public static final int MAX_SIZE_BOARD = 5;
	public static final int BASE = 2;
	public static final int DEFAULT_SIZE_BOARD = 3;
	public static final Random RAND = new Random();
	
	private int[][] board;
	
	/**
	 * Constructor sin par�metros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	
	public Game2048() {
		board = new int[DEFAULT_SIZE_BOARD][DEFAULT_SIZE_BOARD];
	}

	/**
	 *Constructor que recibe el tama�o del tablero
	 *
	 *@param tama�o del tablero cuadrado. Si el tama�o no est� entre el m�nimo (2) 
	 *y el m�ximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		if(size < MIN_SIZE_BOARD || size > MAX_SIZE_BOARD) {
			board = new int[DEFAULT_SIZE_BOARD][DEFAULT_SIZE_BOARD];
		}else {
			board = new int[size][size];
		}
			
	}
	
	/**
	 * Inicializa el tablero con la matriz recibida como par�metro, Util para prop�sito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del par�metro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre m�ximo (5x5) y el m�nimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si par�metro null, la dimensi�n es err�nea, o 
	 * hay valores inadecuados (no son potencia de 2).
	 */
	
	public Game2048(final int[][] board) {
		if(board == null) {    // si el tablero es null
			throw new IllegalArgumentException("El tablero no puede ser null");
		}else if(board.length != board[0].length) {    //si el tablero no es cuadrado
			throw new IllegalArgumentException("El tablero debe ser cuadrado");
		}else if(board.length < 2 || board.length > 5) {   //si el tamaño sale de límites
			throw new IllegalArgumentException("Tamaño del tablero fuera de límtes");
		}else{     //comprobar si solo contiene potencias de 2
			for(int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if((board[i][j] & board[i][j]-1) != 0){ 
						//& operador AND entre bits, da 0 2^n & (2^n)-1
						throw new IllegalArgumentException("El tablero debe contener potencias de 2");
					}
				}
			}
		}
		this.board = new int[board.length][board.length];  //se instancia el tablero del juego
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				this.board[i][j] = board[i][j];  //se copian los valores del tablero parámetro 
			}
		}
	}
	
	// NO HABÍA VISTO ESTO
	/*
	 * @param n entero >= 0
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0;  // No hay que hacer nada en este m�todo
	}

	/**
	 * Devuelve UNA COPIA de la matriz para poder usarla en las pruebas
	 * 
	 * @return copia exacta del tablero
	 */
	public int[][] getBoardForTesting() {
		if(this.board == null) {
			throw new IllegalStateException("No hay un tablero instanciado");
		}
		int[][] board = new int[this.board.length][this.board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = this.board[i][j];  //se copian los valores del tablero parámetro 
			}
		}
		return board;	
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posici�n aleatoria
	 */
	public void restart() {
		for (int i = 0; i < board.length; i++) {   
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;      //se ponen a 0 todas las posiciones
			}
		}
		int x = RAND.nextInt(board.length);  //para obtener una posición aleatoria
		int y = RAND.nextInt(board.length);
		board[x][y] = BASE;   //se asigna un 2 en una posición aleatoria de la matriz
		
	}
	
	
	/**
	 * A�ade un nuevo  2 en una posici�n aleatoria vac�a
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		List<Position> positions = new ArrayList<Position>();  //se crea lista que almacena posiciones vacías
		for (int i = 0; i < this.board.length; i++) {   //se recorre el tablero en busca de posiciones vacías
			for (int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == 0) {
					positions.add(new Position(i,j));  //se almacena la posición vacía en la lista
				}
			}
		}
		if(positions.size() > 0) {   //si hay posiciones vacías (si no, el método no hace nada)
			int random = RAND.nextInt(positions.size());   //se genera un nº aleatorio en el rango de las posiciones vacías
			this.board[positions.get(random).x][positions.get(random).y] = 2;  //se accede a la posicion obtenida para poner un 2
		}
	}
	
	//Clase priada para almacenar posiciones vacías:
	
	private class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	
	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un n�mero distinto de cero
	 * @return true si est� el tablero lleno, false si hay alg�n hueco
	 */
	public boolean isBoardFull() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Compacta el tablero a la izquierda, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las primeras posiciones de la fila 
	 * y todos los ceros en las �ltimas posiciones de la fila
	 */
	public void compactLeft() {
		
	}
	
	/*
	 * Compacta una fila a la derecha
	 * Recorre la fila y si la posici�n contiene 0 se busca una posici�n a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Aseg�rate de que el algoritmo es eficiente. Si ya est� compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		
	}
	
	/*
	 * Busca una posici�n (columna) a la derecha de la posici�n column que 
	 * que contenga un valor positivo y devuelve la posici�n si lo encuentra
	 * 
	 * @param row, fila en la que se quire trabajar
	 * @param column, columna a partir de la cual se busca un valor hacia la derecha
	 * @return columna encontrada con valor positivo 
	 *         o -1 si no encuentra ninguna a su derecha
	 */
	private int findPositionAtRightWithValueFor(int row, int column) {
		return 0;  // sustituir y completar
	}

	/**
	 * Compacta el tablero a la derecha, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las �ltimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		
	}
	
	
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las �ltimas posiciones
	 */
	public void compactUp() {
		
	}
	
	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las �ltimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		
	}
	
	
	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habr� 5 espacios para cada posici�n en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		return null; // quitar esta l�nea al completar
	}
	
	/**
	 * @return false si el jugador no ha ganado todav�a y hay algunos huecos en
	 *         el tablero; true en otro caso
	 */
	public boolean isFinished() {
		
		return true;// quitar esta l�nea al completar
	}
	
	
	//pruebas y cosas:
	
	private void funwithSara(int startA, int startB) {
		int initA = startA;
		int initB = startB;
		int endA = startA == 0 ? board.length : 0;
		int endB = startB == 0 ? board[0].length : 0;
		int stepA = endA == 0 ? -1 : 1;
		int stepB = endB == 0 ? -1 : 1;
		for (int i = initA; i < endA; i = i + stepA) {
			for (int j = initB; j < endB; j = j + stepB) {
				
			}
			
		}
	}

}
