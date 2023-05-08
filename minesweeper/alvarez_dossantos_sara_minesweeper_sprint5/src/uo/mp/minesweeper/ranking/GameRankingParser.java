package uo.mp.minesweeper.ranking;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import uo.mp.util.fileUtil.BaseFileUtil;
import uo.mp.util.fileUtil.TextFileUtil;

public class GameRankingParser {
	
	private BaseFileUtil bs = new TextFileUtil();
	
	/**
	 * Clase para gestionar la transformación del archivo donde se guarda el ranking en disco
	 * a los objetos GameRankingEntry que se cargan en el ranking en cada sesión
	 * @throws FileNotFoundException 
	 */
	public GameRankingEntry parse(String rankingNameFile) throws FileNotFoundException {
		List<String> lines = new ArrayList<String>();
		lines = bs.readLines(rankingNameFile);
		for(String line : lines) {
			//line.parse();
		}
		
		return null;
	}
	
}
