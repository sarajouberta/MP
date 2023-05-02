package uo.mp.minesweeper.console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.session.GameLevel;
import uo.mp.minesweeper.session.SessionInteractor;

public class ConsoleSessionInteractor implements SessionInteractor{

	public static final int FIELD_SIZE = 6;
	
	GameRankingEntry entry;
	Scanner scan = new Scanner(System.in);
	
	
	/**
	 * Player name?
	 * @return String 
	 */
	public String askUserName() {
		System.out.println("Player name?");
		String name;
		//do-while para que muestre las opciones si el nombre está en blanco
		do {
			name = (String) scan.next(); //revisar docu ¿cast como el char?	
		}while(name.isBlank());
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
		System.out.println("Level? (e)asy, (m)edium, (h)ard");
		char op;
		//do-while para que muestre las opciones si el jugador marca una letra incorrecta
		do {
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
		System.out.println(" 0- Exit");
		System.out.println("Option?");
		int op;
		//do-while para que muestre las opciones si el jugador marca un nº incorrecto
		do {
			op = (int) scan.next().charAt(0);	
		}while(op < 0 && op > 3);
		return op;    
	
	}

	/**
	 * Do you want to store your score? (y)es, (n)0
	 * (save, but)
	 */
	@Override
	public boolean doYouWantToRegisterYourScore() {
		char option = scan.next().charAt(0); 
		return (option == 'y' ? true : false); 
	}

	/**
	 *  User        Date      .Hour     .Level    .Res      .Time
	 *  Dani	    09/10/21   11:55    EASY      won       234
	 */
	@Override
	public void showRanking(List<GameRankingEntry> ranking) {
		System.out.println("User          Date      .Hour    .Level    .Res    .Time");
		for(GameRankingEntry entry : ranking) {
			System.out.println(entry.getUserName() + entryToString(entry));
		}
	}

	/**
	 * Date      .Hour    .Level     .Res   .Time
	 * 09/10/21   11:55     EASY       won    234
	 */
	@Override
	public void showPersonalRanking(List<GameRankingEntry> ranking) {
		List<GameRankingEntry> personalEntries = new ArrayList<GameRankingEntry>();
		for(GameRankingEntry entryRanking : ranking) {
			//si el nombre de la entrada de ranking coincide con el de la sesion
			if(entryRanking.getUserName().contains(entry.getUserName())) {
				personalEntries.add(entryRanking);
			}
		}
		System.out.println("Date      .Hour    .Level    .Res    .Time");
		for(GameRankingEntry personalEntry : personalEntries) {
			System.out.print(entryToString(personalEntry));
		}
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
//		switch (level) {
//		case 'e':
//			return GameLevel.EASY;
//		case 'm':
//			return GameLevel.MEDIUM;
//		default:
//			return GameLevel.HARD;
//		}
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
		str.append(getEntryFieldForRanking("            "));            //¿hora?
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

	
	
}
