package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Borrowable;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.service.MediaLibrary;

public class BorrowTests {

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
     * 1- El item no está en posesión: no se puede prestar, devuelve null
     * 2- El item está en posesión, pero no está disponible: no se puede prestar, devuelve null
     * 3- El item está en posesión y está disponible: se puede prestar
     * 
     */

    /**
     * 1.
     * GIVEN colección de objetos Borrowable vacía
     * WHEN borrow()
     * THEN devuelve null
     */
    @Test
    public void borrowWithoutBorrowableItems() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18);
	assertEquals(null, ml.borrow(cd));
    }

    /**
     * 2.
     * GIVEN colección de objetos Borrowable vacía
     * WHEN borrow()
     * THEN devuelve null
     */
    @Test
    public void borrowWithBorrowableItemNotAvailable() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18); // por defecto no disponible
	ml.add(cd); // se añade en colección de items y colección de prestables
	assertEquals(null, ml.borrow(cd));
    }

    /**
     * 3.
     * GIVEN colección de objetos Borrowable con elementos
     * WHEN borrow()
     * THEN devuelve el item prestado
     */
    @Test
    public void borrowWithBorrowableItemAvailable() {
	Cd cd = new Cd("Death by rock and roll", "The Pretty Reckless", 12, 50, 18); // por defecto no disponible
	cd.setAvailable(true);
	cd.setOwn(true);
	Book book = new Book("Normal people", "Sally Rooney", "Random House", "98139-1", 13);
	book.setAvailable(true);
	book.setOwn(true);
	ml.add(cd); // se añade en colección de items y colección de prestables
	ml.add(book); // se añade en colección de items y colección de prestables
	Borrowable borrowedBook = ml.borrow(book);
	assertEquals(book, borrowedBook); // se comprueba que se devuelve el item esperado
	assertEquals(false, borrowedBook.isAvailable()); // se comprueba que el item devuelto pasa a estar prestado (no
							 // disponible)
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
	    ml.borrow(null);
	    fail("Debería saltar una excepción");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid item", e.getMessage());
	}
    }
}
