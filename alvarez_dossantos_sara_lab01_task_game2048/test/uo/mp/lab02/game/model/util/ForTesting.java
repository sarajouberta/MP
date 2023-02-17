package uo.mp.lab02.game.model.util;

public class ForTesting {
	
	public static int[][] SEMIFULL11 = {{0,2,0},{0,4,0},{0,8,0}};
	public static int[][] SEMIFULL12 = {{2,0,0},{4,0,0},{8,0,0}};
	public static int[][] SEMIFULL13 = {{0,0,2},{0,0,4},{0,0,8}};
	public static int[][] SEMIFULL1_RIGHTCOMPACTED = {{0,0,2},{0,0,4},{0,0,8}};
	public static int[][] SEMIFULL1_LEFTCOMPACTED = {{2,0,0},{4,0,0},{8,0,0}};
	
	public static int[][] SEMIFULL21 = {{0,2,4},{0,4,8},{0,8,16}};
	public static int[][] SEMIFULL22 = {{2,4,0},{4,8,0},{8,16,0}};
	public static int[][] SEMIFULL23 = {{2,0,4},{4,0,8},{8,0,16}};
	public static int[][] SEMIFULL2_RIGHTCOMPACTED = {{0,2,4},{0,4,8},{0,8,16}};
	public static int[][] SEMIFULL2_LEFTCOMPACTED = {{2,4,0},{4,8,0},{8,16,0}};
	
	public static int[][] FULL = {{2,4,8},{4,8,16},{8,16,32}};
	
		
	public static int[][] SEMIFULL31 = {{0,0,0},{0,0,0},{2,4,8}};
	public static int[][] SEMIFULL32 = {{0,0,0},{2,4,8},{0,0,0}};
	public static int[][] SEMIFULL33 = {{2,4,8},{0,0,0},{0,0,0}};
	public static int[][] SEMIFULL3_UPCOMPACTED = {{2,4,8},{0,0,0},{0,0,0}};
	public static int[][] SEMIFULL3_DOWNCOMPACTED = {{0,0,0},{0,0,0},{2,4,8}};
	
	public static int[][] SEMIFULL41 = {{0,0,0},{2,4,8},{4,8,16},};
	public static int[][] SEMIFULL42 = {{2,4,8},{0,0,0},{4,8,16}};
	public static int[][] SEMIFULL43 = {{2,4,8},{4,8,16},{0,0,0}};
	public static int[][] SEMIFULL4_UPCOMPACTED = {{2,4,8},{4,8,16},{0,0,0}};
	public static int[][] SEMIFULL4_DOWNCOMPACTED = {{0,0,0},{2,4,8},{4,8,16}};
	
	
	/**
	 * Suma todos los valores de la matriz que recibe como par�metro
	 * @param matrix la matriz recibida
	 * @return resultado de la suma
	 */
	public static int getSum(int[][] matrix) {
		int cont = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				cont = cont + matrix[i][j];
		return cont;
	}
	
	
	
	
	
	/**
	 * Métodos y variables estáticas que se añaden para generar otras matrices necesarias para hacer tests:
	 */
	
