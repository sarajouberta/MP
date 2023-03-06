package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class Triangle extends Shape{
	
	private int x2;  //coordenadas en el lienzo: un par por vértice
	private int y2;
	private int x3;
	private int y3;


	public Triangle(int x, int y, int x2, int y2, int x3, int y3, Colour colour) {
		super(x, y, colour);
		setX2(x2);
		setY2(y2);
		setX3(x3);
		setY3(y3);
	}

	@Override
	public void draw(PrintStream out) {
		
		
	}
	
	
	private int getX2() {
		return x2;
	}

	private void setX2(int x2) {
		ArgumentChecks.isTrue(x2  > 0, "invalid x2");
		this.x2 = x2;
	}

	private int getY2() {
		return y2;
	}

	private void setY2(int y2) {
		ArgumentChecks.isTrue(y2  > 0, "invalid y2");
		this.y2 = y2;
	}

	private int getX3() {
		return x3;
	}

	private void setX3(int x3) {
		ArgumentChecks.isTrue(x3  > 0, "invalid x3");
		this.x3 = x3;
	}

	private int getY3() {
		return y3;
	}

	private void setY3(int y3) {
		ArgumentChecks.isTrue(y3  > 0, "invalid y3");
		this.y3 = y3;
	}

}
