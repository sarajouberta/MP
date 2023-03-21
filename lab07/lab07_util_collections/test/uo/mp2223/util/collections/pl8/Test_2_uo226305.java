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

public class Test_2_uo226305 {
	
	//Escenarios
	
	//2 Add en la posición 0 de una lista con varios elementos añade el elemento y mueve el resto una posición a la derecha

		public static Stream<Arguments> createLists() {
			  return Stream.of(
			      Arguments.of(new ArrayList()),
			      Arguments.of(new LinkedList())
			  );
			}
	
	@ParameterizedTest
	@MethodSource("createLists")
	/**
	 * GIVEN: non-empty list
	 * WHEN: add(index, element)
	 * THEN: adds element to position 0 and moves one position the rest of them
	 */
	public void nonEmptyListAddAt0(List list) {
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		list.add(0, "testing");
		String s = "testingwihJUnitframework";
		assertEquals(list.toString(), s);
		
		
		
	}

}
