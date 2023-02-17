package uo.mp.lab02.game.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.lab.util.console.Console;
import uo.mp.lab02.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase principal
 * </p>
 * <p>
 * Descripci�n: 2048 es un juego en l�nea creado por Gabriele Cirulli. El
 * objetivo del juego es combinar n�meros juntos (potencias de 2) con el fin de
 * alcanzar el m�ximo n�mero 2048 y ganar el juego. Para mover los n�meros en el
 * tablero, se debe elegir una direcci�n (arriba, derecha, abajo o izquierda).
 * Todos los n�meros se mueven en la direcci�n elegida y pueden ocurrir dos
 * cosas: los n�meros se juntan en una celda que tiene el mismo n�mero o son
 * bloqueados si una celda contiene un n�mero diferente.
 * 
 * <p>
 * Copyright: Copyright (c) 2022
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Universidad de Oviedo
 * </p>
 * 
 * @author Sara Álvarez Dos Santos
 * @version 13/2/23
 */

public class GameApp {
	private Game2048 game;

	public void run() {
		do {
			play();
		} while (userWantsAnotherPlay());
	}

	public void play() {

		game = new Game2048();

		showTitle();
		game.restart();
		do {
			System.out.println(game.toString());
			System.out.print("Elige una direcci�n [r R]/[l L]/[u U]/[d D]: ");
			switch (Console.readCharacter()) {
			case 'r':
			case 'R':
				game.moveRight();
				game.next();
				break;
			case 'l':
			case 'L':
				game.moveLeft();
				game.next();
				break;
			case 'u':
			case 'U':
				game.moveUp();
				game.next();
				break;
			case 'd':
			case 'D':
				game.moveDown();
				game.next();
				break;
			}

		} while (!game.isFinished());  //modificado task02

		showGameOver();
	}

	/**
	 * Muestra el t�tulo del juego
	 */
	private void showTitle() {
		System.out.print("2048 GAME\n");
	}

	/**
	 * Muestra final del juego
	 */
	private void showGameOver() {
		System.out.println("GAME OVER");
	}

	/**
	 * Pregunta al usuario si quiere continuar
	 * @return true true quiere continuar y false en caso contrario
	 */
	private boolean userWantsAnotherPlay() {
		System.out.print("�Quieres continuar? s/n: ");
		return  Console.readCharacter()== 's';
	}

	
}
