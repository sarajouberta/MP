package uo.mp2223.util.collections.impl;

import uo.mp2223.util.collections.List;

public abstract class AbstractList<T> implements List<T>{
	
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
	public boolean add(T element) {
		add(size(), element);
		return true;
	}
	
	@Override
	public void clear() {
		numberOfElements = 0;
	}
	
	
	//estaban en otro sitio xd
	//sería menos cososo redefinir toString en linkedList 
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(!(o instanceof List)) return false;
		
		List that = (List) o;
		if(this.size() != that.size()) return false;
		
		for (int i = 0; i < size(); i++) {
			Object e1 = this.get(i);
			Object e2 = this.get(i);
			if(!(e1.equals(e2)))
				return false;
		}
		return true;
	}
	
	
	@Override
	public int hashCode() {
		int result = 1;
		for (int i = 0; i < size(); i++) {
			Object element = this.get(i);
			result = 31*result + (element.hashCode());
		}
		return result;
	}

	
}