package uo.mp.minesweeper.console;

import java.util.Scanner;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.GameInteractor;
import uo.mp.minesweeper.game.GameMove;

public class ConsoleGameInteractor implements GameInteractor{

	Scanner scan = new Scanner(System.in);
	
	public ConsoleGameInteractor() {
		
	}
	
	
	/*
	 * Mejora de la salida por pantallla y la forma  de interaccionar con el usuario
	 */
	@Override
	public GameMove askMove(int rows, int columns) {
		System.out.println("movement (s | f | u) ");
		char op;
		//do-while para que muestre las opciones si el jugador marca una letra incorrecta
		do {
			op = (char) scan.next().charAt(0);	
		}while(op != 's' && op != 'f' && op != 'u');
		
		int x;
		int y;
		do {
			System.out.print("Coordenada x (0, " + (rows-1) + "): ");
			x = scan.nextInt();
			System.out.println("");
		}while(x < 0 || x >= rows);
		do {
			System.out.print("Coordenada y (0, " + (columns-1) + "): ");
			y = scan.nextInt();
			System.out.println("");
		}while(y < 0 || y >= columns);
		
			System.err.println("Opción: " + op);
		return new GameMove(op, x, y); 
	}

	
	@Override
	public void showGame(long elapsedTime, Board board) {
		System.out.println("Time: " + elapsedTime/1000);
		System.out.println("Flags left: " +board.getNumberOfFlagsLeft());
		System.out.println(getFormatBoard(board));
	}

	@Override
	public void showGameFinished() {
		System.out.println("FIN DEL JUEGO");
	}

	@Override
	public void showCongratulations(long elapsedTime) {
		System.out.println("¡ENHORABUENA! ¡Ganaste!");
	}

	@Override
	public void showBooommm() {
		System.out.println("¡Oh, no! Perdiste, explotó una mina");
		
	}

	@Override
	public void showReadyToStart() {
		System.out.println("Welcome to Minesweepwer");
		System.out.println("Ready to start");
	}
	
	/*
	 * 
	 */
	private String getFormatBoard(Board board) {
		char[][] boardToPrint = board.getState();  //se guarda el estado del tablero
		StringBuilder str = new StringBuilder();
		str.append("    ");
		for (int i = 0; i < boardToPrint.length; i++) {  //para añadir nº de coordenada j
			str.append(i + "   ");
		}
		str.append("\n");   //cambiar de línea
		String separator = betweenLines(board.getNumberOfColumns()); //se obtiene el separador del tablero
		str.append(separator); //imprimir separador de líneas
		for (int i = 0; i < boardToPrint.length; i++) {  //bucle para añadir contenido de línea
			str.append(i + " ");
			str.append("| ");
			for (int j = 0; j < board.getNumberOfColumns(); j++) {
				str.append(boardToPrint[i][j]);
				if(j < board.getNumberOfColumns() -1) {  //para separar los elementos intermedios
					str.append(" | ");
				}
			}
			str.append("\n");
			str.append(separator);
		}
		return str.toString();
	}
	
	private String betweenLines(int columns) {
		StringBuilder betweenLine = new StringBuilder();
		betweenLine.append("  ");
		for (int i = 0; i < columns -1; i++) {
			betweenLine.append("+---");
		}
		betweenLine.append("+---+\n");
		return betweenLine.toString();
	}

}
