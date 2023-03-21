package uo.mp2223.util.collections.impl;

import uo.mp.util.check.ArgumentChecks;

public class LinkedList extends AbstractList {

	Node head;
	
	//private¿?
	private class Node{
		Object element;
		Node next;
		
		public Node(Object element, Node next) {
			this.element = element;
			this.next = next;
		}
	}
	
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
	public Object get(int index) {
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
	public Object set(int index, Object element) {
		ArgumentChecks.isTrue(index >= 0 && index < size(), "Invalid index");
		ArgumentChecks.isTrue(element != null, "Invalid element");
		Object replaced;
		if(index == 0) {
			replaced = head.element;
			head.element = element;  //se reemplaza el elemento de la posición 
			return replaced;
		}else {
			Node aux = head;
			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}
			replaced = aux.element;
			aux.element = element;
		}
		return replaced;
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
	@Override
	public void add(int index, Object element) {
		ArgumentChecks.isTrue(index >= 0 && index < size(), "Invalid index");
		ArgumentChecks.isTrue(element != null, "Invalid element");
		Node newNode = new Node(element, null);
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
	public Object remove(int index) {
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
	

}
