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

public class Test_6_uo226305 {

	//6 Un elemento repetido PUEDE ser añadido y se almacena correctamente
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	

	/**
	 * GIVEN: non-empty list
	 * WHEN: add() repeateed element
	 * THEN: adds the element correctly
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addRepeated(List list) {
		list.add("testing");
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		list.add("framework");
		String s = "testingwihJUnitframeworkframework";
		assertEquals(list.toString(), s);
	}

}
