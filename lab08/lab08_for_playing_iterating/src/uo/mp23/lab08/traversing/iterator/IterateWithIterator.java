package uo.mp23.lab08.traversing.iterator;


import java.util.Collection;
import java.util.Iterator;

import uo.mp23.lab08.traversing.hidden.Factory;

public class IterateWithIterator {

	/*
	 * IGNORE WARNINGS
	 */
	
	public static void main(String[] args) {
		display(Factory.getAnimals());

	}

	private static void display(Collection animals) {
		Iterator itr = animals.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	

}
