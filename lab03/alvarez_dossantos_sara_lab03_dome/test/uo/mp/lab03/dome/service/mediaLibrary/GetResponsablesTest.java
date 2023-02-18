package uo.mp.lab03.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.service.MediaLibrary;

public class GetResponsablesTest {

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
     * 1- Hay responsables (hay items Cd en la lista)--> se devuelve una cadena con los nombres de los responsables de
     * mediaLibrary
     * 2- Hay responsables (hay items Dvd en la lista)--> se devuelve una cadena con los nombres de los responsables de
     * mediaLibrary
     * 3- No hay responsables (lista de items vacía)--> se devuelve una cadena vacía
     */

    /**
     * 1.
     * GIVEN la lista de items tiene elementos
     * WHEN getResponsibles()
     * THEN se devuelve cadena con los nombres de los responsables de los elementos
     */
    @Test
    public void getResponsablesWithItemsCd() {
	ml.add(new Cd("Wonder", "Shawn Mendes", 14, 40));
	ml.add(new Cd("Mercury I", "Imagine Dragons", 18, 57));
	String str = ml.getResponsables();
	assertEquals("Shawn Mendes, Imagine Dragons", str);
    }

    /**
     * 2.
     * GIVEN la lista de items tiene elementos Cd
     * WHEN getResponsibles()
     * THEN se devuelve cadena con los nombres de los responsables de los elementos
     */
    @Test
    public void getResponsablesWithItemsDvd() {
	ml.add(new Dvd("Los aristogatos", "Wolfang Reitherman", 78));
	ml.add(new Dvd("Cenicienta", "Clyde Geronimi, Wilfred Jackson", 74));
	String str = ml.getResponsables();
	assertEquals("Wolfang Reitherman, Clyde Geronimi, Wilfred Jackson", str);
    }

    /**
     * 3.
     * GIVEN GIVEN la lista de items no tiene elementos
     * WHEN getResponsibles()
     * THEN se devuelve cadena vacía
     */
    @Test
    public void getResponsiblesWithoutItems() {
	String str = ml.getResponsables();
	assertEquals("", str);
    }

}
