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

public class Test_7_uo226305 {

	//7 Intentar añadir  en una posición negativa, se lanza IndexOutOfBoundsException y la lista permanece igual

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	/**
	 * GIVEN: non-empty list
	 * WHEN: add() to a negative position
	 * THEN: throws IndexOutOfBoundsException
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testLowerBound(List list) {
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		try {
			list.add(-1, "framework");
		}catch(IndexOutOfBoundsException e) {
			assertEquals("Invalid index", e.getMessage());
		}
	}
	
}
