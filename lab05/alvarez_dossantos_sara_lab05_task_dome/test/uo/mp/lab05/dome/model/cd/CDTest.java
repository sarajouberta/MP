package uo.mp.lab05.dome.model.cd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;

/**
 * Constructor with parameters
 * Scenarios
 * 
 * - Valid arguments
 * - Invalid title, null.
 * - Invalid title, blanks.
 * - Invalid artist, null
 * - Invalid artist, blanks
 * - Invalid playingTime menor que 0
 * - Invalid playingTime = 0
 * - Invalid tracks menor que 0
 * - Invalid tracks = 0
 */
public class CDTest {

    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;
    private double theBasePrice;

    @BeforeEach
    public void setUp() {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	theBasePrice = 10.90;
    }

    /**
     * GIVEN valid arguments
     * WHEN new Cd(arguments)
     * THEN a new Cd is created with that attributes
     */
    @Test
    public void validParams() {
	Cd cd = new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);

	assertEquals("Come Together", cd.getTitle());
	assertEquals("Beatles", cd.getArtist());
	assertEquals(70, cd.getPlayingTime());
	assertEquals(4, cd.getNumberOfTracks());
	assertEquals(false, cd.getOwn());
	assertEquals("No comment", cd.getComment());
	assertEquals(10.9, cd.getBasePrice());

    }

    /**
     * GIVEN valid arguments, except title = null
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullTitle() {
	theTitle = null;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except title = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankTitle() {
	theTitle = "    ";
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except title = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyTitle() {
	theTitle = "";
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except artist = null
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullArtist() {
	theArtist = null;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid artist", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except artist = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankArtist() {
	theArtist = " ";
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid artist", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except artist = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyArtist() {
	theArtist = " ";
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid artist", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except time = 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTime() {
	theTime = 0;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid playing time", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void negativeTime() {
	theTime = -1;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid playing time", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test

    public void negativeTracks() {
	theTracks = -1;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid number of tracks", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except tracks = 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTracks() {
	theTracks = 0;
	try {
	    new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid number of tracks", e.getMessage());
	}
    }
}
