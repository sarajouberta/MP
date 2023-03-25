package uo.mp2223.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.check.ArgumentChecks;

public class LinkedList<T> extends AbstractList<T> {

	Node head;
	
	private class Node{
		T element;
		Node next;
		
		public Node(T element, Node next) {
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append(element +  " >= ");
			if(next == null) {
				result.append("null");
			}else{
				result.append(next.element);
				if(next.next != null) {
					result.append(" ...");
				}
			}
			return result.toString();
		}
	}
	
	/**
	 * CLase interna para crear un iterador propio de LinkedList
	 * @author user
	 *
	 */
	class LinkedListIterator implements Iterator<T>{
		Node next;
		int nextIndex;
		Node lastReturned;
		
		public LinkedListIterator() {
			next = head;
			nextIndex = 0;
			lastReturned = null;
		}
		
		/**
		 * 
		 * @return el siguiente objeto de la lista
		 * @throws NoSuchElementException 
		 */
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No quedan más elementos");
			}else {
				lastReturned = next;
				next = next.next;
				nextIndex++;
				return lastReturned.element;
			}
		}
		
		public boolean hasNext() {
			return next != null; 
		}
		
		//FALTA REMOVE : ELIMINA EL ÚLTIMO ELEMENTO RETORNADO POR EL OPERADOR
		//NO ENTIENDO QUË ES ESTO

		@Override
		public void remove() {
			Iterator.super.remove();
		}
	}
	
	/**
	 * Devuelve un iterador de tipo LinkedListIterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	/**
	 * Constructor de la clase LinkedList
	 */
	public LinkedList() {
		super();
		head = new Node(null, null);
	}
	
	
	@Override
	public void clear() {
		super.clear();
		head = new Node(null, null);
	}

	@Override
	public T get(int index) {
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements, "Invalid index");
		if(index == 0) {
			return head.element;
		}else {
			return getNode(index).element;
		}
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
	public T set(int index, Object element) {
		ArgumentChecks.isTrue(index >= 0 && index < size(), "Invalid index");
		ArgumentChecks.isTrue(element != null, "Invalid element");
		Object replaced;
		if(index == 0) {
			replaced = head.element;
			head.element = (T) element;  //se reemplaza el elemento de la posición 
			return (T) replaced;
		}else {
			Node aux = head;
			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}
			replaced = aux.element;
			aux.element = (T) element;
		}
		return (T) replaced;
	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 *
	 * @param index, index at which the specified element is to be inserted
	 * @param element, the element to be inserted
	 * @throws IllegalArgumentException
	 *             if the specified element is null
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (
	 *             {@code index < 0 || index > size()})
	 */
	//REVISAR
	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrue(index >= 0 && index < size(), "Invalid index");
		ArgumentChecks.isTrue(element != null, "Invalid element");
		Node newNode = new Node((T)element, null);
		if(index == 0) {
			newNode.next = head;
			head = newNode;
		}else {
			Node aux = head;
			for (int i = 0; i < index-1; i++) {
				aux = aux.next;
				newNode.next = aux.next;
				aux.next = newNode;
			}
		}
	}

	@Override
	public T remove(int index) {
		ArgumentChecks.isTrue(index >= 0 && index < size(), "Invalid index");
		Node aux = head;
		Node removed;
		if(index == 0) {
			removed = head;
			head = head.next;
			
		}else {
			aux = head;
			for (int i = 0; i < index-1; i++) {
				aux = aux.next;
			}
			removed = aux.next;
			aux.next = aux.next.next;
		}
		return removed.element;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element. More
	 * formally, returns the lowest index {@code i} such that
	 * {@code (o == null ? get(i) == null : o.equals(get(i)))}, or -1 if there
	 * is no such index.
	 *
	 * @param o, the element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 */
	@Override
	public int indexOf(Object o) {
		ArgumentChecks.isTrue(o != null, "Invalid object");
		Node aux = head;
		for (int i = 0; i < size(); i++) {
			if(aux.element.equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	private Node getNode(int index) {
		int position = 0;
		Node node = head;
		while(position < index) {
			node = node.next;
			position++;
		}
		return node;
	}


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
	}

	/**
	 * Sobreescribe el método toString() de Object
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node each = head;
		for (int i = 0; i < size(); i++) {
			result.append(each.element);
			if(i > size() -1) { //si no es la última posición
				result.append(", ");
			}
			each = each.next;
		}
		result.append("]");
		return result.toString();
	}

	

}
