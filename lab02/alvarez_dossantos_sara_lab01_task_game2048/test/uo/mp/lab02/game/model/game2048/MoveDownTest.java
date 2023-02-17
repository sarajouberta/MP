package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;

public class MoveDownTest {
	
	/**
	 * Casos de uso:
	 * 1- Tablero con huecos (0) y números consecutivos hacia abajo --> se suman las posciciones consecutivas y se compacta hacia abajo.
	 * 2- Tablero sin números consecutivos --> no se modifica la matriz del tablero
	 * 3- Tablero con número impar de consecutivos --> se suman las posciciones consecutivas y se compacta hacia abajo
	 */
	
	//1- Tablero con huecos (0) y números consecutivos
	@Test
	public void moveDownSemifullBoardConsecutiveNumbers() {
		Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_SEMIFULL_5);
		game2048.moveDown();
		assertArrayEquals(ForTesting.CONSECUTIVE_SEMIFULL_5_DOWNSUM, game2048.getBoardForTesting());
	
	}
	
	//2- Tablero sin números consecutivos
	@Test
	public void moveDownWithoutConsecutivePositions() {
		Game2048 game2048 = new Game2048(ForTesting.NOT_CONSECUTIVE_FULL2);
		game2048.moveDown();
		assertArrayEquals(ForTesting.NOT_CONSECUTIVE_FULL2, game2048.getBoardForTesting());
	}
	
	//3- Tablero con número impar de consecutivos
	@Test
	public void moveDownConsecutiveImpairPositions() {
		Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_SEMIFULL_4_IMPAIR_DOWN);
		game2048.moveDown();
		assertArrayEquals(ForTesting.CONSECUTIVE_SEMIFULL_4_IMPAIR_DOWNSUM, game2048.getBoardForTesting());
	}
	
	
	
	
	
	
	
	

}
