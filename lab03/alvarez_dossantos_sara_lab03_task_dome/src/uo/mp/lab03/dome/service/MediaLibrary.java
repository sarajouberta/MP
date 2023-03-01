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

    /**
     * 
     * @param theItem el elemento que se quiere buscar
     * @return el elemento buscado, null si no o encuentra
     */
    public Item searchItem(Item theItem) {
	ArgumentChecks.isTrue(theItem != null, "Invalid item"); // se valida el parámetro
	for (int i = 0; i < items.size(); i++) {
	    Item it = items.get(i);
	    if (items.get(i) == theItem) {
		return it; // devuelve el elemento buscado de la lista
	    }
	}
	return null;
    }

    // revisar

    /**
     * 
     * @return cadena con los nombres de los responsables (vacía si no hay)
     */
    public String getResponsables() {
	StringBuilder stringBuilder = new StringBuilder();
	/*
	 * for (Item item : items) {
	 * stringBuilder.append(item.getResponsable() + ", "); //arreglar la ',' al final del último
	 */
	if (items.size() > 0) { // si hay elementos en la lista
	    for (int i = 0; i < items.size() - 1; i++) {
		stringBuilder.append(items.get(i)
		    .getResponsable() + ", ");
	    }
	    stringBuilder.append(items.get(items.size() - 1)
		.getResponsable());
	    return stringBuilder.toString();
	} else {
	    return stringBuilder.toString();
	}
    }

}
