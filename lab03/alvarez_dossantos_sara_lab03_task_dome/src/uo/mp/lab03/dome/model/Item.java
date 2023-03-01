package uo.mp.lab03.dome.model;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class Item {

    private String title;
    private int playingTime;
    protected boolean gotIt;
    private String comment;

    public Item(String theTitle, int time) {
	setTitle(theTitle);
	setPlayingTime(time);
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
     * @param arg integer with the playing time in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
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
     * @return playing time
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    public abstract void print();

    public abstract String getResponsable();
}