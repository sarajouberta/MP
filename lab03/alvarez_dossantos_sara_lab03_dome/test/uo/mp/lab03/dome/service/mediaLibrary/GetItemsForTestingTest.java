package uo.mp.lab03.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.service.MediaLibrary;

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
	ml.add(new Dvd("Mark Steven Johnson", "Ghost Rider", 110));
	ml.add(new Cd("Nonante-cinq", "Angèle", 18, 62));
	assertEquals(2, ml.getItemsForTesting()
	    .size()); // se comprueba que la lista copia contiene dos elementos
    }
    // preguntar ADRI

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
