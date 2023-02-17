package uo.mp.lab03.mediaLibray;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Item;
import uo.mp.lab03.dome.service.MediaLibrary;

public class AddTest {
    private Cd cd1, cd2;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();
	// etc
    }

    /**
     * GIVEN a mediaLibrary
     * WHEN a dvd is added
     * THEN the dvd is saved in the list
     */
    public void addCd() {
	ml.add(cd1);
	List<Item> items = ml.getItemsForTesting();
	// assertTrue(items.contains());
    }

}
