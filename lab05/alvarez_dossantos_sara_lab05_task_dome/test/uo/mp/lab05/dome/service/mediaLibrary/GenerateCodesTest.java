package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.VideogamePlatform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GenerateCodesTest {

    MediaLibrary ml;

    /**
     * Casos de uso:
     * 1- La colección tiene elementos: se devuelve correctamente la cadena con el código de cada item
     * 2- La colección no tiene elementos: devuelve una cadena vacía
     * 3- La colección tiene un item con título largo, otro con título corto: devuelve la cadena correctamente
     * en ambos casos
     */

    /**
     * Se instancia la clase MediaLibrary antes de realizar los tests
     */
    @Before
    public void setUp() {
	ml = new MediaLibrary();

    }

    /**
     * 1.
     * GIVEN arrayList en MediaLibrary con items
     * WHEN generateCodes()
     * THEN String con los códigos de los items concatenados
     */
    @Test
    public void generateCodesWithItems() {
	ml.add(new Cd("Happier than ever", "Billie Eiish", 18, 56, 20));
	ml.add(new Dvd("2 fast 2 furious", "John Singleton", 107, 15));
	ml.add(new Videogame("Hogwarts Legacy", "Avalanch software", "Adri", 2, VideogamePlatform.PLAYSTATION, 49));
	assertEquals("----------Código generado por los items:\nHap0-2 f1-Hog2", ml.generateCodes());
    }

    /**
     * 2.
     * GIVEN arrayList en MediaLibrary sin items
     * WHEN generateCodes()
     * THEN String vacía
     */
    @Test
    public void generateCodesWithoutItems() {
	assertEquals("----------Código generado por los items:\n", ml.generateCodes());
    }

    /**
     * 
     * 3.
     * GIVEN arrayList en MediaLibrary con títulos de diferentes longitudes
     * WHEN generateCodes()
     * THEN String con los códigos de los items concatenados correctamente
     */
    @Test
    public void generateCodesWithItemsDifferentNameLength() {
	ml.add(new Cd("Happier than ever", "Billie Eiish", 18, 56, 20));
	ml.add(new Dvd("La chica que soñaba con una cerilla y un bidón de gasolina", "Jonas Frykberg", 129, 10));
	assertEquals("----------Código generado por los items:\nHap0-La 1", ml.generateCodes());
    }
}
