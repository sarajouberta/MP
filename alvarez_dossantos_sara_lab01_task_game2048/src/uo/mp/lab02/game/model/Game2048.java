package uo.mp.lab02.game.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * Tï¿½tulo: Clase Game2048
 * </p>
 * <p>
 * Descripciï¿½n: A partir de un array bidimensional de nï¿½meros y a travï¿½s de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingenierï¿½a Informï¿½tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Sara Ã�lvarez Dos Santos
 * @version 7/2/2023
 */
public class Game2048 {

	public static final int MIN_SIZE_BOARD = 2;  //constante tamaÃ±o mÃ­nimo
	public static final int MAX_SIZE_BOARD = 5;  //constante tamaÃ±o mÃ¡ximo
	public static final int BASE = 2;   //constante nÃºmero de la base (potencias de 2)
	public static final int DEFAULT_SIZE_BOARD = 3;   //constante tamaÃ±o por defecto
	public static final Random RAND = new Random();   //constante random para no tener que instanciar Random varias veces
	
	private int[][] board;   // atributo de la clase: el tablero de la partida
	
	/**
	 * Constructor sin parï¿½metros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	
	public Game2048() {
		board = new int[DEFAULT_SIZE_BOARD][DEFAULT_SIZE_BOARD];
	}

	/**
	 *Constructor que recibe el tamaï¿½o del tablero
	 *
	 *@param tamaï¿½o del tablero cuadrado. Si el tamaï¿½o no estï¿½ entre el mï¿½nimo (2) 
	 *y el mï¿½ximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		if(size < MIN_SIZE_BOARD || size > MAX_SIZE_BOARD) {   //si el parÃ¡metro es correcto, crea el tablero
			board = new int[DEFAULT_SIZE_BOARD][DEFAULT_SIZE_BOARD];
		}else {
			board = new int[size][size];    //si el parÃ¡metro no es correcto, crea uno por defecto
		}
			
	}
	
	//GET --> devuelve copia, como es igual que el de getfortesting --> refactorizar 
	
	
	
	
	
	/**
	 * Inicializa el tablero con la matriz recibida como parï¿½metro, Util para propï¿½sito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del parï¿½metro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre mï¿½ximo (5x5) y el mï¿½nimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si parï¿½metro null, la dimensiï¿½n es errï¿½nea, o 
	 * hay valores inadecuados (no son potencia de 2).
	 */
	
