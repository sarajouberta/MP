package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Borrowable;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GiveBackTests {

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
     * 1- El item no estaba en posesión: no se puede devolver, devuelve null
     * 2- El item está en posesión, pero está disponible (no estaba prestado): no se puede devolver, devuelve null
     * 3- El item está en posesión y estaba prestado: se puede devolver
     * 
     */

    /**
     * 1.
     * GIVEN colección de objetos Borrowable vacía
     * WHEN giveBack()
     * THEN devuelve null
     */
    @Test
    public void giveBackWithoutBorrowableItems() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18);
	assertEquals(null, ml.giveBack(cd));
    }

    /**
     * 2.
     * GIVEN colección de objetos Borrowable vacía
     * WHEN giveBack()
     * THEN devuelve null
     */
    @Test
    public void giveBackWithBorrowableItemNotBorrowed() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18); // por defecto no disponible
	cd.setAvailable(true); // se puede prestar (está disponible)
	cd.setOwn(true);
	ml.add(cd); // se añade en colección de items y colección de prestables
	assertEquals(null, ml.giveBack(cd));
    }

    /**
     * 3.
     * GIVEN colección de objetos Borrowable con elemento prestado
     * WHEN giveBack()
     * THEN devuelve null
     */
    @Test
    public void borrowWithBorrowableItemBorrowed() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18); // por defecto no disponible
	cd.setAvailable(false);
	cd.setOwn(true);
	Book book = new Book("Normal people", "Sally Rooney", "Random House", "98139-1", 13);
	book.setAvailable(false);
	book.setOwn(true);
	ml.add(cd); // se añade en colección de items y colección de prestables
	ml.add(book); // se añade en colección de items y colección de prestables
	Borrowable givenBack = ml.giveBack(book);
	assertEquals(book, givenBack); // se comprueba que se devuelve el item esperado
	assertEquals(true, givenBack.isAvailable()); // se comprueba que el item devuelto pasa a estar disponible
    }

    /**
     * 3.
     * GIVEN se llama al método con parámetro null
     * WHEN borrow()
     * THEN salta una excepción
     */
    @Test
    public void borrowWithWrongParameter() {
	try {
	    ml.giveBack(null);
	    fail("Debería saltar una excepción");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid item", e.getMessage());
	}
    }
}
