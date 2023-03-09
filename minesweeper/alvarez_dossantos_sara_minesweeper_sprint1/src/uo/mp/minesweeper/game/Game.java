package uo.mp.minesweeper.game;

import uo.mp.minesweeper.model.Board;

public class Game {
	
	Board board;

	/**
	 * El constructor de Game recibe un objeto Board
	 * @param no
	 */
	public Game(Board board) {
		//ArgumentChecks.isTrue(board != null,"Invalid board");
		this.board = board;
		
	}
	
	/**
	 * Inicializa el juego (mensajes al usuario, contador de tiempo, etc.). A continuación,
	 * ejecuta un bucle en el que se pide un movimiento al usuario y se
	 * descubre/(des)marca la casilla correspondiente. Cuando se detecta que el usuario
	 * ha perdido (ha pisado una mina) o el tablero está en situación de victoria (ya no
	 * quedan minas por encontrar y señalar), el juego se detiene, se muestra el tablero
	 * descubierto por completo y se informa al usuario de su victoria/derrota.
	 */
	public void play() {
		
	}

}
