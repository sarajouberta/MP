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

public class SearchItemTest {

    MediaLibrary ml;

    /**
     * Se instancia la clase MediaLibrary antes de cada test
     */
    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * Casos de uso:
     * 1-Parámetro null --> salta una excepción
     * 2-El elemento (Cd) está en la lista --> devuelve el elemento encontrado en la lista
     * 3-El elemento (Dvd) está en la lista --> devuelve el elemento encontrado en la lista
     * 4-El elemento no está en la lista --> devuelve null
     * 5-El elemento (Dvd) está en la lista --> devuelve el elemento encontrado en la lista
     * 
     */

    /**
     * 1.
     * GIVEN parámetro null
     * WHEN searchItem()
     * THEN IllegalArgumentException
     */
    @Test
    public void searchItemNullParameter() {
	try {
	    ml.searchItem(null);
	    fail("Debería saltar una excepción");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid item", e.getMessage());
	}
    }

    /**
     * 2.
     * GIVEN el item (Cd) está en la colección
     * WHEN searchItem()
     * THEN
     */
    @Test
    public void searchItemCdFound() {
	Cd cd1 = new Cd("Nonante-cinq la suite", "Angèle", 18, 62, 10.9);
	ml.add(cd1);
	assertEquals(cd1, ml.searchItem(cd1)); // se comprueba que devuelve el cd de la lista
    }

    /**
     * 2.
     * GIVEN el item (Dvd) está en la colección
     * WHEN searchItem()
     * THEN devuelve el cd buscado de la lista
     */
    @Test
    public void searchItemDvdFound() {
	Dvd dvd1 = new Dvd("Titanic", "James Cameron", 195, 10.9);
	ml.add(dvd1);
	assertEquals(dvd1, ml.searchItem(dvd1));
    }

    /**
     * 4.
     * GIVEN el item no está en la lista
     * WHEN searchItem()
     * THEN devuelve null
     */
    @Test
    public void searchItemNotFound() {
	Dvd dvd1 = new Dvd("Titanic", "James Cameron", 195, 10.9);
	assertEquals(null, ml.searchItem(dvd1)); // se trata de buscar un elemento que no está en la lista
    }

    /**
     * 4.
     * GIVEN el item (Videogame) está en la colección
     * WHEN searchItem()
     * THEN devuelve el videojuego buscado de la lista
     */
    @Test
    public void searchItemVideogameFound() {
	Videogame videogame1 = new Videogame("Grand Theft Auto: San Andreas", "Rockstar", "Sara Álvarez", 32,
		VideogamePlatform.PLAYSTATION, 10.9);
	ml.add(videogame1);
	assertEquals(videogame1, ml.searchItem(videogame1));
    }

}
