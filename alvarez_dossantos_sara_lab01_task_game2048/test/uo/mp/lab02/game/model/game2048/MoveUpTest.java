package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;

public class MoveUpTest {
	
	/**
	 * Casos de uso:
	 * 1- Tablero con huecos (0) y números consecutivos hacia arriba --> se suman las posciciones consecutivas y se compacta hacia arriba.
	 * 2- Tablero sin números consecutivos --> no se modifica la matriz del tablero
	 */
	
	//1- Tablero con huecos (0) y números consecutivos
	@Test
	public void moveUpSemifullBoardConsecutiveNumbers() {
		Game2048 game2048 = new Game2048(ForTesting.CONSECUTIVE_SEMIFULL_5_PAIR);
		game2048.moveUp();
		assertArrayEquals(ForTesting.CONSECUTIVE_SEMIFULL_5_UPSUM, game2048.getBoardForTesting());
	
	}
	
	//2- Tablero sin números consecutivos
	@Test
	public void moveUpWithoutConsecutivePositions() {
		Game2048 game2048 = new Game2048(ForTesting.NOT_CONSECUTIVE_FULL2);
		game2048.moveUp();
		assertArrayEquals(ForTesting.NOT_CONSECUTIVE_FULL2, game2048.getBoardForTesting());
	}

}
