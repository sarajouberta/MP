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
 * 	1 Remove de la posición 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vacía
 *  2 Remove de la posición 0 de una lista no vacía devuelve el elemento eliminado, quita el elemento de la lista y  mueve el resto de elementos una posición a la izquierda
 *  3 Remove de una posición existente, devuelve el elemento borrado, se quita el elemento de la lista y mueve los elementos de la derecha una posición a la izquierda
 *  4 Remove de la última posición, devuelve el elemento borrado y quita el lemento de la lista
 *  5 Intentar realizar remove en la posición -1 lanza IndexOutOfBoundsException
 *  6 Intentar realizar remove en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
 *  7 Intentar realizar remove en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 *  8 Intentar realizar remove en la posición size() de una lista no vacía, lanza IndexOutOfBoundsException
 */
public class RemoveFromPositionTests {
	
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
	public void delOnlyItem(List list) {
		fail();
	}


	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delFirst(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delLast(List list) {
		fail();
	}

	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delMiddle(List list) {
		fail();

	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		fail();
	}
	

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testUpperBound(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLowerBound(List list) {
		fail();
	}
		

}
