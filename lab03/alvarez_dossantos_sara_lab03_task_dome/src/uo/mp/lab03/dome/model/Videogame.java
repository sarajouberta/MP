package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

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
    public Videogame(String theTitle, String author, String owner, int numberOfUsers, VideogamePlatform platform) {
	super(theTitle, 1); // valor 1 para playingTime porque el videojuego no tiene (ni lo usará)
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

    @Override
    public void print() {
	print(System.out);

    }

}
