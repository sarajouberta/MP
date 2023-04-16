package uo.mp.minesweeper.square;

import uo.mp.minesweeper.game.square.actions.Action;

public class Square {
	
	public static final int EMPTY_SQUARE = 0;
	public static final int MINE_SQUARE = -1;
	public static final int MIN_CLUE = 1;
	public static final int MAX_CLUE = 8;
	
	private SquareState state;
	private int value;
	private Action action;
	

	/**
	 * Constructor sin parámetros que crea una casilla con estado CLOSED y valor 0
	 */
	public Square() {
		state = SquareState.CLOSED;
		value = EMPTY_SQUARE;
	}
	
	/*
	 * Método para test: constructor de Square con un value determinado y un estado
	 */
	public Square(int value, SquareState state) {
		this.value = value;
		if(state == null) {
			this.state = SquareState.CLOSED;
		}else{
			this.state = state;
		}
	}
	
	
	/**
	 * Pasa la casilla a estado OPENED si está CLOSED. En caso contrario (OPENED o FLAGGED) no hace
	nada.
	 */
	public void stepOn() {
		if(state == SquareState.CLOSED) {
			state = SquareState.OPENED;
			action.execute();
		}
	}
	
	/**
	 * Si la casilla está cerrada (CLOSED), su estado pasa a FLAGGED. En caso contrario no hace nada.
	
	 */
	public void flag() {
		if(state == SquareState.CLOSED) {
			state = SquareState.FLAGGED;
		}
	}
	
	/**
	 * Si la casilla está marcada (FLAGGED), su estado pasa a CLOSED. En caso contrario no hace nada.
	
	 */
	public void unflag() {
		if(state == SquareState.FLAGGED) {
			state = SquareState.CLOSED;
		}
	}
	
	/**
	 * Pasa la casilla a estado OPENED incondicionalmente.
	 */
	public void open() {
		state = SquareState.OPENED;
	}
	
	/**
	 * Devuelve un String con el carácter que representa la casilla gráficamente de acuerdo a su valor
	 * y estado actual.
	 * ¿StringBuilder tan pequeña?
	 */
	@Override
	public String toString() {
		String str = "State: " + getSquareState() + " Value: " + getValue();
		return str;
	}
	
	/**
	 * Devuelve el valor numérico de la casilla.
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Establece el valor numérico de la casilla.
	 * @param value
	 */
	public void setValue(int value) {
		//ArgumentCheks.isTrue
		this.value = value;
	}

	/**
	 * Devuelve true si la casilla contiene una mina y false en caso contrario.
	 * @return
	 */
	public boolean hasMine() {
		if(value == MINE_SQUARE) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Coloca el valor numérico correspondiente a una mina en la casilla.
	 */
	public void putMine() {
		value = MINE_SQUARE;
	}
	
	/**
	 * Devuelve true si el estado de la casilla es FLAGGED y false en caso contrario
	 * @return
	 */
	public boolean isFlagged() {
		if(state == SquareState.FLAGGED) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Devuelve true si el estado de la casilla es OPENED y false en caso contrario.
	 * @return
	 */
	public boolean isOpened() {
		if(state == SquareState.OPENED) {
			return true;
		}else {
			return false;
		}
	}
	

	/**
	 * Obtiene el estado de la casilla
	 * @return estado de la casilla
	 */
	public SquareState getSquareState() {
		return state;
	}

	/**
	 * Establece el estado de la casilla
	 * @param state estado de la casilla
	 */
	public void setState(SquareState state) {
		this.state = state;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	
	
}

