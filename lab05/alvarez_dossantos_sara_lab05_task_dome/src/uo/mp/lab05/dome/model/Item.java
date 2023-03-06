package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public abstract class Item {

    private String title;
    protected boolean gotIt;
    private String comment;
    private double basePrice;

    public Item(String theTitle, double basePrice) {
	setTitle(theTitle);
	setBasePrice(basePrice);
	setOwn(false);
	setComment("No comment");
    }

    /**
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setTitle(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid title");

	this.title = arg;
    }

    /**
     * 
     * @param ownIt boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * 
     * @param arg String with a new comment to the element
     *            If the argument is null or does not contain meaningful characters (other than blanks, new lines, etc)
     *            previous comment stays as it is
     */
    public void setComment(String arg) {
	if (arg != null && !arg.isBlank()) {
	    this.comment = arg;
	}
    }

    /**
     * @return the comment (if any) or default
     */
    public String getComment() {
	return comment;
    }

    /**
     * @return true if we own a copy; false otherwise
     */
    public boolean getOwn() {
	return gotIt;
    }

    /**
     * @return title
     */
    public String getTitle() {
	return this.title;
    }

    /**
     * Método que imprime por pantalla los datos del item
     */
    public abstract void print();

    /**
     * private String title;
     * private int playingTime;
     * protected boolean gotIt;
     * private String comment;
     */
    public void print2(PrintStream out) {
	out.println("Tittle: " + this.getTitle());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    /**
     * Método que devuelve el responsable de cada item (autor/director/creador según item)
     * 
     * @return String responsable
     */
    public abstract String getResponsable();

    /**
     * Método hecho en la sesión práctica antes de redefinir equals
     * 
     * @param item
     * @return boolean si es igual o no
     */
    public abstract boolean isLike(Item item);

    /**
     * 
     * @return el precio base del item
     */
    public double getBasePrice() {
	return basePrice;
    }

    /**
     * Establece el precio base del item
     * 
     * @param basePrice precio base
     */
    private void setBasePrice(double basePrice) {
	ArgumentChecks.isTrue(basePrice <= 1000 && basePrice >= 0, "Invalid base price");
	this.basePrice = basePrice;
    }

    /**
     * Método que devuelve el precio final de cada item (precio base + precio añadido según item)
     * 
     * @return el precio final del item
     */
    public abstract double getFinalPrice();

}