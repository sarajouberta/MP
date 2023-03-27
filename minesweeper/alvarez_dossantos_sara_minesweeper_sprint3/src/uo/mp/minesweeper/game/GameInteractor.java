package uo.mp.minesweeper.game;

public interface GameInteractor {

	/**
	 * Solicita al usuario un comando (s, f, u) y unas coordenadas de fila y columna.
	 * Devuelve un objeto de tipo GameMove que contiene la información facilitada por el
	 * usuario. Los parámetros rows y columns marcan el tamaño máximo de fila y
	 * columna que el usuario puede introducir.
	 * El método ha de asegurarse de que tanto el carácter de comando como las
	 * coordenadas devueltas son valores válidos (dentro de los rangos permitidos).
	 */
	GameMove askMove(int rows, int columns);
	
	/**
	 * Muestra el estado del juego al usuario. Esto incluye estado del tablero, tiempo
	empleado y banderas que quedan por colocar. elapsedTime contiene el tiempo
	empleado, y board es una referencia al objeto tablero cuya información se va a
	mostrar.
	 * @param elapsedTime el tiempo transcurrido
	 * @param board el tableros
	 */
	void showGame(long elapsedTime, Board board);

	/**
	 * Informa al usuario de que el juego ha terminado.
	 */
	void showGameFinished();
	
	/**
	 * Informa al usuario de que ha ganado el juego. Le muestra el tiempo que ha
	 * empleado, que se recibe en el parámetro elapsedTime.
	 * @param elapsedTime el tiempo transcurrido
	 */
	void showCongratulations(long elapsedTime);
	
	/**
	 * Informa al usuario de que ha pisado una casilla de mina.
	 */
	void showBooommm();

	/**
	 * Informa al usuario de que el juego está listo para comenzar.
	 */
	void showReadyToStart();
	
	
}
