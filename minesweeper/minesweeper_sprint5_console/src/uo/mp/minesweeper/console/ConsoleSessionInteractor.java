package uo.mp.minesweeper.console;

import java.util.List;
import java.util.Scanner;

import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.session.GameLevel;
import uo.mp.minesweeper.session.SessionInteractor;

public class ConsoleSessionInteractor implements SessionInteractor{

	public static final int FIELD_SIZE = 12;
	
	GameRankingEntry entry;
	Scanner scan = new Scanner(System.in);
	
	
	/**
	 * Player name?
	 * @return String 
	 */
	public String askUserName() {
		String name;
		//do-while para que siga pidiendo el nombre está en blanco
		do {
			System.out.println("Player name (lower case)?");
			name = (String) scan.next(); //revisar docu ¿cast como el char?	
		}while(name.isBlank() || name != name.toLowerCase());  //comprobar también que solo contiene minus
		return name;
	}
	
	
	/**
	 * Thanks for your session. Bye bye!
	 */
	public void showGoodBye() {
		System.out.println("Thanks for your session. Bye!");
	}

	/**
	 * Level? (e)asy, (m)edium, (h)ard
	 * @return
	 */
	@Override
	public GameLevel askGameLevel() {
		char op;
		//do-while para que muestre las opciones si el jugador marca una letra incorrecta
		do {
			System.out.println("Level? (e)asy, (m)edium, (h)ard");
			op = (char) scan.next().charAt(0);	
		}while(op != 'e' && op != 'm' && op != 'h');
		return charToLevel(op);    //método privado para devolver GameLevel equivalente
	}

	/**
	 * Available options:
	 *  1- Play a new game
	 *  2- Show my results
	 *  3- Show all results
	 *  0- Exit
	 * Option?
	 * @return
	 */
	@Override
	public int askNextOption() {
		System.out.println("Available options:");
		System.out.println(" 1- Play a new game");
		System.out.println(" 2- Show my results");
		System.out.println(" 3- Show all results");
		System.out.println(" 4- Export results");
		System.out.println(" 5- Import results");
		System.out.println(" 0- Exit");
		char op;     //char: no funcionaba bien como int
		//do-while para que muestre las opciones si el jugador marca un nº incorrecto
		do {
			System.out.println("Option?");
			op = scan.next().charAt(0);	   //recoge el int correspondiente al char introducido
		}while(op != '1' && op != '2' && op != '3' && op != '0' && op != '4' && op != '5');
		return op;    
	}

	/**
	 * Do you want to store your score? (y)es, (n)o
	 * (save, but)
	 */
	@Override
	public boolean doYouWantToRegisterYourScore() {
		System.out.println("Do you want to store your score? (y)es, (n)o");
		char option = scan.next().charAt(0); 
		return (option == 'y' ? true : false); 
	}

	/**
	 *  User        Date      .Hour     .Level    .Res      .Time
	 *  Dani	    09/10/21   11:55    EASY      won       234
	 */
	@Override
	public void showRanking(List<GameRankingEntry> ranking) {
		System.out.println("User         Date      .Hour    .Level    .Res    .Time");
		for(GameRankingEntry entry : ranking) {
			System.out.println(entry.getUserName() + entryToString(entry) + "\n");
		}
	}

	/**
	 * Date      .Hour     .Level     .Res   .Time
	 * 09/10/21   11:55     EASY       won    234
	 */
	@Override
	public void showPersonalRanking(List<GameRankingEntry> ranking) {
		System.out.println("Date       .Hour       .Level      .Res        .Time");
		for(GameRankingEntry personalEntry : ranking) {
			System.out.print(entryToString(personalEntry) + "\n");
		}
		System.out.println();  //deja línea en blanco para que no se pegue al siguiete menú
	}

	@Override
	public void showErrorMessage(String message) {
		System.out.println("An error has ocurred: " + message);
		
	}

	@Override
	public void showFatalErrorMessage(String message) {
		System.out.println("A fatal error has ocurred: " + message);
		
	}
	
	/**
	 * Método privado para convertir char al GameLevel correspondiente
	 * @param level
	 * @return GameLevel correspondiente
	 */
	private GameLevel charToLevel(char level) {
		return (level == 'e' ? GameLevel.EASY: (level == 'm' ? GameLevel.MEDIUM : GameLevel.HARD));
	}
	
	
	
	/*
	 * Método privado que convierte el nombre de usuario de cada entrada del ranking en string,
	 * para imprimir los datos en la tabla de ranking
	 */
	private String getUserNameToString(GameRankingEntry entry) {
		StringBuilder str = new StringBuilder();
		str.append(getEntryFieldForRanking(entry.getUserName()));
		return str.toString();
	}
	
	/*
	 * Método privado que convierte los datos de cada entrada del ranking en string,
	 * para mostrar también en el ranking personal (sin nombre de usuario)
	 * (Date      .Hour    .Level     .Res   .Time)
	 */
	private String entryToString(GameRankingEntry entry) {
		StringBuilder str = new StringBuilder();
		str.append(getEntryFieldForRanking(entry.getDateToString()));
		str.append(getEntryFieldForRanking(entry.getHourToString()));            //¿hora?
		str.append(getEntryFieldForRanking(entry.getLevelToString()));
		str.append(getEntryFieldForRanking(entry.getHasWonToString()));
		str.append(getEntryFieldForRanking(String.valueOf(entry.getDuration())));      //¿duration?
		return str.toString();
	}
	
	/*
	 * Método privado que formatea un campo para que tenga el tamaño deseado
	 */
	private String getEntryFieldForRanking(String field) {
		StringBuilder str = new StringBuilder();
		if(field.length() > FIELD_SIZE) {
			str.append(field.substring(0, FIELD_SIZE -1)); //si el campo es demasiado grande, se trunca
		}else {
			str.append(field);   //en caso contrario, se rellena de espacios para alinearse con los demás
			for (int i = field.length(); i < FIELD_SIZE; i++) {
				str.append(" ");
			}
		}
		return str.toString();
	}


	public GameRankingEntry getEntry() {
		return entry;
	}


	public void setEntry(GameRankingEntry entry) {
		this.entry = entry;
	}
	
	

	
	
}
