package uo.mp2223.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.check.ArgumentChecks;

public class ArrayList<T> extends AbstractList<T> {
	private final static int INITIAL_CAPACITY = 20;
	
	private T[] elements;
	
	/**
	 * Constructor por defecto
	 */
	public ArrayList() {
		super();
		elements = (T[]) new Object[INITIAL_CAPACITY];   //no se puede crear aray genérico
	}

	
	/**
	 * Clase interna para crear iterador para ArrayList
	 * @author user
	 *
	 */
	class ArrayListIterator implements Iterator<T>{
		
		private int nextIndex;
		private T lastReturned;
		
		/** 
		 * @return el siguiente objeto de la lista
		 * @throws NoSuchElementException 
		 */
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No quedan más elementos");
			}else {
				lastReturned = get(nextIndex);
				nextIndex++;
				return lastReturned;
			}
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		//¿Remove?
		
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	

	@Override
	public T get(int index) {
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements, "Invalid index");
		return elements[index];
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index
	 *            index of the element to replace
	 * @param element
	 *            element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 */
	
	//¿añadir al final? se supone que es set, pero ¿index >= size()?
	@Override
	public T set(int index, Object element) {
		ArgumentChecks.isTrue(element != null, "Invalid element");
		ArgumentChecks.isTrue(index >= 0 && index <= numberOfElements, "Invalid index");
		if(index == size()) {
			add(size(), element);
			return null;
		}else {
			Object aux = elements[index];
			elements[index] = (T) element;
			return (T) aux;
		}
		
	}

	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrue(element != null, "Invalid element");
		ArgumentChecks.isTrue(index >= 0 && index <= numberOfElements, "Invalid index");
		if(size() == elements.length) {
			moreMemory(size());
		}
		
		if(index < size()) {
			for (int i = size(); i >= index; i--) {   
				elements[i] = elements[i-1];   /*se mueve 1 posición a la dcha cada elemento si se 
				                                 añade en posición intermedia*/
			}
		}
		
		elements[index] = (T) element;  //se añade el nuevo elemento en la posición deseada
		numberOfElements++;
	}
	
	/**
	 * Método privado para ampliar tamaño del vector interno
	 * @param size tamaño del anterior vector
	 * @param index índice desde el que se desplazan los elementos (en caso de no añadirse al final)
	 */
	private void moreMemory(int size) {
		Object[] newArray = new Object[size*2];
		for (int i = 0; i < numberOfElements; i++) {
			newArray[i] = elements[i];  //se copian los elementos del array original
		}
		elements = (T[]) newArray; //se sustitye el array original por el nuevo
	}
	
	/**
	 * Removes first appearance of the instance of the specified element from this collection,
	 * if it is present. 
	 * More formally, removes an element 
	 * {@code e} such that {@code o == null ? o == null : o.equals(e))}, 
	 * if this collection contains one or more such elements. 
	 * 
	 * @param o, the element to be removed from this collection, if present
	 * 
	 * @return {@code true} if an element was removed as a result of this call
	 */
	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isTrue(o != null, "Invalid object");
		int index = indexOf(o);
		if(index == -1) {
			return false;
		}else {
			remove(index);
			return true;
		}
		
//		boolean removed= false;
//		int i = 0;
//		while(i< numberOfElements && !removed) {
//			if(elements[i].equals(o)) {
//				for(int j = i; j < numberOfElements-1; j++) {
//					elements[i] = elements[i+1]; //si se encuentra: todos los elementos 1 posición menos
//				}
//				numberOfElements--;
//				removed = true;
//			}
//			i++;
//		}
//		return removed;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 *
	 * @param index, the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index >= size()})
	 */
	@Override
	public T remove(int index) {
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements, "Invalid index");
		T removed = elements[index]; //se guarda el elemento a eliminar
		for (int i = index; i < size()-1; i++) {
			elements[i] = elements[i+1];
		}
		numberOfElements--;
		return removed;
	}

	@Override
	public int indexOf(Object o) {
		ArgumentChecks.isTrue(o != null, "Invalid object");
		for (int i = 0; i < numberOfElements; i++) {
			if(elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Sobreescribe el método toString() de Object
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < size(); i++) {
			result.append(elements[i]);
			if(i > size() -1) { //si no es la última posición
				result.append(", ");
			}
		}
		result.append("]");
		return result.toString();
	}

	
		

}
