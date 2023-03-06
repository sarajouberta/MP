package uo.mp.lab05.dome.service.mediaLibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.VideogamePlatform;
import uo.mp.lab05.dome.service.MediaLibrary;

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
     * 4- Hay responsables (hay items Videogame en la lista)--> se devuelve una cadena con los nombres de los
     * responsables de
     * mediaLibrary
     */

    /**
     * 1.
     * GIVEN la lista de items tiene elementos
     * WHEN getResponsibles()
     * THEN se devuelve cadena con los nombres de los responsables de los elementos
     */
    @Test
    public void getResponsablesWithItemsCd() {
	ml.add(new Cd("Wonder", "Shawn Mendes", 14, 40, 10.9));
	ml.add(new Cd("Mercury I", "Imagine Dragons", 18, 57, 10.9));
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
	ml.add(new Dvd("Los aristogatos", "Wolfang Reitherman", 78, 10.9));
	ml.add(new Dvd("Cenicienta", "Clyde Geronimi, Wilfred Jackson", 74, 10.9));
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

    /**
     * 4.
     * GIVEN la lista de items tiene elementos Videogame
     * WHEN getResponsibles()
     * THEN se devuelve cadena con los nombres de los responsables de los elementos
     */
    @Test
    public void getResponsablesWithItemsVideogame() {
	ml.add(new Videogame("Dark Souls", "Bandai-Namco Entertainment", "Lucía Pola", 10,
		VideogamePlatform.PLAYSTATION, 10.9));
	ml.add(new Videogame("Hamtaro: rainbow rescue", "AlphaDream", "Borja Vázquez", 4, VideogamePlatform.NINTENDO,
		10.9));
	String str = ml.getResponsables();
	assertEquals("Bandai-Namco Entertainment, AlphaDream", str);
    }

}
