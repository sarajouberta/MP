package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class Dvd extends Item {
    private String director;
    private int playingTime;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param playingTime integer for time
     * @param basePrice   precio base
     */
    public Dvd(String theTitle, String theDirector, int playingTime, double basePrice) {
	super(theTitle, basePrice);
	setPlayingTime(playingTime);
	setDirector(theDirector);
    }

    /**
     * 
     * @param arg String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setDirector(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid director");
	this.director = arg;
    }

    /**
     * 
     * @param ownIt boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * @return the director of the dvd
     */
    public String getDirector() {
	return this.director;
    }

    /**
     * 
     * @param arg integer with the playing time in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
    }

    /**
     * @return playing time
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Director: " + getDirector());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    // lab04
    public void print2(PrintStream out) {
	out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Director: " + getDirector());
	super.print2(out);
    }

    /**
     * @return cadena con los nombres de los responsables del dvd (directores)
     */
    @Override
    public String getResponsable() {
	return this.getDirector();
    }

    @Override
    public void print() {
	print(System.out);

    }

    // lab04
    @Override
    public boolean isLike(Item item) {
	if (item instanceof Dvd) {
	    Dvd dvd = (Dvd) item;
	    if (this.getTitle()
		.equals(dvd.getTitle())
		    && this.getDirector()
			.equals(dvd.getDirector())) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public boolean equals(Object item) {
	if (!(item instanceof Dvd)) { // caso en el que sí se puede utilizar instanceof: cast-down
	    return false;
	} else {
	    if (this.getTitle()
		.equals(((Dvd) item).getTitle())
		    && this.getDirector()
			.equals(((Dvd) item).getDirector())) {
		return true;
	    }
	}
	return false;
    }

    // lab04
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("DVD: ");
	str.append(this.getTitle());
	str.append("(" + this.getPlayingTime() + ")");
	str.append(" Director: ");
	str.append(this.getDirector());

	return str.toString();
    }

    @Override
    public double getFinalPrice() {
	return this.getBasePrice(); // el precio final del dvd es el precio base
    }
}
