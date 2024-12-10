package com.deepu.workouts;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionInterfaceForStringExample {
	public static void main(String[] args) {
		MyStringCollection myStringCollection = new MyStringCollection();
		myStringCollection.add("Aadya");
		myStringCollection.add("Bhumi");
		myStringCollection.add("Chitra");
		myStringCollection.add("Deepu");
		myStringCollection.add("Ema");
		myStringCollection.add("Fma");
		myStringCollection.add("Gma");
		myStringCollection.add("Hma");
		myStringCollection.add("Ima");
		myStringCollection.add("Jma");
		myStringCollection.add("Kma");
		
		System.out.println("Size = " + myStringCollection.size());
		
		System.out.println("myStringCollection is empty ? " + myStringCollection.isEmpty());
		
		System.out.println("Contains Deepu ? " + myStringCollection.contains("Deepu"));
		
		System.out.println("Elements in names");
		for(String name : myStringCollection) {
			System.out.println(name);
		}
		
		Object[] obj = myStringCollection.toArray();
		System.out.println("After calling toArray()");
		for(Object name : obj) {
			System.out.println(name);
		}
		
		String[] newStringArray = new String[myStringCollection.size()];
		newStringArray = myStringCollection.toArray(newStringArray);
		System.out.println("After calling toArray(newStringArray)");
		for(String name : newStringArray) {
			System.out.println(name);
		}
		
		MyStringCollection myNewStringCollection = new MyStringCollection();
		myNewStringCollection.addAll(myStringCollection);
		myNewStringCollection.add("Lma");
		System.out.println("After adding all");
		for(String s : myNewStringCollection) {
			System.out.println(s);
		}
		
		System.out.println(myStringCollection.containsAll(myNewStringCollection));
		System.out.println(myNewStringCollection.containsAll(myStringCollection));
		
		MyStringCollection retainsStrings = new MyStringCollection();
		retainsStrings.add("Aadaya");
		retainsStrings.add("Chitra");
		retainsStrings.add("Ema");
		myStringCollection.retainAll(retainsStrings);
		System.out.println("After Retaining 3 names");
		for(String s : myStringCollection) {
			System.out.println(s);
		}
		
	}
}
class MyStringCollection implements Collection<String> {

	private String[] names;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyStringCollection() {
		names = new String[DEFAULT_CAPACITY];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for(int i=0; i<size; i++) {
			if(names[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			
			int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public String next() {
				return names[index++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		String[] newStringArray = new String[size];
		System.arraycopy(names, 0, newStringArray, 0, size);
		return newStringArray;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			return (T[]) toArray();
		}
		System.arraycopy(names, 0, a, 0, size);
		return a;
	}

	@Override
	public boolean add(String e) {
		if(size == names.length) {
			resize();
		}
		names[size++] = e;
		return true;
	}

	private void resize() {
		String[] newArray = new String[names.length * 2];
		System.arraycopy(names, 0, newArray, 0, size);
		names = newArray;
	}
	@Override
	public boolean remove(Object o) {
		for(int i=0; i< size; i++) {
			if(names[i].equals(o)) {
				System.arraycopy(names, i+1, names, i, size-i-1);
				names[--size] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean contains = false;
		for(Object o : c) {
			if(!contains(o)) {
				contains = true;
			}
		}
		return contains;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		for(String s : c) {
			add(s);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for(Object o : c) {
			if(remove(o)) {
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		
		Iterator<String> it = iterator();
		while(it.hasNext()) {
			String strName = it.next();
			if(!c.contains(strName)) {
				remove(strName);
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		for(int i=0; i<size; i++) {
			names[i] = null;
		}
	}
	
	
}