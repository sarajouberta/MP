package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * SCENARIOS
 * 	1 Dos listas vacías de tipo ArrayList son iguales
 *  2 Dos listas vacías de tipo LinkedList son iguales
 * 	3 Dos listas vacías de ambos tipos son iguales
 *  4 Dos listas de tipo ArrayList con los mismos elementos en la misma posición son iguales
 *  5 Dos listas de tipo LinkedList con los mismos elementos en la misma posición son iguales
 *  6 Dos listas de ambos tipos con los mismsos elementos en la misa posición son iguales
 *  7 Dos listas de tipo ArrayList con los mismos elementos en diferente posición no son iguales
 *  8 Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones no sn iguales
 *  9 Dos listas de ambos tipos con los mismos elementos en diferentes posiciones no son iguales
 *  10 Dos listas de tipo ArrayList con diferentes elementos no son iguales
 *  11 Dos listas de tipo LinkedList con diferentes elementos no son iguales
 *  12 Dos listas de ambos tipos con diferentes elementos no son iguales
 *  
 *  
 * 	
 */
public class EqualsTests {
	

	private static Stream<Arguments> create2ListsSameType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new ArrayList()),
	    		Arguments.of(new LinkedList(), new LinkedList())
	    );
	}
	
	private static Stream<Arguments> create2ListsDifferentType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new LinkedList()),
	    		Arguments.of(new LinkedList(), new ArrayList())
	    );
	}
	
	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void sameArrayListTypeEmtpy(List list1, List list2) {
		fail();

	}
	

	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void sameLinkedListTypeEmtpy(List list1, List list2) {
		fail();

	}
	
	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void bothEmtpy(List list1, List list2) {
		fail();

	}

	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void sameItemsSameType(List list1, List list2) {
		fail();
	
	}
	
	
	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void sameTypeSameItemsDifferentOrder(List list1, List list2) {
		
		fail();
	}

	
	@ParameterizedTest@MethodSource("create2ListsDifferentType")

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void sameTypeDifferentItems(List list1, List list2) {
		fail();
	}


	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void arrayListLinkedListSameItems(List list1, List list2) {
		fail();
	
	}

	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void arrayListLinkedListDifferentItems(List list1, List list2) {
		fail();

	}

}
