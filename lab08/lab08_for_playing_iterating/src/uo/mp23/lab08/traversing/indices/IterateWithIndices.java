package uo.mp23.lab08.traversing.indices;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


import uo.mp23.lab08.traversing.hidden.Factory;

public class IterateWithIndices {

	public static void main(String[] args) {

		display(Factory.getAnimals());
	}

	private static void display(Collection arg) {
		ArrayList animals = (ArrayList)arg;
		for (int index = 0; index < animals.size(); index++ ) {
			System.out.println(( animals).get(index));
		}
	}
	

}
