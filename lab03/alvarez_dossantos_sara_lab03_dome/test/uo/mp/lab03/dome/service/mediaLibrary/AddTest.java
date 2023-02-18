package uo.mp.lab03.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.service.MediaLibrary;

public class AddTest {

    MediaLibrary ml;

    /**
     * Casos de uso:
     * 1- Se intenta añadir un elemento null --> salta una excepción
     * 2- Se añade un elemento válido (cd) --> se añade correctamente
     * 3- Se añade un elemento válido (dvd) --> se añade correctamente
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
	ml.add(new Cd("The hardest part", "Noah Cyrus", 10, 34)); // se añade un elemento a la colección vacía
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
	ml.add(new Dvd("Breakfast at Tiffany's", "Blake Edwards", 114)); // se añade un elemento a la colección vacía
	assertEquals(1, ml.getNumberOfItemsOwned()); // se comprueba que se añadió el elemento Dvd a la colección

    }

}
