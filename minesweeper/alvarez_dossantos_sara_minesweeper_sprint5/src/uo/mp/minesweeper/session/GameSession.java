package uo.mp.minesweeper.session;

import java.util.Scanner;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab.util.log.SimpleLogger;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Game;
import uo.mp.minesweeper.game.GameInteractor;
import uo.mp.minesweeper.ranking.GameRanking;
import uo.mp.minesweeper.ranking.GameRankingEntry;

public class GameSession {
	
	private SessionInteractor sessionInteractor;
	private GameInteractor gameInteractor;
	private SimpleLogger logger;
	private GameRanking ranking;
	private Game game;
	
	private boolean endGame = false;
	private GameLevel level;  
	private String userName;
	
	Scanner scan = new Scanner(System.in);  //para método privado (no está en interfaz pública)
	private boolean showRanking;

	/**
	 * El método público principal de GameSession es run() que se encarga
	 * de lanzar toda la lógica de la sesión:
	 * - Pregunta el nombre del usuario al iniciar sesión.
	 * - Inicia el bucle del menú principal para recoger procesar las órdenes de usuario.
	 *     a. Cuando el usuario selecciona jugar una partida le pregunta el nivel de dificultad y
	 *        la inicia. Al finalizarla conserva sus resultados si el usuario así lo indica.
	 *     b. Muestra puntuaciones al usuario si este lo solicita.
	 * - Captura posibles RuntimeException para producir un mensaje adecuado para el usuario y
	 *   terminar la ejecución de forma ordenada.
	 */
	
	/**
	 * Inicia toda la lógica principal de GameSession 
	 * (no debería tener más de 7 líneas, ahora tiene más por tratamiento excepciones)
	 * 
	 */
	public void run() {
		boolean play = true;
		while(play) {//Para que siga pidiendo el nombre si da una excepción de nombre repetido
			try {
				userName = sessionInteractor.askUserName();   //se guarda el nombre para el ranking
				ranking.checkValidUserName(userName);
				play = false;
			}catch(GameException e) {   //puede ser lanzada por checkValidUsername()
				System.out.println(e.getMessage());
				play = true;   //debe seguir pidiendo el nombre
			}
		}
		try {
			while(!endGame) {
				executeNextOption((char)sessionInteractor.askNextOption());
			}
		}catch(RuntimeException e) {
			System.out.println("FATAL ERROR: " + e.getMessage());
			logger.log(e);
			//¿propagar hasta arriba del todo para que termine?
			endGame = true;
		}
	}
	
	
	//Setters públicos
	/**
	 * Provoca que GameSession utilice el objeto SessionInteractor recibido como parámetro
	 * @param interactor
	 */
	public void setSessionInteractor(SessionInteractor sessionInteractor) {
		ArgumentChecks.isTrue(sessionInteractor != null);
		this.sessionInteractor = sessionInteractor;
	}
	
	/**
	 * Provoca que GameSession utilice el objeto GameInteractor recibido como parámetro
	 * @param interactor
	 */
	public void setGameInteractor(GameInteractor gameInteractor) {
		ArgumentChecks.isTrue(gameInteractor != null);
		this.gameInteractor = gameInteractor;
	}
	
	/**
	 * Provoca que GameSession utilice el objeto SimpleLogger recibido como parámetro
	 * @param logger
	 */
	public void setLogger(SimpleLogger logger) {
		ArgumentChecks.isTrue(logger != null);
		this.logger = logger;
	}
	
	/**
	 * Almacena como ranking el objeto recibido como parámetro
	 * @param ranking
	 */
	public void setGameRanking(GameRanking ranking) {
		ArgumentChecks.isTrue(ranking != null);
		this.ranking = ranking;
	}
	
	private boolean askToShowRanking() {
		System.out.println("Do you want to see your ranking? (y)es, (n)o");
		char ch;
		 do {
			 ch = scan.next().charAt(0);   //para leer el valor que introduzca el usuario
		}while(ch != 'y' && ch != 'n');
		 return ch == 'y' ? true : false;
	}
	
	

	 /* Ejecuta la opción escogida por el usuario al iniciar sesión
	 * @param option
	 */
	private void executeNextOption(char option) {
		switch(option) {
			case '1':
				//pregunta dificultad, crea el game correspondiente y comienza partida
				level = sessionInteractor.askGameLevel();    //pregunta nivel de dificultad
				game = new Game(setBoardbyLevel(level));    //establece tablero según el nivel deseado
				game.setInteractor(gameInteractor);
				game.play();
				if(sessionInteractor.doYouWantToRegisterYourScore()) {
					ranking.append(new GameRankingEntry(userName, level, game.getDuration(), game.getWinner()));
				}
				if(askToShowRanking()) {
					sessionInteractor.showPersonalRanking(ranking.getEntriesForUsername(userName));
				}
				//sessionInteractor.showGoodBye();    //muestra despedida, en cualquier caso
				break;
			case '2':
				sessionInteractor.showPersonalRanking(ranking.getEntriesForUsername(userName));
				break;
			case '3':
				sessionInteractor.showRanking(ranking.getAllEntries());
				break;
			case '4':
				
			case '5':
				
			case '0':
				sessionInteractor.showGoodBye();
				endGame = true;
		}
	}
	
	/*
	 * Método para crear tablero según nivel elegido por el usuario
	 */
	private Board setBoardbyLevel(GameLevel level) {
		Board board = new Board(Board.DEFAULT_DIMENSION, Board.DEFAULT_DIMENSION, Board.DEFAULT_PERCENTAGE);
		switch(level) {
			case EASY:
				board = new Board(9, 9, 12);
				break;
			case MEDIUM:
				board = new Board(16, 16, 15);
				break;
			case HARD:
				board = new Board(30, 16, 20);
				break;
		}
		return board;
	}
	
	
	
}
