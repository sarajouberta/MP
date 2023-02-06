package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048WithBoardParamTest {
	
	/**
	 * Casos de uso:
	 * 1- Parámetro incorrecto: null --> salta una excepción
	 * 2- Parámetro incorrecto: tablero no cuadrado --> salta una excepción
	 * 3- Parámetro incorrecto: tamaño por debajo del mínimo --> salta una excepción
	 * 4- Parámetro incorrecto: tamaño por encima del máximo --> salta una excepción
	 * 5- Parámetro incorrecto: contenido distinto de potencias de 2 --> salta una excepción
	 * 6- Parámetro correcto, tamaño dentro de límites --> se crea el tablero correctamente
	 * 
	 */
	
	//1- Parámetro incorrecto: null --> salta una excepción
	@Test
	public void game2048WithBoardParamNull(){
		try {
			Game2048 game2048 = new Game2048(null);  //se intenta crear una partida con un tablero null
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e){
			assertEquals("El tablero no puede ser null", e.getMessage());
		}
	}
	
	//2- Parámetro incorrecto: tablero no cuadrado --> salta una excepción
	@Test
	public void game2048WithBoardParamNotSquare(){
		int[][] board = new int[2][4];  //se crea un tablero incorrecto para crear una partida
		try {
			Game2048 game2048 = new Game2048(board);  //se intenta crear una partida con un tablero no cuadrado
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e){
			assertEquals("El tablero debe ser cuadrado", e.getMessage());
		}
	}
	
	//3- Parámetro incorrecto: tamaño por debajo del mínimo --> salta una excepción
	@Test
	public void game2048WithBoardParamBelowMin(){
		int[][] board = new int[1][1];  //se crea un tablero incorrecto para crear una partida
		try {
			Game2048 game2048 = new Game2048(board);  //se intenta crear una partida con un tablero no cuadrado
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e){
			assertEquals("Tamaño del tablero fuera de límtes", e.getMessage());
		}
	}
	
	
	//4- Parámetro incorrecto: tamaño por encima del máximo --> salta una excepción
	@Test
	public void game2048WithBoardParamBeyondMax(){
		int[][] board = new int[6][6];  //se crea un tablero fuera del límite máximo para la partida
		try {
			Game2048 game2048 = new Game2048(board);  //se intenta crear una partida con el tablero incorrecto
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e){
			assertEquals("Tamaño del tablero fuera de límtes", e.getMessage());
		}
	}
	
	//5- Parámetro incorrecto: contiene números diferentes de potencias de 2 --> salta excepción
	@Test
	public void game2048WithBoardWrongContent() {
		int[][]board = ForTesting.generateBoardCase3();
		try {
			Game2048 game2048 = new Game2048(board);  //se intenta crear una partida con el tablero incorrecto
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e){
			assertEquals("El tablero debe contener potencias de 2", e.getMessage());
		}
	}
	
	
	
	
	//6- Parámetro correcto, tamaño dentro de límites --> se crea el tablero correctamente
	@Test
	public void game2048WithBoardParamAmongLimits() {
		int[][] board = new int[4][4];  //se crea un tablero de tamaño intermedio
		Game2048 game2048 = new Game2048(board);
		assertEquals(game2048.getBoardForTesting().length, board.length);  //se comprueba que el tablero se crea correctamente
		assertEquals(game2048.getBoardForTesting()[0].length, board[0].length);
	}
	
	
}
