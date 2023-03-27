package uo.mp.minesweeper.game;

import java.text.Format;

import uo.mp.lab.util.check.ArgumentChecks;

public class GameMove {
	
	private char op;
	private int row;
	private int column;

	/*
	 * Clase contenedora de datos para recoger una acción de usuario completa:
	 * 	operación
	 * 	fila
	 * 	columna
	 */
	
	/**
	 * Constructor de la clase GameMove.
	 */
	public GameMove(char operation, int row, int column) {
		setOperation(operation);
		setRow(row);
		setColumn(column);
	}

	/**
	 * Devuelve el caracter que representa la operación del usuario
	 * @return
	 */
	public char getOperation() {
		return op;
	}

	/**
	 * Devuelve la coordenada de la fila
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Devuelve la coordenada de la columna
	 * @return
	 */
	public int getColumn() {
		return column;
	}

	
	/*
	 * Setters para validar parámetros y establecerlos en los atributos
	 */
	private void setOperation(char operation) {
		ArgumentChecks.isTrue(operation != ' ', "invalid operation");
		this.op = operation;
	}

	private void setRow(int row) {
		ArgumentChecks.isTrue(row >= 0, "invalid row");
		this.row = row;
	}

	private void setColumn(int column) {
		ArgumentChecks.isTrue(column >= 0, "invalid column");
		this.column = column;
	}
	
	/**
	 * Devuelve una representación textual del comando completo con el siguiente
	 * formato: GameMove [operation=s, row=1, column=1 ]
	 */
	public String toString() {
		String str = String.format("GameMove [operation=%c, row=%d, column=%d ]", getOperation(), getRow(),
				getColumn());
		return str;
	}
	
	
	
	
}
