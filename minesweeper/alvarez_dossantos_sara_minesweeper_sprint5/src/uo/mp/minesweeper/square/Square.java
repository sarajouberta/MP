package uo.mp.minesweeper.square;

import uo.mp.minesweeper.game.square.actions.Action;
import uo.mp.minesweeper.session.GameException;

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
	 * Pasa la casilla a estado OPENED si está CLOSED. En caso contrario (FLAGGED) no hace
	 * nada.
	 * Modificado sprint 4: tratamiento excepciones (no opened a opened)
	 * @throws GameException 
	 */
	public void stepOn() throws GameException {
		if(state == SquareState.CLOSED) {
			state = SquareState.OPENED;
			action.execute();
		}else if(state == SquareState.OPENED){
			throw new GameException("Square already opened");
		}
	}
	
	/**
	 * Si la casilla está cerrada (CLOSED), su estado pasa a FLAGGED. En caso contrario no hace nada.
	 *  Modificado sprint 4: tratamiento excepciones
	 * @throws GameException 
	
	 */
	public void flag() throws GameException {
		if(state == SquareState.CLOSED) {
			state = SquareState.FLAGGED;
		}else if(state == SquareState.FLAGGED){
			throw new GameException("Square already flagged");
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
	 * Modificado sprint 4: tratamiento excepciones
	 * @throws GameException 
	 */
	public void open() throws GameException {
		if(state == SquareState.OPENED) {
			throw new GameException("Square already opened");
		}else {
			state = SquareState.OPENED;
		}
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

