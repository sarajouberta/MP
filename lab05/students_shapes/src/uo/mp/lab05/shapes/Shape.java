package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

public abstract class Shape implements Drawable{

	private int x;
	private int y;
	private Colour colour;
	
	public Shape(int x, int y, Colour colour) {
		ArgumentChecks.isTrue(x > 0, "invalid x");
		ArgumentChecks.isTrue(y > 0, "invalid y");
		ArgumentChecks.isTrue(colour != null, "invalid colour");
		this.x = x;
		this.y = y;
		this.colour = colour;
		
	}
	

	/**
	 * Método para que cada sublase de Shape implemente:
	 */
	@Override
	public abstract void draw(PrintStream out);




	protected int getX() {
		return x;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected int getY() {
		return y;
	}

	protected void setY(int y) {
		this.y = y;
	}

	protected Colour getColour() {
		return colour;
	}

	protected void setColour(Colour colour) {
		this.colour = colour;
	}

	
}
