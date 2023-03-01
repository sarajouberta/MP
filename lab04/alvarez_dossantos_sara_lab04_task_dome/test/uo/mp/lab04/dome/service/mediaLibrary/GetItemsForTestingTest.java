package uo.mp.lab04.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Videogame;
import uo.mp.lab04.dome.model.VideogamePlatform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class GetItemsForTestingTest {

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
     * 1-La lista tiene elementos --> devuelve una copia de la lista de elementos
     * 2-La lista no tiene elementos --> devuelve una copia de la lista vacía
     * 
     */

    /**
     * 1.
     * GIVEN arrayList<Item> con elementos
     * WHEN getItemsforTesting()
     * THEN devuelve una lista copia del arrayList<Item>
     */
    @Test
    public void getItemsForTestingSemifullArrayList() {
	ml.add(new Dvd("Mark Steven Johnson", "Ghost Rider", 110, 10.9));
	ml.add(new Cd("Nonante-cinq", "Angèle", 18, 62, 10.9));
	ml.add(new Videogame("Animal Crossing: new Horizons", "Nintendo", "María Suárez", 1, VideogamePlatform.NINTENDO,
		10.9));
	assertEquals(3, ml.getItemsForTesting()
	    .size()); // se comprueba que la lista copia contiene dos elementos
    }

    /**
     * 2.
     * GIVEN arrayList<Item> sin elementos
     * WHEN getItemsforTesting()
     * THEN devuelve una lista copia del arrayList<Item> vacía
     */
    @Test
    public void getItemsForTestingEmptyArrayList() {
	assertEquals(0, ml.getItemsForTesting()
	    .size()); // se comprueba que la lista copia tiene 0 elementos
    }

}
