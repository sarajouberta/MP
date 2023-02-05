package uo.mp.lab01.game.model.game2048;

public class TestUtil {

	/**
	 * Clase con métodos privados que generan tableros concretos para ser utilizados
	 * en otros tests.
	 * 
	 */
	
	public static int[][] generateBoardCase1(){
		int[][] case1Board = new int[4][4];
		for(int i = 0; i < 4; i++) {
			case1Board[i][i] = 4;
		}
		return case1Board;
		
		
	}
	
	public static int[][] generateBoardCase2(){
		int[][] case2Board = new int[3][3];
		case2Board[0][0] = 4;
		case2Board[0][1] = 8;
		case2Board[0][2] = 16;
		case2Board[1][0] = 8;
		case2Board[1][1] = 32;
		case2Board[1][2] = 64;
		case2Board[2][0] = 8;
		case2Board[2][1] = 4;
		case2Board[2][2] = 16;
		return case2Board;
	}	
}
