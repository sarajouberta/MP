package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.VideogamePlatform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class AddTest {

    MediaLibrary ml;

    /**
     * Casos de uso:
     * 1- Se intenta añadir un elemento null --> salta una excepción
     * 2- Se añade un elemento válido (Cd) --> se añade correctamente
     * 3- Se añade un elemento válido (Dvd) --> se añade correctamente
     * 4- Se añde un elemento válido (Videogame) --> se añade correctamente
     */

    /**
     * Se instancia la clase MediaLibrary antes de cada test
     */
    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * 1.
     * GIVEN parámetro null
     * WHEN add()
     * THEN IllegalArgumentException
     */
    @Test
    public void addTestItemNull() {
	try {
	    ml.add(null);
	    fail("Debería saltar una excepción");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid item", e.getMessage());
	}
    }

    /**
     * 2.
     * GIVEN item (Cd)
     * WHEN add()
     * THEN se añade correctamente
     */
    @Test
    public void addTestItemCd() {
	ml.add(new Cd("The hardest part", "Noah Cyrus", 10, 34, 10.9)); // se añade un elemento a la colección vacía
	assertEquals(1, ml.getNumberOfItemsOwned()); // se comprueba que se añadió el elemento Dvd a la colección
    }

    /**
     * 3.
     * GIVEN item (Dvd)
     * WHEN add()
     * THEN se añade correctamente
     */
    @Test
    public void addTestItemDvd() {
	ml.add(new Dvd("Breakfast at Tiffany's", "Blake Edwards", 114, 10.9)); // se añade un elemento a la colección
									       // vacía
	assertEquals(1, ml.getNumberOfItemsOwned()); // se comprueba que se añadió el elemento Dvd a la colección

    }

    /**
     * 4.
     * GIVEN item (Videogame)
     * WHEN add()
     * THEN se añade correctamente
     */
    @Test
    public void addTestItemVideogame() {
	ml.add(new Videogame("Call of duty: black ops", "Activision", "Sara Alvarez", 3, VideogamePlatform.PLAYSTATION,
		10.9)); // se añade un elemento a la colección vacía
	assertEquals(1, ml.getNumberOfItemsOwned()); // se comprueba que se añadió el elemento Dvd a la colección

    }

}
