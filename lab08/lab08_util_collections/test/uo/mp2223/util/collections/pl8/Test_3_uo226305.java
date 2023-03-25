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

public class Test_3_uo226305 {

	//3 Add en una posición intermedia de una lista añade el elemento y mueve el resto una posición a la derecha
		
		public static Stream<Arguments> createLists() {
			  return Stream.of(
			      Arguments.of(new ArrayList()),
			      Arguments.of(new LinkedList())
			  );
			}
		
		
		/**
		 * GIVEN: list with elements 
		 * WHEN: add(index, element)
	     * THEN: adds element in index position and moves one position to the right the rest of them 
		*/
		@ParameterizedTest
		@MethodSource("createLists")
		public void addMiddle(List list) {
			list.add("testing");
			list.add("JUnit");
			list.add("framework");
			list.add(1, "with");
			String s = "testingwihJUnitframework";
			assertEquals(list.toString(), s);
		}
		
		
		
}