	public static int[][] EMPTY = {{0,0,0},
			                       {0,0,0},
			                       {0,0,0}};
	
	
	/*public static int[][] pruebaleft = {{2,2,0},
                                          {2,2,0},
                                          {2,2,0}};
	public static int[][] pruebaleftResultado = {{4,0,0},
                                                 {4,0,0},
                                                 {4,0,0}};*/
	public static int[][] pruebaUp = {{2,2,2},
    {2,2,2},
    {0,0,0}};
	public static int[][] pruebaUpResultado = {{4,4,4},
           {0,0,0},
           {0,0,0}};
	
	
	public static int[][] CONSECUTIVE_SEMIFULL_5 = {{2,2,0,2,2},
			                                             {2,2,0,2,2},
                                                         {2,2,0,2,2},
			                                             {2,2,0,2,2},
			                                             {2,2,0,2,2}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_IMPAIR = {{0,0,2,2,2},
                                                           {0,0,2,2,2},
                                                           {0,0,2,2,2},
                                                           {0,0,2,2,2},
                                                           {0,0,2,2,2}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_IMPAIR_SUM = {{0,0,0,2,4},
            {0,0,0,2,4},
            {0,0,0,2,4},
            {0,0,0,2,4},
            {0,0,0,2,4}};
	
	
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_RIGHTSUM = {{0,0,0,4,4},
                                                             {0,0,0,4,4},
                                                             {0,0,0,4,4},
                                                             {0,0,0,4,4},
                                                             {0,0,0,4,4}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_LEFTSUM = {{4,4,0,0,0},
                                                            {4,4,0,0,0},
                                                            {4,4,0,0,0},
                                                            {4,4,0,0,0},
                                                            {4,4,0,0,0}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_UPSUM = {{4,4,0,4,4},
                                                          {4,4,0,4,4},
                                                          {2,2,0,2,2},
                                                          {0,0,0,0,0},
                                                          {0,0,0,0,0}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_5_DOWNSUM = {{0,0,0,0,0},
                                                            {0,0,0,0,0},
                                                            {2,2,0,2,2},
                                                            {4,4,0,4,4},
                                                            {4,4,0,4,4}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR = {{0,2,2,2},
														  {0,2,2,2},
														  {0,2,2,2},
														  {0,2,2,2}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_RIGHTSUM = {{0,0,2,4},
			                                                        {0,0,2,4},
			                                                        {0,0,2,4},
			                                                        {0,0,2,4}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_UP = {{2,2,2,2},
			{2,2,2,2},
			{2,2,2,2},
            {0,0,0,0}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_UPSUM = {{4,4,4,4},
			{2,2,2,2},
			{0,0,0,0},
            {0,0,0,0}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_DOWN = {{0,0,0,0},
			{2,2,2,2},
			{2,2,2,2},
			{2,2,2,2}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_DOWNSUM = {{0,0,0,0},
			{0,0,0,0},
			{2,2,2,2},
			{4,4,4,4}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_LEFT = {{2,2,2,0},
			  {2,2,2,0},
			  {2,2,2,0},
			  {2,2,2,0}};
	
	public static int[][] CONSECUTIVE_SEMIFULL_4_IMPAIR_LEFTSUM = {{4,2,0,0},
			  {4,2,0,0},
			  {4,2,0,0},
			  {4,2,0,0}};
	

	
	

	public static int[][] CONSECUTIVE_FULL = {{2,2,8,4,4},
                                              {2,2,8,4,4},
                                              {2,2,8,4,4},
                                              {2,2,8,4,4},
                                              {2,2,8,4,4}};
	
	public static int[][] CONSECUTIVE_FULL_SUM = {{0,0,4,8,8},
                                                  {0,0,4,8,8},
                                                  {0,0,4,8,8},
								                  {0,0,4,8,8},
								                  {0,0,4,8,8}};
	
	public static int[][] NOT_CONSECUTIVE_FULL = {{2,4,2,8,16},
                                                  {2,4,2,8,16},
                                                  {2,4,2,8,16},
                                                  {2,4,2,8,16},
                                                  {2,4,2,8,16}};
	
	public static int[][] NOT_CONSECUTIVE_FULL2 = {{2,2,2,2,2},
                                                   {4,4,4,4,4},
                                                   {8,8,8,8,8},
                                                 {16,16,16,16,16},
                                                   {2,2,2,2,2}};
	
	
	

	//Genera una matriz cuadrada con potencias de 2 solo en la diagonal.
	
	public static int[][] generateBoardCase1(){
		int[][] case1Board = new int[4][4];
		for(int i = 0; i < 4; i++) {
			case1Board[i][i] = 4;
		}
		return case1Board;	
	}
	
	//Genera una matriz cuadrada con potencias de 2, completamente rellena.
	
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
	
	//Genera una matriz cuadrada incorrecta (contiene números distintos de potencias de 3.
	
	public static int[][] generateBoardCase3(){
		int[][] case3Board = new int[3][3];
		case3Board[0][0] = 4;
		case3Board[0][1] = 15;
		case3Board[0][2] = 16;
		case3Board[1][0] = 8;
		case3Board[1][1] = 30;
		case3Board[1][2] = 61;
		case3Board[2][0] = 8;
		case3Board[2][1] = 4;
		case3Board[2][2] = 16;
		return case3Board;
	}


}
