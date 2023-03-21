package uo.mp.minesweeper;

import uo.mp.minesweeper.game.Game;
import uo.mp.minesweeper.model.Board;

public class Main {

	private Game game;

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		Board board = new Board(9, 9, 12 /* % */);
		game = new Game( board );
		return this;
	}

	private void run() {
		game.play();
	}

}
