package uo.mp.minesweeper.game.square.actions;

import uo.mp.minesweeper.session.GameException;

public interface Action {

	public void execute() throws GameException;
}
