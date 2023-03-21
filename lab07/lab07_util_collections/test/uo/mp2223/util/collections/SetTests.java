package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 Set en la posición 0 de una lista con varios elementos, cambia el valor de la posición n y devuelve el valor anterior de esa posición
 * 	2 Set en la posición n de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posición 
 * 	3 Intentar realizar set en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
 * 	4 Intentar realizar set en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 * 	5 Intentar realizar set en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
 * 	6 Intentar realizar set en la posición size() de una lista con elementos, lanza  IndexOutOfBoundsException
 */
public class SetTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setFirst(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setFinal(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setMiddle(List list) {
		fail();

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testEmpty(List list) {
		fail();

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testUpper(List list) {
		fail();

		
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLower(List list) {
		fail();

	}



}
