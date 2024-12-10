package com.deepu.workouts;

import java.util.Collection;
import java.util.Iterator;

public class CollectionInterfaceExample {
	public static void main(String[] args) {
		MyCollections1 mycollection = new MyCollections1();
		mycollection.add(10);
		mycollection.add(20);
		mycollection.add(30);
		mycollection.add(40);
		mycollection.add(50);
		mycollection.add(60);
		
		System.out.println("Size " + mycollection.size());
		System.out.println("Contains 20 ? " + mycollection.contains(20));
		
		for(Integer num : mycollection) {
			System.out.println(num);
		}
		
		//mycollection.remove(40);
		System.out.println("After removing 40, contains 40 ? " + mycollection.contains(40));
		
		for(Integer num : mycollection) {
			System.out.println(num);
		}
		
		Integer[] intArray = new Integer[8];
		
		intArray = mycollection.toArray(intArray);
		
		System.out.println("Array conaitns ");
		for(Integer i : intArray) {
			System.out.println(i);
		}
		
		MyCollections1 anotherMyCollection = new MyCollections1();
		anotherMyCollection.addAll(mycollection);
		anotherMyCollection.add(70);
		
		System.out.println("Another Collection");
		for(Integer i : anotherMyCollection) {
			System.out.println(i);
		}

		System.out.println(mycollection.containsAll(anotherMyCollection));
		System.out.println(anotherMyCollection.containsAll(mycollection));
		
		MyCollections1 myNewCollection = new MyCollections1();
		myNewCollection.add(20);
		myNewCollection.add(40);
		myNewCollection.add(60);
		
		mycollection.retainAll(myNewCollection);
		System.out.println("After retaining all");
		for(Object o : mycollection) {
			System.out.println(o);
		}
		
		/*anotherMyCollection.removeAll(mycollection);
		
		System.out.println("After removing all");
		for(Integer i : anotherMyCollection) {
			System.out.println(i);
		} */
	}
}

class MyCollections1 implements Collection<Integer> {
	
	private Integer[] items;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyCollections1() {
		items = new Integer[DEFAULT_CAPACITY];
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
		for(int i=0 ; i < size; i++) {
			if(items[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public Integer next() {
				return items[index++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		Integer[] array = new Integer[size];
		System.arraycopy(items, 0, array, 0, size);
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length < size) {
			return (T[]) toArray();
		}
		System.arraycopy(items, 0, a, 0, size);
		return a;
	}

	@Override
	public boolean add(Integer e) {
		if(size == items.length) {
			resize();
		}
		items[size++] = e;
		return true;
	}
	
	private void resize() {
		Integer[] newIntegerArray = new Integer[items.length * 2];
		System.arraycopy(items, 0, newIntegerArray, 0, items.length);
		items = newIntegerArray;
	}

	@Override
	public boolean remove(Object o) {
		for(int i=0; i < size; i++) {
			if(items[i].equals(o)) {
				System.arraycopy(items, i+1, items, i, size-i-1);
				items[--size] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		boolean modified = false;
		for(Integer i : c) {
			if(add(i)) {
				modified = true;
			}
		}
		return modified;
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
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			Integer item = it.next();
			if(!c.contains(item)) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		for(int i=0; i < size; i++) {
			items[i] = null;
		}
	}
	
}