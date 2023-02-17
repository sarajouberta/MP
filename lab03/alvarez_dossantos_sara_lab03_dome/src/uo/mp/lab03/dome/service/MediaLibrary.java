package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.dome.model.Item;

public class MediaLibrary {
    ArrayList<Item> items = new ArrayList<Item>(); // inicializamos la colección en lugar de tener un constructor

    /**
     * Añade objetos de tipo Item a la colección
     * 
     * @param item eleemnto a coleccionar
     */
    public void add(Item item) {
	ArgumentChecks.isTrue(item != null, "Invalid item"); // validar parámetro
	items.add(item);
    }

    /**
     * Devuelve el número de elementos de la colección de items
     * 
     * @param item
     * @return el numero de items de la coleccion
     */
    public int getNumberOfItemsOwned() {
	return items.size(); // devuelve el tamaño de la colección
    }

    /**
     * Imprime cada elemento de la coleccion (items)
     * 
     * @param out
     */
    public void list(PrintStream out) {
	ArgumentChecks.isTrue(out != null);
	out.println("List of Items in the library:");
	for (Item item : items) {
	    item.print();
	}

    }

    /**
     * Copia el contenido del arrayList atributo en nuevo arrayList para devolverlo
     * 
     * @return lista copia del atributo arrayList
     */
    public List<Item> getItemsForTesting() {
	return new ArrayList<Item>(items);

    }

}
