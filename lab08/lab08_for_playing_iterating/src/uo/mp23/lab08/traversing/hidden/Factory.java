package uo.mp23.lab08.traversing.hidden;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Factory {

	public static Collection getAnimals() {
		Collection animals =  new ArrayList();
		animals.add("Horse");
		animals.add("Lion");
		animals.add("Tiger");
		return animals;

	}
}
