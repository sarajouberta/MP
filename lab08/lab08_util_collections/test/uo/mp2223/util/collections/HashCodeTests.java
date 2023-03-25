package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 1 El hashCode de una lista vacía es 1
 * 2 El hashCode de una lista no vacía es el hashCode calculado
 * 3 El hashCode de dos listas iguales del mismo tipo es el mismo
 * 4 El hashCode de dos listas iguales de diferente tipo es el mismo
 * 5 El hashCode de dos listas con los mismos elementos en posiciones diferentes es distinto
 */
public class HashCodeTests {
	
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
	
	public static Stream<Arguments> createOneList() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	private int val;

	@BeforeEach
	public void setUp() throws Exception {
		val = 31;
	}



	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createOneList")
	public void emptyTest(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createOneList")
	public void nonEmptyTest(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")

	public void sameTypeLists(List list1, List list2) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")
	public void differentOrderLists(List list1, List list2) {
		fail();
	}
		
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")
	public void sameTypeDifferentItemsLists(List list1, List list2) {
		fail();
	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	public void differentTypeSameItemsLists(List list1, List list2 ) {
		fail();
	}
}
