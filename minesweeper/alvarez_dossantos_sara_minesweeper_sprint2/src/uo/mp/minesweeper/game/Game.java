package uo.mp.minesweeper.game;

import java.util.Scanner;
import java.util.Timer;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.minesweeper.model.Board;

public class Game {
	
	Board board;
	Scanner scan = new Scanner(System.in);
	
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
		System.out.println("Welcome to Minesweepwer");
		System.out.println("Ready to start");
		long time = System.currentTimeMillis();
		while(!board.hasExploded()) {
			System.out.println("Time: " + (System.currentTimeMillis()-time));//contador tiempo¿?¿?¿?¿?¿?¿?¿?
			System.out.println("Flags left: " +board.getNumberOfFlagsLeft());
			System.out.println(board.toString());
			
			System.out.println("movement (s | f | u) ");
			char op;
			//do-while para que muestre las opciones si el jugador marca una letra incorrecta
			do {
				op = (char) scan.next().charAt(0);	
			}while(op != 's' && op != 'f' && op != 'u');
			
			int x;
			int y;
			do {
				System.out.print("Coordenada x (0, " + (board.getHeight()-1) + "): ");
				x = scan.nextInt();
				System.out.println("");
			}while(x < 0 || x >= board.getHeight());
			do {
				System.out.print("Coordenada y (0, " + (board.getWidth()-1) + "): ");
				y = scan.nextInt();
				System.out.println("");
			}while(y < 0 || y >= board.getWidth());
			switch(op) {
			case 's':
				board.stepOn(x, y);
				break;
			case 'f':
				board.flag(x, y);
				break;
			case 'u':
				board.unflag(x, y);
				break;
			default:
				System.err.println("Opción: " + op);
			}
		}
	}
	
	
	

}
