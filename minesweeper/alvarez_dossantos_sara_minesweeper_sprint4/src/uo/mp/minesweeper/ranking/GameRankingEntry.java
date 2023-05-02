package uo.mp.minesweeper.ranking;

import java.sql.Date;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.session.GameLevel;

public class GameRankingEntry {
	
	private String userName;
	private GameLevel level;
	private long duration;
	private boolean hasWon;
	Date date;
	
	
	/**
	 * Constructor de GameRankingEntry. Cada instancia almacena la puntuación de una partida
	 * @param userName nombre del usuario que jugó la partida
	 * @param level nivel de dificultad
	 * @param duration tiempo de duración de la partida
	 * @param hasWon true si ganó la partida, false en caso contrario
	 */
	public GameRankingEntry(String userName, GameLevel level, long duration, boolean
			hasWon) {
		setUserName(userName);
		setLevel(level);
		setDuration(duration);
		setHasWon(hasWon);
		date = new Date(System.currentTimeMillis());   //el constructor guarda la fecha
	}


	/**	
	 * Devuelve una representación textual del contenido del objeto
	 */
	@Override
	public String toString() {
		return "GameRankingEntry [userName: " + userName + ", level: " + level + ", duration: " + duration + ", hasWon="
				+ hasWon + ", date" + getDateToString() + "]";
	}

	/**
	 * Método privado para formatear la fecha del objeto GameRankingEntry
	 * @return String con fecha formateada 
	 */
	public String getDateToString() {
		return String.format("%td/%<tm/%<ty", date);
	}

	/**
	 * Devuelve el nombre del jugador de la partida
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Establece el nombre del jugador de la partida
	 * @param userName
	 */
	private void setUserName(String userName) {
		ArgumentChecks.isTrue(userName != null && !userName.isBlank());
		this.userName = userName;
	}

	/**
	 * Devuelve el nivel de la partida
	 * @return
	 */
	public GameLevel getLevel() {
		return level;
	}

	/**
	 * Establece el nivel de la partida
	 * @param level
	 */
	private void setLevel(GameLevel level) {
		ArgumentChecks.isTrue(level != null);
		this.level = level;
	}

	/**
	 * Devuelve la duración de la partida
	 * @return
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Establece la duración de la partida
	 * @param duration
	 */
	private void setDuration(long duration) {
		ArgumentChecks.isTrue(duration >= 0);
		this.duration = duration;
	}

	/**
	 * Devuelve true si el jugador ha ganado la partida, false en caso contrario
	 * @return
	 */
	public boolean isHasWon() {
		return hasWon;
	}

	/**
	 * Establece el valor true si se ha ganado la partida, false en caso contrario
	 * @param hasWon
	 */
	private void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	
	public String getHasWonToString() {
		return this.hasWon ? "won" : "lost";
	}
	
	public String getLevelToString() {
		return this.level == GameLevel.EASY ? "EASY" :(this.level == GameLevel.MEDIUM ? "MEDIUM" : "HARD");
	}
	
	
}
