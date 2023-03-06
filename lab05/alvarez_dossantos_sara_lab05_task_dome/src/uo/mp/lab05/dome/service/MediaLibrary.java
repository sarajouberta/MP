package uo.mp.lab05.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab05.dome.model.Borrowable;
import uo.mp.lab05.dome.model.Item;
import uo.mp.util.check.ArgumentChecks;

public class MediaLibrary {
    private ArrayList<Item> items = new ArrayList<Item>(); // inicializamos la colección en lugar de tener un
							   // constructor
    private ArrayList<Borrowable> borrowableItems = new ArrayList<Borrowable>();

    /**
     * Añade objetos de tipo Item a la colección
     * 
     * @param item elemento a coleccionar
     */
    public void add(Item item) {
	ArgumentChecks.isTrue(item != null, "Invalid item"); // validar parámetro
	items.add(item);
	if (item instanceof Borrowable) {
	    borrowableItems.add((Borrowable) item); // si el item es prestable, se añade a colección de prestables
	}
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

    /**
     * Retorna un String con los items prestables (todos los Books y Cds).
     * 
     * @return String con los elementos prestables/ vacía si no hay elementos prestables
     */
    public String getBorrowables() {
	StringBuilder str = new StringBuilder();
	str.append("Items prestables: \n");
	for (int i = 0; i < borrowableItems.size(); i++) {
	    str.append(borrowableItems.get(i)
		.toString() + "\n");
	}
	return str.toString();
    }

    /**
     * Método para MediaPlayer
     * 
     * @return items prestables y disponibles
     */
    public String getBorrowablesAvailables() {
	StringBuilder str = new StringBuilder();
	str.append("Items prestables: \n");
	for (int i = 0; i < borrowableItems.size(); i++) {
	    if (borrowableItems.get(i)
		.isAvailable() == true) {
		str.append(borrowableItems.get(i)
		    .toString() + "\n");
	    }

	}
	return str.toString();
    }

    /**
     * Retorna un String con los items disponibles, que ahora mismo se pueden prestar.
     * 
     * @return
     */
    public String getAvailables() {
	StringBuilder str = new StringBuilder();
	str.append("Items disponibles: \n");
	if (borrowableItems.size() > 0) {
	    for (int i = 0; i < borrowableItems.size(); i++) {
		if (borrowableItems.get(i)
		    .isAvailable()) {
		    str.append(borrowableItems.get(i)
			.toString() + "\n");
		}
	    }
	}
	return str.toString();
    }

    /**
     * 
     * Devuelve un ítem. Recibe un ítem igual a uno que exista (por tanto diferente de null),
     * lo deja disponible y devuelve el ítem devuelto si se ha podido devolver.
     * 
     * @param item a devolver
     * @return item devuelto (de la colección) /null si no está en la colección
     */
    public Borrowable giveBack(Item item) {
	ArgumentChecks.isTrue(item instanceof Borrowable && item != null, "Invalid item");
	for (int i = 0; i < borrowableItems.size(); i++) { // se recorre la coleccion
	    if (borrowableItems.get(i)
		.equals(item)) { // si el item está en la colección de prestables
		if (!borrowableItems.get(i)
		    .isAvailable()) { // si estaba prestado
		    borrowableItems.get(i)
			.giveBack(); // se marca como devuelvo
		    return borrowableItems.get(i); // se devuelve el que establa en la colección
		}

	    }
	}
	return null; // se devuelve null en caso de no estar en la colección

    }

    /**
     * Presta un ítem. Recibe un Item prestable como parámetro (diferente
     * de null), busca uno igual en la lista y devuelve este último ya prestado, o null
     * si no se ha podido prestar.
     * 
     * @param item
     */
    public Borrowable borrow(Borrowable item) {
	ArgumentChecks.isTrue(item instanceof Borrowable && item != null, "Invalid item");
	for (int i = 0; i < borrowableItems.size(); i++) { // se recorre la lista de items prestables
	    if (borrowableItems.get(i)
		.equals(item)) { // si el item está en la colección
		if (borrowableItems.get(i)
		    .isAvailable()) { // si está disponible
		    borrowableItems.get(i)
			.borrow(); // se marca como prestado
		    return borrowableItems.get(i); // se devuelve el que establa en la colección
		}
	    }
	}
	return null; // se devuelve null en caso de no poder ser prestado
    }

}
