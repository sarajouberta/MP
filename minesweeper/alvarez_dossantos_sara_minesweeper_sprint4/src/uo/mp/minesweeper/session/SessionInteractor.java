package uo.mp.minesweeper.session;

import java.util.List;

import uo.mp.minesweeper.ranking.GameRankingEntry;

public interface SessionInteractor {
	
	/**
	 * Solicita al usuario un nivel de dificultad y devuelve la
	 * respuesta con un GameLevel
	 * @return
	 */
	public GameLevel askGameLevel();
	
	/**
	 * Solicita al usuario su nombre y devuelve un String con la respuesta. El nombre que
	 * devuelve no puede ser vacío
	 * @return
	 */
	public String askUserName();
	
	/**
	 * Solicita al usuario que introduzca una opción del menú de sesión. Devuelve un entero que
	 * representa la opción escogida de entre las posibles. Un valor mayor que cero representará
	 * alguna de las acciones disponibles. El valor cero representará siempre la opción salir
	 * @return
	 */
	public int askNextOption();
	
	/**
	 * Al finalizar una partida, pregunta al usuario si quiere guardar su puntuación. Devuelve true
	 * si la respuesta es afirmativa, y false en caso contrario
	 * @return
	 */
	public boolean doYouWantToRegisterYourScore();
	
	/**
	 * Recibe una lista de objetos GameRankingEntry representando todas las puntuaciones
	 * registradas en el sistema. Se muestra con su información completa (formato tabular, una
	 * línea por cada GameRankingEntry)
	 * @param ranking
	 */
	public void showRanking(List<GameRankingEntry> ranking);
	
	/**
	 * Recibe una lista de objetos GameRankingEntry representando todas las puntuaciones
	 * registradas en el sistema. Se muestra con su información completa (formato tabular, una
	 * línea por cada GameRankingEntry). Omite la información de quién es el usuario
	 * asociado a cada partida (se sobreentiende que es el usuario almacenado en la sesión)
	 * @param ranking
	 */
	public void showPersonalRanking(List<GameRankingEntry> ranking);
	
	/**
	 * Muestra al usuario un mensaje de despedida cuando escoge finalizar la sesión
	 */
	public void showGoodBye();
	
	/**
	 * Comunica un mensaje de error al usuario. El mensaje a mostrar se recibe como
	 * parámetro
	 * @param message
	 */
	public void showErrorMessage(String message);
	
	/**
	 * Comunica mensajes de error graves al usuario. Este método ha de usarse para informar de
	 * que el error no puede ser solucionado y el programa finalizará su ejecución de forma
	 * inmediata
	 * @param message
	 */
	public void showFatalErrorMessage(String message);
	
	
	
	
	
	
	
	
	
	
	
	
}
