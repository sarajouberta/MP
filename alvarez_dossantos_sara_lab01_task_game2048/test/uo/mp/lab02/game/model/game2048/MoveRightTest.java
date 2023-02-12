package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;

public class MoveRightTest {

	//
	
	/*
	 * Casos de uso:
	 * 1- Tablero con huecos (0) y números consecutivos pares hacia la dcha.--> se suman las posciciones consecutivas y se compacta a la derecha
	 * 2- Tablero con huecos (0) y números consecutivos impares hacia la dcha.--> se suman las posciciones consecutivas y se compacta a la derecha
	 * 3- Tablero sin huecos, pero con números consecutivos --> se suman las posciciones consecutivas y se compacta a la derecha
	 * 4- Tablero sin números consecutivos --> no se modifica la matriz del tablero
	 * 
	 */
	
	//1- Tablero con huecos (0) y números consecutivos pares
	@Test
	public void moveRightSemifullBoardConsecutivePairPositions() {
		Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_SEMIFULL_5_PAIR);
		game2048.moveRight();
		assertArrayEquals(ForTesting.CONSECUTIVE_SEMIFULL_5_RIGHTSUM, game2048.getBoardForTesting());
	}
	
	//2- Tablero con huecos (0) y números consecutivos impares
		@Test
		public void moveRightSemifullBoardConsecutiveImpairPositions() {
			Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_SEMIFULL_5_IMPAIR);
			game2048.moveRight();
			assertArrayEquals(ForTesting.CONSECUTIVE_SEMIFULL_5_IMPAIR_SUM, game2048.getBoardForTesting());
		}
		
	
	
	//2- Tablero sin huecos, pero con números consecutivos
	@Test
	public void moveRightFullBoardConsecutivePositions() {
		Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_FULL);
		game2048.moveRight();
		assertArrayEquals(ForTesting.CONSECUTIVE_FULL_SUM, game2048.getBoardForTesting());
	}
	
	//3- Tablero sin números consecutivos
	@Test
	public void moveRightWithoutConsecutivePositions() {
		Game2048 game2048 = new Game2048(ForTesting.NOT_CONSECUTIVE_FULL);
		game2048.moveRight();
		assertArrayEquals(ForTesting.NOT_CONSECUTIVE_FULL, game2048.getBoardForTesting());
	}
	
	
	
	
	
	
}
