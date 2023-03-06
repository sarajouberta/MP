package uo.mp.lab05.dome.ui;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.service.MediaLibrary;

public class MediaPlayer {

    /**
     * Se añaden 5 libros, dos de ellos en propiedad, 2 cds con propietario y 1 sin él. Se
     * presta un libro y un cd y se muestran todos los que se pueden prestar y todos los
     * que están disponibles para ser prestados.
     */
    public void run() {
	MediaLibrary ml = new MediaLibrary();
	Cd cd1 = new Cd("a", "pepito grillo", 10, 40, 10);
	cd1.setOwn(true);
	cd1.setAvailable(true);
	Cd cd2 = new Cd("b", "pepito grillo", 10, 40, 10);
	cd2.setOwn(true);
	cd2.setAvailable(true);
	Cd cdNotOwned = new Cd("c", "pepito grillo", 10, 40, 10);
	cdNotOwned.setAvailable(false);
	Book book1 = new Book("a", "pepito grillo escritor", "Akal", "666-6", 12);
	book1.setOwn(true);
	book1.setAvailable(true);
	Book book2 = new Book("b", "pepito grillo escritor", "Akal", "666-6", 12);
	Book book3NotOwned = new Book("c", "pepito grillo escritor", "Akal", "666-6", 12);
	Book book4NotOwned = new Book("d", "pepito grillo escritor", "Akal", "666-6", 12);
	Book book5NotOwned = new Book("e", "pepito grillo escritor", "Akal", "666-6", 12);

	ml.add(cd1);
	ml.add(cd2);
	ml.add(cdNotOwned);
	ml.add(book1);
	ml.add(book2);
	ml.add(book3NotOwned);
	ml.add(book4NotOwned);
	ml.add(book5NotOwned);

	ml.borrow(book1);
	ml.borrow(cd1);

	System.out.println(ml.getBorrowablesAvailables());
	System.out.println(ml.getAvailables());

    }

}
