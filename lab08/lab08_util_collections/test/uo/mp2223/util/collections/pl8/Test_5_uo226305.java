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

public class Test_5_uo226305 {

	//5 Add en la posición después del último de una lista con elementos añade el elemento al final
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	/**
	 *GIVEN: non-empty list
	 * WHEN: add() to the end of the list
	 * THEN: adds element to the end of the list
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testUpperBound(List list) {
		list.add("testing");
		list.add("with");
		list.add("JUnit");
		list.add(list.size(), "framework");
		String s = "testingwihJUnitframework";
		assertEquals(list.toString(), s);
	}
	

	
}
