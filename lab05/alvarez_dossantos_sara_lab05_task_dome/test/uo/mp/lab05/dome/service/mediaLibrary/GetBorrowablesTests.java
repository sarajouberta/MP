package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GetBorrowablesTests {

    MediaLibrary ml;

    /**
     * Se instancia la clase MediaLibrary antes de cada test
     */
    @Before
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * Casos de uso:
     * 1- La colección no tiene elementos prestables --> devuelve String vacía
     * 2- La colección tiene un elemento prestable (Cd) --> devuelve una String con el elemento prestable
     * 3- La colección tiene un elemento prestable (Book) --> devuelve una String con el elemento prestable
     * 4- La colección tiene varios elementos prestables --> devuelve una String con los elementos prestables
     * 
     */

    /**
     * 1.
     * GIVEN colección si elementos prestables (cd o book)
     * WHEN getBorrowables()
     * THEN String vacía
     */
    @Test
    public void getBorrowablesWithoutBorrowableItems() {
	assertEquals("Items prestables: \n", ml.getBorrowables());
    }

    /**
     * 2.
     * GIVEN colección con 1 elemento prestable (cd)
     * WHEN getBorrowables()
     * THEN String con el elemento prestable
     */
    @Test
    public void getBorrowablesWithOneCd() {
	ml.add(new Cd("Wonder", "Shawn Mendes", 14, 40, 10.9));
	assertEquals("Items prestables: \nCD: Wonder Artist: Shawn Mendes Number of tracks: 14\n", ml.getBorrowables());
    }

    /**
     * 3.
     * GIVEN colección con 1 elemento prestable (book)
     * WHEN getBorrowables()
     * THEN String con el elemento prestable
     */
    @Test
    public void getBorrowablesWithOneBook() {
	ml.add(new Book("Lonely castle in the mirror", "Mizuki Tsujimura", "Random House", "97811-2022", 13.20));
	assertEquals(
		"Items prestables: \nBook: Lonely castle in the mirror Author: Mizuki Tsujimura ISBN: 97811-2022 Publisher: Random House\n",
		ml.getBorrowables());
    }

    /**
     * 4.
     * GIVEN colección con elementos prestables (cd y book)
     * WHEN getBorrowables()
     * THEN String con los elementos prestables
     */
    @Test
    public void getBorrowablesWithBorrowableItems() {
	ml.add(new Cd("Wonder", "Shawn Mendes", 14, 40, 10.9));
	ml.add(new Book("Lonely castle in the mirror", "Mizuki Tsujimura", "Random House", "97811-2022", 13.20));
	assertEquals(
		"Items prestables: \nCD: Wonder Artist: Shawn Mendes Number of tracks: 14\nBook: Lonely castle in the mirror Author: Mizuki Tsujimura ISBN: 97811-2022 Publisher: Random House\n",
		ml.getBorrowables());
    }
}
