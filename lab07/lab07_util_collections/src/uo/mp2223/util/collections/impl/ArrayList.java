package uo.mp2223.util.collections.impl;

import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.util.collections.List;

public class ArrayList extends AbstractList {
	private final static int INITIAL_CAPACITY = 20;
	
	private Object[] elements;
	
	/**
	 * COnstructor por defecto
	 */
	public ArrayList() {
		super();
		elements = new Object[INITIAL_CAPACITY];
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
		boolean removed= false;
		if(numberOfElements > 0) {
			for (int i = 0; i < numberOfElements; i++) {
				if(elements[i].equals(o)) {
					for(int j = i; j < numberOfElements-1; j++) {
						elements[i] = elements[i+1]; //si se encuentra: todos los elementos 1 posición menos
					}
					numberOfElements--;
					removed = true;
				}
			}
		}
		return removed;
	}


	@Override
	public Object get(int index) {
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
	 * 
	 */
	@Override
	public Object set(int index, Object element) {
		ArgumentChecks.isTrue(element != null, "Invalid element");
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements, "Invalid index");
		Object aux = elements[index];
		elements[index] = element;
		return aux;
	}

	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrue(element != null, "Invalid element");
		ArgumentChecks.isTrue(index >= 0 && index <= numberOfElements, "Invalid index");
		if(index == elements.length) {
			moreMemory(size());
		}
		for (int i = size(); i > index; i--) {   
			elements[i] = elements[i-1];   /*se mueve 1 posición a la dcha cada elemento si se 
			                                 añade en posición intermedia*/
		}
		elements[index] = element;  //se añade el nuevo elemento en la posición deseada
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
		elements = newArray; //se sustitye el array original por el nuevo
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
	public Object remove(int index) {
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements, "Invalid index");
		Object removed = elements[index]; //se guarda el elemento a eliminar
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
	

	//lab session 07
		@Override
		public boolean equals(Object o) {
			if(o == null) return false;
			if(o == this) return true;
			if(!(o instanceof List)) return false;
			
			List that = (List) o;
			if(this.size() != that.size()) return false;
			
			for (int i = 0; i < size(); i++) {
				Object e1 = this.get(i);
				Object e2 = this.get(i);
				if(!(e1.equals(e2)))
					return false;
			}
			return true;
		}
		
		
		@Override
		public int hashCode() {
			int result = 1;
			for (int i = 0; i < size(); i++) {
				Object element = this.get(i);
				result = 31*result + (element.hashCode());
			}
			return result;
		}

		

}
