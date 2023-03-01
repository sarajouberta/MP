package uo.mp.lab04.dome.model.cd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;

/**
 * Cd::setOwn(boolean)
 * 
 * - when isOwned to owned
 * - when isNotOwned to owned
 * - when is not owned to owned
 * - when is not owned to not owned
 */

public class SetOwnTest {
    private Cd aCD;
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
	theBasePrice = 10.9;
	aCD = new Cd(theTitle, theArtist, theTracks, theTime, theBasePrice);
    }

    /**
     * GIVEN cd is owned
     * WHEN call setOwn with true
     * THEN unchanged
     * 
     */
    @Test
    public void trueToTrue() {
	aCD.setOwn(true);
	aCD.setOwn(true);
	assertEquals(true, aCD.getOwn());
    }

    /**
     * GIVEN cd owned
     * WHEN call setOwn ( false )
     * THEN cd not owned
     * 
     */
    @Test
    public void trueToFalse() {
	aCD.setOwn(true);
	aCD.setOwn(false);
	assertEquals(false, aCD.getOwn());
    }

    /**
     * GIVEN cd not owned
     * WHEN call setOwn ( false )
     * THEN cd not owned
     * 
     */
    @Test
    public void falseToFalse() {
	aCD.setOwn(false);
	aCD.setOwn(false);
	assertEquals(false, aCD.getOwn());
    }

    /**
     * GIVEN cd not owned
     * WHEN call setOwn ( true )
     * THEN cd owned
     * 
     */
    @Test
    public void falseToTrue() {
	aCD.setOwn(false);
	aCD.setOwn(true);
	assertEquals(true, aCD.getOwn());
    }
}
