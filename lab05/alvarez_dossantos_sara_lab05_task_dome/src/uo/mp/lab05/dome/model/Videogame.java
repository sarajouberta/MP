package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class Videogame extends Item {

    private String author;
    private String owner;
    private int numbereOfUsers;
    private VideogamePlatform platform;

    /**
     * 
     * @param theTitle
     * @param author
     * @param owner
     * @param numberOfUsers
     * @param platform
     */
    public Videogame(String theTitle, String author, String owner, int numberOfUsers, VideogamePlatform platform,
	    double basePrice) {
	super(theTitle, basePrice);
	setAuthor(author);
	setOwner(owner);
	setNumbereOfUsers(numberOfUsers);
	setPlatform(platform);
    }

    /**
     * 
     * @return
     */
    private String getAuthor() {
	return author;
    }

    /**
     * 
     * @param author
     */
    private void setAuthor(String author) {
	ArgumentChecks.isTrue(author != null, "Invalid author");
	this.author = author;
    }

    /**
     * 
     * @return
     */
    private String getOwner() {
	return owner;
    }

    /**
     * 
     * @param owner
     */
    private void setOwner(String owner) {
	ArgumentChecks.isTrue(owner != null, "Invalid owner");
	this.owner = owner;
    }

    /**
     * 
     * @return
     */
    private int getNumbereOfUsers() {
	return numbereOfUsers;
    }

    /**
     * 
     * @param numbereOfUsers
     */
    private void setNumbereOfUsers(int numbereOfUsers) {
	ArgumentChecks.isTrue(numbereOfUsers >= 0, "Invalid number of users");
	this.numbereOfUsers = numbereOfUsers;
    }

    /**
     * 
     * @return
     */
    private VideogamePlatform getPlatform() {
	return platform;
    }

    /**
     * 
     * @param platform
     */
    private void setPlatform(VideogamePlatform platform) {
	ArgumentChecks.isTrue(platform != null, "Invalid platform");
	this.platform = platform;
    }

    /**
     * 
     */
    @Override
    public String getResponsable() {
	return author;
    }

    /**
     * 
     * @param out
     */
    public void print(PrintStream out) {
	out.println("Videogame: " + getTitle());
	out.println("Author: " + getAuthor());
	out.println("Owner: " + getOwner());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
	out.println("Number of users: " + getNumbereOfUsers());
	out.println("Plataforma: " + getPlatform());
    }

    // lab04
    public void print2(PrintStream out) {
	out.println("Videogame: " + getTitle());
	out.println("Platform: " + getPlatform());
	super.print2(out);
    }

    @Override
    public void print() {
	print(System.out);

    }

    // lab04
    @Override
    public boolean isLike(Item item) {
	if (item instanceof Videogame) {
	    Videogame videogame = (Videogame) item;
	    if (this.getTitle()
		.equals(videogame.getTitle())
		    && this.getPlatform()
			.equals(videogame.getPlatform())) {
		return true;
	    }
	}
	return false;
    }

    // lab04
    @Override
    public boolean equals(Object item) {
	if (!(item instanceof Videogame)) { // caso en el que sí se puede utilizar instanceof: cast-down
	    return false;
	} else {
	    if (this.getTitle()
		.equals(((Videogame) item).getTitle())
		    && this.getPlatform()
			.equals(((Videogame) item).getPlatform())) {
		return true;
	    }
	}
	return false;
    }

    // lab04
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("Videogame: ");
	str.append(this.getTitle());
	str.append(" Platform: ");
	str.append(this.getPlatform());

	return str.toString();
    }

    @Override
    public double getFinalPrice() {
	double totalPrice = this.getBasePrice() + (this.getBasePrice() * 0.1); // se suma el 10% al precio base
	return totalPrice;
    }

}
