package uo.mp.minesweeper.ranking;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.session.GameException;

public class GameRanking {
	
	private String rankingFileName;   //temporary  ¿?¿?¿?¿?¿?
	
	/**
	 * Constructor que recibe el nombre indicando la ruta en disco al archivo de ranking.
	 */
	public GameRanking(String rankingFileName) {
		ArgumentChecks.isTrue(rankingFileName != null && !rankingFileName.isBlank());
		this.rankingFileName = rankingFileName; 
	}

	/*
	 * Almacena lista de entradas de GameRankingEntry
	 */
	private List<GameRankingEntry> entries = new ArrayList<GameRankingEntry>();

	/**
	 * Añade el objeto GameRankingEntry al final de la lista de GameRankingEntries
	 * @param gameRankingEntry 
	 */
	public void append(GameRankingEntry gameRankingEntry) {
		ArgumentChecks.isTrue(gameRankingEntry != null);
		entries.add(gameRankingEntry); //se añade al final de la lista
	}
	
	/**
	 * Devuelve una copia de la lista de gameRankingEntries
	 * @return
	 */
	public List<GameRankingEntry> getAllEntries(){
		return new ArrayList<>(entries);  //se devuelve lista-copia
	}

	/**
	 * Devuelve una lista que contiene solo aquellos gameRankingEntries cuyo usuario
	 * coincide con el userName recibido como parámetro
	 * @return
	 */
	//by, not for, but whatever
	public List<GameRankingEntry> getEntriesForUsername(String userName){
		ArgumentChecks.isTrue(userName != null && !userName.isBlank());
		List<GameRankingEntry> playerEntries = new ArrayList<GameRankingEntry>();
		for(GameRankingEntry entry: entries) {
			if(entry.getUserName().contentEquals(userName)) {      //revisar esto
				playerEntries.add(entry);
			}
		}
		return playerEntries;
	}
	
	/**
	 * (Es público para que desde GameSession se verifique que no se repite el usuario)
	 * Método que devuelve true si el nombre introducido por el usuario ya está en el ranking
	 * @param name
	 * @return
	 * @throws GameException 
	 */
	public void checkValidUserName(String name) throws GameException {
		for(GameRankingEntry entry : entries) {
			if(name.equalsIgnoreCase(entry.getUserName())) {
				throw new GameException("Username already exists in ranking.");
			}
		}
	}
	
	
	
}
