package uo.mp.minesweeper.game;

import java.util.Scanner;
import java.util.Timer;

import uo.mp.lab.util.check.ArgumentChecks;

public class Game {
	
	Board board;
	GameInteractor interactor;
	
	/**
	 * El constructor de Game recibe un objeto Board
	 * @param no
	 */
	public Game(Board board) {
		ArgumentChecks.isTrue(board != null,"Invalid board");
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
		interactor.showReadyToStart();
		long time = System.currentTimeMillis();
		boolean inGame = true;
		board.uncoverWelcomeArea();  //se descubre una primera isla de casillas al azar
		while(inGame) {
			interactor.showGame(System.currentTimeMillis()-time, board);
			GameMove move = interactor.askMove(board.getNumberOfRows(), board.getNumberOfColumns());
			switch(move.getOperation()) {
			case 's':
				board.stepOn(move.getRow(), move.getColumn());
				break;
			case 'f':
				board.flag(move.getRow(), move.getColumn());
				break;
			case 'u':
				board.unflag(move.getRow(), move.getColumn());
				break;
			default:
				System.err.println("Opción: " + move.getOperation());
			}
			if(board.hasExploded()) {
				inGame = false;
				board.unveil();
				interactor.showGame(time, board);  //si explota una bomba muestra el tablero descubierto
				interactor.showBooommm();
				interactor.showGameFinished();
			}else if(board.winner()) {
				inGame = false;
				board.unveil();
				interactor.showGame(time, board);
				interactor.showCongratulations(time);
				interactor.showGameFinished();
			}
		}
	}
	
		/**
		 * Asigna a Game el objeto GameInteractor recibido como parámetro. Establece
		 * interactor como la interfaz que se utilizará para comunicarse con el jugador.
		 * @param interactor
		 */
		public void setInteractor(GameInteractor interactor) {
			ArgumentChecks.isTrue(interactor != null, "Invalid interactor");
			this.interactor = interactor;
		}
	

}
