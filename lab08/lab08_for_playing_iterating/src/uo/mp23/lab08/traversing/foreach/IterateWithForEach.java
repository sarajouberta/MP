package uo.mp23.lab08.traversing.foreach;

import java.util.Collection;

import uo.mp23.lab08.traversing.hidden.Factory;

public class IterateWithForEach {

	public static void main(String[] args) {

		/*
		 * IGNORE WARNINGS
		 */
		display(Factory.getAnimals());
	}

	private static void display(Collection animals) {
		for (Object animal : animals) {
			System.out.println(animal);
		}
		
	}
	

}
