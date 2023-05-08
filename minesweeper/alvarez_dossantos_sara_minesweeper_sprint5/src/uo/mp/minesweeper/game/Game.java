package uo.mp.minesweeper.game;

import java.util.Timer;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.session.GameException;

public class Game {
	
	Board board;
	GameInteractor interactor;
	
	private boolean winner;
	private long duration;
	
	/**
	 * El constructor de Game recibe un objeto Board
	 * @param no
	 * ¿excepcion GameException por tablero de tamaño no permitido aquí?
	 */
	public Game(Board board) {
		ArgumentChecks.isTrue(board != null,"Invalid board");
		this.board = board;
		//interactor queda null
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
			try {
				doMove(move);
				inGame = checkFinished(time, inGame);
				duration = System.currentTimeMillis()-time;  //guarda la duración de la partida
			} catch (GameException e) {  //muestra el error y vuelve a pedir movimiento¿?
				System.out.println(e.getMessage());
			}
		}
	}

	private boolean checkFinished(long time, boolean inGame) {
		if(board.hasExploded()) {
			inGame = false;
			board.unveil();
			interactor.showGame(time, board);  //si explota una bomba muestra el tablero descubierto
			interactor.showBooommm();
			interactor.showGameFinished(); 
		}else if(board.hasWon()) {
			this.winner = true;
			inGame = false;
			board.unveil();
			interactor.showGame(time, board);
			interactor.showCongratulations(time);
			interactor.showGameFinished();
		}
		return inGame;
	}

	private void doMove(GameMove move) throws GameException {
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
	
	/**
	 * Devuelve el tiempo que duró la partida
	 * @return
	 */
	public long getDuration() {
		return duration;
	}
	
	/**
	 * Devuelve true si el jugador ganó la partida, false en caso contrario
	 * 
	 * REVISAR ESTO
	 * 
	 * @return
	 */
	public boolean getWinner() {
		return winner;
	}

}
