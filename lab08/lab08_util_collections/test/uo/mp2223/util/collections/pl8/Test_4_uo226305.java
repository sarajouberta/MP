package uo.mp2223.util.collections.pl8;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_4_uo226305 {
	//4 Add en la última posición de una lista con elementos añade el elemento y el último pasa a la derecha
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	/** 
	 * GIVEN: non-empty list
	 * WHEN: add() to last position
	 * THEN: adds element to the last position and moves one position the former last element
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addLast(List list) {
		list.add("testing");
		list.add("with");
		list.add("framework");
		list.add(list.size()-1, "JUnit");
		String s = "testingwihJUnitframework";
		assertEquals(list.toString(), s);
	}
}
