package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GetAvailablesTests {

    MediaLibrary ml;

    /**
     * Se instancia la clase MediaLibrary antes de pasar los tests
     */
    @Before
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * Casos de uso:
     * 1- No hay elementos disponibles: cadena vacía
     * 2- Hay un elemento disponible: se devuelve cadena con el elemento disponible
     * 3- Hay elementos disponibles: se devuelve cadena con los elementos disponibles
     */

    /**
     * 1.
     * GIVEN colección si elementos disponibles
     * WHEN getAvailables()
     * THEN String vacía
     */
    @Test
    public void getAvailablesWithoutAvailableItems() {
	assertEquals("Items disponibles: \n", ml.getAvailables());
    }

    /**
     * 2.
     * GIVEN colección con 1 elemento prestable (cd)
     * WHEN getBorrowables()
     * THEN String con el elemento prestable
     */
    @Test
    public void getAvailablesWithOneCd() {
	Cd cd = new Cd("Wonder", "Shawn Mendes", 14, 40, 10.9);
	cd.setOwn(true);
	cd.setAvailable(true);
	ml.add(cd);
	assertEquals("Items disponibles: \nCD: Wonder Artist: Shawn Mendes Number of tracks: 14\n", ml.getAvailables());
    }

    /**
     * 3.
     * GIVEN colección con elementos prestable (cd y book)
     * WHEN getBorrowables()
     * THEN String con los elementos prestables
     */
    @Test
    public void getAvailablesWithCdAndBook() {
	Cd cd = new Cd("Wonder", "Shawn Mendes", 14, 40, 10.9);
	cd.setOwn(true);
	cd.setAvailable(true);
	Book book = new Book("Normal people", "Sally Rooney", "Random House", "98139-1", 13);
	book.setOwn(true);
	book.setAvailable(true);
	ml.add(cd);
	ml.add(book);
	assertEquals(
		"Items disponibles: \nCD: Wonder Artist: Shawn Mendes Number of tracks: 14\nBook: Normal people Author: Sally Rooney ISBN: 98139-1 Publisher: Random House\n",
		ml.getAvailables());
    }

}