	public Game2048(final int[][] board) {
		if(board == null) {    // si el tablero es null
			throw new IllegalArgumentException("El tablero no puede ser null");
		}else if(board.length != board[0].length) {    //si el tablero no es cuadrado
			throw new IllegalArgumentException("El tablero debe ser cuadrado");
		}else if(board.length < 2 || board.length > 5) {   //si el tamaÃ±o sale de lÃ­mites
			throw new IllegalArgumentException("TamaÃ±o del tablero fuera de lÃ­mtes");
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
				this.board[i][j] = board[i][j];  //se copian los valores del tablero parÃ¡metro al de la partida
			}
		}
	}
	
	// NO HABÃ�A VISTO ESTO
	/*
	 * @param n entero >= 0
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0;  // No hay que hacer nada en este mï¿½todo
	}

	/**
	 * Devuelve UNA COPIA de la matriz para poder usarla en las pruebas
	 * 
	 * @return copia exacta del tablero
	 */
	public int[][] getBoardForTesting() {
		if(this.board == null) {     //si no se habÃ­a instanciado aÃºn el tablero (evitar NullPointerException)
			throw new IllegalStateException("No hay un tablero instanciado");
		}
		int[][] board = new int[this.board.length][this.board.length];   //se crea un tablero auxiliar con las dimensiones del que se copia
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = this.board[i][j];  //se copian los valores del tablero de la partida para devolver su copia 
			}
		}
		return board;	
		
		// refactorizar llamando a private int[][] copyBoard();
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posiciï¿½n aleatoria
	 */
	public void restart() {
		for (int i = 0; i < board.length; i++) {   
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;      //se recorre la matriz del tablerp y se ponen a 0 todas las posiciones
			}
		}
		int x = RAND.nextInt(board.length);  //para obtener una posiciÃ³n aleatoria en la coordenada x de la matriz
		int y = RAND.nextInt(board.length);  //para obtener una posiciÃ³n aleatoria en la coordenada y de la matriz
		board[x][y] = BASE;   //se asigna un 2 en una posiciÃ³n aleatoria utilizando las coordenadas aleatorias
		
	}
	
	
	/**
	 * Aï¿½ade un nuevo  2 en una posiciï¿½n aleatoria vacï¿½a
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		List<Position> positions = new ArrayList<Position>();  //se crea lista que almacena posiciones vacÃ­as
		for (int i = 0; i < this.board.length; i++) {   //se recorre el tablero en busca de posiciones vacÃ­as
			for (int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == 0) {
					positions.add(new Position(i,j));  //se almacena la posiciÃ³n vacÃ­a en la lista
				}
			}
		}
		if(positions.size() > 0) {   //si hay posiciones vacÃ­as (si no, el mÃ©todo no hace nada)
			int random = RAND.nextInt(positions.size());   //se genera un nÂº aleatorio en el rango de las posiciones vacÃ­as
			this.board[positions.get(random).x][positions.get(random).y] = 2;  //se accede a la posicion obtenida para poner un 2
		}
	}
	
	/*Clase privada para almacenar posiciones vacÃ­as:
	 * cada posiciÃ³n es un objeto con cada coordenada como artibuto.
	 */
	private class Position{
		int x;
		int y;
		//constructor con parÃ¡metros: los Ã­ndices de la matriz que se quieren almacenar
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	
	/**
	 * Comprueba si el tablero estï¿½ lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un nï¿½mero distinto de cero
	 * @return true si estï¿½ el tablero lleno, false si hay algï¿½n hueco
	 */
	public boolean isBoardFull() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				if(this.board[i][j] == 0) {   //se recorre la matriz entera, y si encuentra alguna posiciÃ³n a 0, devuelve false
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
	 * y todos los ceros en las ï¿½ltimas posiciones de la fila
	 */
	public void compactLeft() {
		for(int i = 0; i < this.board.length; i++){   // se recorre cada fila del tablero
			compactRowLeft(i);   //se llama al mÃ©todo que compacta la fila
		}
	}
	
	/*
	 * Compacta una fila a la izquierda
	 * Recorre la fila y si la posiciï¿½n contiene 0 se busca una posiciï¿½n a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegï¿½rate de que el algoritmo es eficiente. Si ya estï¿½ compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		int i = row;   //la fila es un valor fijo
		for (int j = 0; j < board.length-1; j++) {  //no mira la Ãºltima posiciÃ³n, ya que no puede intercambiarse
			if(this.board[i][j] == 0) {
				//si la posiciÃ³n contiene un 0, se comprueba el resto de la fila:
				for(int k = j+1; k < board.length; k++) { 
					if(this.board[i][k] > 0) {
						// si la siguiente posiciÃ³n del resto de la fila contiene algo mayor que 0, intercambia la primera (0) con esta 
						int aux = this.board[i][k];  
			            this.board[i][k] = this.board[i][j];  
			            this.board[i][j] = aux;
			            break;    /*tras el intercambio, se rompe el bucle para que continÃºe comprobando
			                        en la siguiente iteraciÃ³n*/
					}
			
				}
			}
			
			
		}
	}
	
	
	/*
	 * Busca una posiciï¿½n (columna) a la derecha de la posiciï¿½n column que 
	 * que contenga un valor positivo y devuelve la posiciï¿½n si lo encuentra
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
	 * en las ï¿½ltimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		for(int i = 0; i < this.board.length; i++){   // se recorre cada fila del tablero
			compactRowRight(i);
		}
	}
	
	/*
	 * Compacta una fila a la derecha
	 * Recorre la fila y si la posiciï¿½n contiene 0 se busca una posiciï¿½n a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegï¿½rate de que el algoritmo es eficiente. Si ya estï¿½ compactada no sigue comprobando
	 * 
	 */
	private void compactRowRight(int row) {
		int i = row;   //la fila es un valor fijo
		for (int j = board.length-1; j > 0; j--) {  //no mira la Ãºltima posiciÃ³n, ya que no puede intercambiarse
			if(this.board[i][j] == 0) {   
				//si la posiciÃ³n contiene un 0, se comprueba el resto de la fila:
				for(int k = j-1; k >= 0; k--) {
					if(this.board[i][k] > 0) {
						// si la siguiente posiciÃ³n del resto de la fila contiene algo mayor que 0, intercambia la primera (0) con esta
						int aux = this.board[i][k];  
			            this.board[i][k] = this.board[i][j];  
			            this.board[i][j] = aux;
			            break;
					}
				}
			}	
		}
	}
	
	
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las ï¿½ltimas posiciones
	 */
	public void compactUp() {
		for(int i = 0; i < this.board[0].length; i++){   // se recorre cada fila del tablero
			compactColumnUp(i);
		}
	}
	
	/* MÃ©todo privado que compacta cada columna hacia arriba
	 * Recorre la columna y si la posiciï¿½n contiene 0 se busca una posiciï¿½n abajo
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegï¿½rate de que el algoritmo es eficiente. Si ya estï¿½ compactada no sigue comprobando
	 * 
	 */
	
	private void compactColumnUp(final int column) {
		for (int j = 0; j < board.length-1; j++) {  //no mira la Ãºltima posiciÃ³n, ya que no puede intercambiarse
			if(this.board[j][column] == 0) {   
				//si la posiciÃ³n contiene un 0, se comprueba el resto de la columna:
				for(int k = this.board.length; k > 0 ; k--) {
					if(this.board[k][column] > 0) {
						// si la siguiente posiciÃ³n del resto de la columna contiene algo mayor que 0, intercambia la primera (0) con esta
						int aux = this.board[k][column];  
			            this.board[k][column] = this.board[j][column];  
			            this.board[j][column] = aux; 
			            break;
					}
				}
			}	
		}
	}
	
	
	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las Ãºltimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		for(int i = 0; i < this.board[0].length; i++){   // se recorre cada fila del tablero
			compactColumnDown(i);
		}
	}
	
	/* MÃ©todo privado que compacta cada columna hacia abajo
	 * Recorre la columna y si la posiciï¿½n contiene 0 se busca una posiciï¿½n arriba
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegï¿½rate de que el algoritmo es eficiente. Si ya estï¿½ compactada no sigue comprobando
	 * 
	 */
	
	private void compactColumnDown(final int column) {
		for (int j = board.length-1; j > 0; j--) {  //no mira la Ãºltima posiciÃ³n, ya que no puede intercambiarse
			if(this.board[j][column] == 0) {   
				//si la posiciÃ³n contiene un 0, se comprueba el resto de la columna:
				for(int k = j-1; k >= 0 ; k--) {
					if(this.board[k][column] > 0) {
						// si la siguiente posiciÃ³n del resto de la columna contiene algo mayor que 0, intercambia la primera (0) con esta
						int aux = this.board[k][column];  
			            this.board[k][column] = this.board[j][column];  
			            this.board[j][column] = aux; 
			            break;
					}
				}
			}	
		}
	}
	
	
	
	
	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habrï¿½ 5 espacios para cada posiciï¿½n en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();  //se utiliza StringBuilder para ir aÃ±adiendo los elementos
		String space = "     ";  //el nÃºmero de espacios (5) que habrÃ¡ entre posiciones del tablero
		for (int i = 0; i < board.length; i++) {     //se recorre todo el tablero para obtener su contenido
			for (int j = 0; j < board.length; j++) {
				str.append(board[i][j]);  //se aÃ±ade el valor de la posiciÃ³n del tablero
				//si se llega a la Ãºltima posiciÃ³n de la fila, no se aÃ±aden espacios, 5 en caso contrario
				str.append(j == board.length-1 ? "" : space);
			}
			str.append("\n");  //se aÃ±ade el tabulador al fin de cada fila del tablero
		}
		return str.toString();  //finalmente se devuelve la string obtenida
	}
	
	
	
	
	
	
	/**
	 * @return false si el jugador no ha ganado todavï¿½a y hay algunos huecos en
	 *         el tablero; true en otro caso
	 */
	public boolean isFinished() {
		int contador = 0;  //variable para acumular el nÃºmero de espacios (0) en en tablero
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				if(this.board[i][j] == 2048) {   
					return true;  //si se obtiene el nÃºmero 2048 en alguna posiciÃ³n, el juego termina (jugador gana)
				}
				if(this.board[i][j] == 0) {
					contador ++;
				}
			}
		}
		if(contador == 0) {   //si no quedan espacios en el tablero, se acaba la partida (jugador pierde)
			return true;
		}else {
			return false;
		}
	}
	
	
	//métodos tarea 02
	/**
	 * Compacta a la dcha. los números de cada fila, a continuación
	 * suma de dos en dos los números consecutivos iguales dejando el resultado 
	 * en la casilla derecha. Finalmente, se vuelve a compactar.
	 * 
	 * GIVEN: ???
	 * THEN:
	 * WHEN:
	 * 
	 * Ejemplo:
	 * Dada una fila 2 2 0 2 2 el resultado de moveRight() sería: 0 0 0 4 4
	 *  	1- 2 2 0 2 2 -> compacta a la derecha -> 0 2 2 2 2 
	 *  	2- suma consecutivos -> 0 0 4 0 4
	 *  	3- compacta a la derecha -> 0 0 0 4 4
	 * 
	 */
	
	 public void moveRight() {
		 this.compactRight();  //se compacta el tablero a la derecha
		 for (int row = 0; row < board.length; row++) {
			sumConsecutiveRight(row);   //se suman los nº consecutivos fila por fila
		 }
		 this.compactRight(); //se compacta el tablero tras la suma de consecutivos
		 
	 }
	 
	 
	 private void sumConsecutiveRight(int row) {
		 int i = row;  //la fila es un valor fijo
		 for (int j = board.length-1; j > 0; j--) {
			 if(this.board[i][j] != 0 && this.board[i][j] == this.board[i][j-1]) { //si hay dos números iguales consecutivos (!=0)
				int sum = this.board[i][j] + this.board[i][j-1]; //se suman
				this.board[i][j] = sum;  //se guarda el resultado en la posición contigua a la derecha
				this.board[i][j-1] = 0;   //se pone la posición a 0 tras la suma
			 }
			
		}
	 }
	 
	 /**
		 * Compacta a la izda. los números de cada fila, a continuación
		 * suma de dos en dos los números consecutivos iguales dejando el resultado 
		 * en la casilla derecha. Finalmente, se vuelve a compactar.
		 * 
		 * Se rota dos veces el tablero para reutilizar el movimiento a la derecha, llamando
		 * al método privado rotateBoard(). Después, se llama a moveRight() para hacer las sumas pertinentes,
		 * y se vuelve a rotar dos veces el tablero para devolverlo a la posición deseada.
		 * 
		 */
	 
	 public void moveLeft() {
		 rotateBoard();
		 rotateBoard();
		 moveRight();
		 rotateBoard();
		 rotateBoard();	 
	 }
	 
	 
	 /**
	  * Método privado para rotar el contenido del tablero hacia la izda.
	  * Ejemplo:
	  * 1 2 3     3 6 9
	  * 4 5 6 --> 2 5 8
	  * 7 8 9     1 4 7
	  * 
	  */
	 
	 private void rotateBoard() {
		 int[][] boardToCopy = new int[this.board.length][this.board.length];
		 for (int i = 0; i < board.length; i++) {
			 for (int j = 0; j < board[0].length; j++) {
				boardToCopy[boardToCopy.length-1 -j][i] = this.board[i][j];
			 }
		 }
		 this.board = boardToCopy;
	 }
	 
	 
	 /**
		 * Compacta hacia arriba los números de cada fila, a continuación
		 * suma de dos en dos los números consecutivos iguales dejando el resultado 
		 * en la casilla derecha. Finalmente, se vuelve a compactar.
		 * 
		 * Se rota tres veces el tablero para reutilizar el movimiento a la derecha, llamando
		 * al método privado rotateBoard(). Después, se llama a moveRight() para hacer las sumas pertinentes,
		 * y se vuelve a rotar una vez el tablero para devolverlo a la posición deseada.
		 * 
		 */
	 
	 public void moveUp() {
		 rotateBoard();
		 rotateBoard();
		 rotateBoard();
		 moveRight();
		 rotateBoard();
	 }
	 
	 /**
		 * Compacta hacia abajo los números de cada fila, a continuación
		 * suma de dos en dos los números consecutivos iguales dejando el resultado 
		 * en la casilla derecha. Finalmente, se vuelve a compactar.
		 * 
		 * Se rota una vez el tablero para reutilizar el movimiento a la derecha, llamando
		 * al método privado rotateBoard(). Después, se llama a moveRight() para hacer las sumas pertinentes,
		 * y se vuelve a rotar tres veces el tablero para devolverlo a la posición deseada.
		 * 
		 */
	 
	 public void moveDown() {
		 rotateBoard();
		 moveRight();
		 rotateBoard();
		 rotateBoard();
		 rotateBoard();
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

}
