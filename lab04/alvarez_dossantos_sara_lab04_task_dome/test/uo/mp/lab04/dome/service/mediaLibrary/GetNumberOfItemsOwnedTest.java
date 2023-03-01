package uo.mp.lab04.dome.service.mediaLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.service.MediaLibrary;

public class GetNumberOfItemsOwnedTest {

    MediaLibrary ml;

    /**
     * Casos de uso:
     * 1- La colección de items está vacía --> devuelve 0
     * 2- La colección tiene items --> devuelve el número de items
     * 
     */

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * GIVEN Arraylist<Item> vacía
     * WHEN getNumberOfItemsOwned()
     * THEN devuelve 0
     */
    @Test
    public void GetNumberOfItemsOwnedEmptyArrayList() {
	assertEquals(0, ml.getNumberOfItemsOwned());
    }

    /**
     * GIVEN Arraylist<Item> con elementos
     * WHEN getNumberOfItemsOwned()
     * THEN devuelve el número de elementos
     */
    @Test
    public void GetNumberOfItemsOwnedSArrayListWithItems() {
	for (int i = 0; i < 4; i++) {
	    ml.add(new Cd("Younger now", "Miley Cyrus", 11, 50, 10.9));
	}
	assertEquals(4, ml.getNumberOfItemsOwned());
    }

}
