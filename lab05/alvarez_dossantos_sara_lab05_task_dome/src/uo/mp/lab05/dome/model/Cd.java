package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

/**
 *
 */
public class Cd extends Item implements Borrowable {

    private String artist;
    private int playingTime;
    private int numberOfTracks;
    private boolean isAvailable;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theArtist   String for artist
     * @param tracks      integer for tracks
     * @param playingTime cd total time
     * @param basePrice   default price of the item
     */
    public Cd(String theTitle, String theArtist, int tracks, int playingTime, double basePrice) {
	super(theTitle, basePrice);
	setPlayingTime(playingTime);
	setArtist(theArtist);
	setNumberOfTracks(tracks);
	isAvailable = false; // no disponible por defecto (por defecto ownIt = false)

    }

    /**
     * 
     * @param arg String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setArtist(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid artist");

	this.artist = arg;
    }

    /**
     * 
     * @param arg integer with the number of tracks in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setNumberOfTracks(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid number of tracks");
	this.numberOfTracks = arg;
    }

    /**
     * @return artist's name
     */
    public String getArtist() {
	return this.artist;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
	return this.numberOfTracks;
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
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    // lab04
    public void print2(PrintStream out) {
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	super.print2(out);
    }

    /**
     * @return cadena con los nombres de los responsables del cd (artistas)
     */
    @Override
    public String getResponsable() {
	return this.getArtist();
    }

    @Override
    public void print() {
	print(System.out);

    }

    // lab04
    @Override
    public boolean isLike(Item item) {
	if (item instanceof Cd) {
	    Cd cd = (Cd) item;
	    if (this.getTitle()
		.equals(item.getTitle())
		    && this.getArtist()
			.equals(cd.getArtist())) {
		return true;
	    }
	}
	return false;
    }

    // lab04
    @Override
    public boolean equals(Object item) {
	if (!(item instanceof Cd)) { // caso en el que sí se puede utilizar instanceof: cast-down
	    return false;
	} else {
	    if (this.getTitle()
		.equals(((Cd) item).getTitle())
		    && this.getArtist()
			.equals(((Cd) item).getArtist())) {
		return true;
	    }
	}
	return false;
    }

    // lab04
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("CD: ");
	str.append(this.getTitle());
	str.append(" Artist: ");
	str.append(this.getArtist());
	str.append(" Number of tracks: ");
	str.append(this.getNumberOfTracks());

	return str.toString();
    }

    /**
     * Método que devuelve el precio final del Cd (precio base + 4%)
     * 
     * @return totalPrice precio total del Cd
     */
    @Override
    public double getFinalPrice() {
	double totalPrice = this.getBasePrice() + 2.0; // se suman 2e al precio base
	return totalPrice;
    }

    /**
     * Un cd está disponible si lo tienes y está disponible
     * 
     * @return isAvailable
     */
    @Override
    public boolean isAvailable() {
	return isAvailable && this.getOwn();
    }

    @Override
    public void borrow() {
	isAvailable = false;

    }

    @Override
    public void giveBack() {
	isAvailable = true;
    }

    /**
     * Público para los tests
     * 
     * @param isAvailable the isAvailable to set
     */
    public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
    }

}