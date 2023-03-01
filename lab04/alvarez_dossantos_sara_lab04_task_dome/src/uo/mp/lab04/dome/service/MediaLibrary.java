package uo.mp.lab04.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab04.dome.model.Item;

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
	    out.println(item.toString()); // o solo item (tb con método privado item.print3)
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
	    if (it.equals(theItem)) { // mismo contenido --> equals
		return it; // devuelve el elemento buscado de la lista
	    }
	}
	return null;
    }

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

    /**
     * Método que suma los precios de todos los items de la colección
     * 
     * @return totalPrice precio de todos los items de la colección
     */
    public double getTotalPrice() {
	double totalPrice = 0.0;
	if (items.size() > 0) {
	    for (Item item : items) {
		totalPrice = totalPrice + item.getFinalPrice();
	    }
	}
	return totalPrice;
    }

    /**
     * Devuelve una cadena
     * con el código de todos los ítems de la mediateca, separados por un guion. El código será una
     * cadena formada por las tres primeras letras del título y un número secuencial, comenzando en 0.
     * 
     * @return cadena generada de códigos
     */
    public String generateCodes() {
	StringBuilder str = new StringBuilder();
	str.append("----------Código generado por los items:" + "\n");
	for (int i = 0; i < items.size(); i++) { // se recorre la colección de items
	    if (i == items.size() - 1) {
		str.append(items.get(i)
		    .getTitle()
		    .substring(0, 3) + i); // si es el último elemento no añade guion
	    } else {
		str.append(items.get(i)
		    .getTitle()
		    .substring(0, 3) + i + "-"); // añade guion siempre que no sea 1
	    }
	}
	return str.toString();
    }

}
