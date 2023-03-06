package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;


public class Circle extends Shape{

	private int radio;
	
	public Circle(int x, int y, Colour colour, int radio) {
		super(x,y,colour);
		setRadio(radio);
		this.radio = radio;
	}

	/**
	 * Implementación del método draw heredado de la superclase
	 */
	@Override
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Circle: - Radio: %d", 
				this.getColour(), radio);		
		out.println(output);
		
	}
	
	/**
	 * 
	 * @return radio
	 */
	private int getRadio() {
		return radio;
	}

	/**
	 * 
	 * @param radio 
	 */
	private void setRadio(int radio) {
		ArgumentChecks.isTrue(radio > 0, "Invalid radio");
		this.radio = radio;
	}

}
