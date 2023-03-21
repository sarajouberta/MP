package uo.mp2223.util.collections.impl;

import uo.mp2223.util.collections.List;

public abstract class AbstractList implements List{
	
	protected int numberOfElements;

	public AbstractList() {
		super();
		numberOfElements = 0;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) !=  -1 ? true : false;
	}

	@Override
	public boolean add(Object element) {
		add(size(), element);
		return true;
	}
	
	@Override
	public void clear() {
		numberOfElements = 0;
	}
	


	
}