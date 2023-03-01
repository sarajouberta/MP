package uo.mp.lab04.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Videogame;
import uo.mp.lab04.dome.model.VideogamePlatform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class GetTotalPriceTest {

    MediaLibrary ml;

    /**
     * Casos de uso:
     * 1- La colección tiene elementos: se suman correctamente
     * 2- La colección no tiene elementos: devuelve 0
     * 3- La colección tiene 1 elemento: se devuelve su precio total
     */

    /**
     * Se instancia la clase MediaLibrary antes de realizar test
     */
    @Before
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * 1.
     * GIVEN colección en MediaLibrary con elementos
     * WHEN getTotalPrice()
     * THEN devuelve la suma de los precios de cada item
     */
    @Test
    public void getTotalPriceWithItems() {
	ml.add(new Cd("whatever", "forever", 12, 35, 10.90)); // se le sumarán 2euros
	ml.add(new Dvd("Wherever", "Sara Dos", 80, 19.0)); // su precio base es el final
	ml.add(new Videogame("The sims", "Ubisoft", "Sara y Borja", 50, VideogamePlatform.PLAYSTATION, 15.0)); // se le
													       // sumará
													       // 10%
	assertEquals(48.4, ml.getTotalPrice(), 0.1);
    }

    /**
     * 2.
     * GIVEN colección en MediaLibrary sin elementos
     * WHEN getTotalPrice()
     * THEN devuelve 0
     */
    @Test
    public void getTotalPriceWithoutItems() {
	assertEquals(0.0, ml.getTotalPrice(), 0.1);
    }

    /**
     * 3.
     * GIVEN colección en MediaLibrary con 1 elemento
     * WHEN getTotalPrice()
     * THEN devuelve el precio total del item
     */
    @Test
    public void getTotalPriceWithOneItem() {
	ml.add(new Cd("whatever", "forever", 12, 35, 10.90)); // se le sumarán 2euros // 10%
	assertEquals(12.90, ml.getTotalPrice(), 0.1);
    }

}
