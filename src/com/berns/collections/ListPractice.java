package com.berns.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

  class Task implements Runnable{

	@Override
	public void run() {
		
		
	}
  }


public class ListPractice<T extends List & Deque>{

	
	
	public static void main(String[] args) {

		ListPractice<LinkedList> xx = null;
		
		// useLinkedList();
		// sortList(Arrays.asList(5,3,4,2,8));
		//addLinkedList();
		//List<Integer> sorted = insertSort(Arrays.asList(1,2,7,4));
		//System.out.println(sorted);
		removeFromList();
		
		List<Object> letters = new ArrayList<>();
		letters.add(1);
		List<? super String> letters2 = letters;
		letters2.add("b");
		System.out.println(letters2);

		List<Integer> ints = new ArrayList<>();
		ints.add(2);
		List<? extends Number> nums = ints;
		
	}

	public static void removeFromList(){
		
		List<String> s  = new ArrayList<>(Arrays.asList("a","b","c","b"));
		s.removeAll(Collections.singleton("b"));
		System.out.println(s); // a, c
		
		s  = new ArrayList<>(Arrays.asList("a",null,"c",null));
		s.removeAll(Collections.singleton(null)); //a,c
		System.out.println(s);
		
	}
	
	public static List<Integer> insertSort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<>();
		originalList: for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}

	static void addLinkedList() {

		LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2));
		// ll.add(0,5);
		ll.addFirst(5);
		System.out.println(ll);

	}

	static void sortList(List<Integer> records) {

		Collections.sort(records, new Comparator<Integer>() {

			public int compare(Integer n1, Integer n2) {

				return n2 - n1;

			}

		});
		System.out.println("> sort " + records);

	}

	static void useLinkedList() {

		LinkedList<String> list = new LinkedList<>();

		list.add("mercury");
		list.add("venus");
		System.out.println(list);
		System.out.println("head of list = " + list.element());
		System.out.println("head of list(peek)= " + list.peek());
		list.offer("earth");
		System.out.println(list);
		list.offerFirst("Ursula");
		System.out.println(list);
		list.add(1, "preMercury");
		System.out.println(list);
		list.remove();
		System.out.println("List >" + list); // [preMercury, mercury, venus,
												// earth]

		List<String> cloneL = new LinkedList<>(list);
		// List<String> cloneL = Collections.unmodifiableList(list);
		cloneL.add("neptune");
		Collections.reverse(cloneL);
		System.out.println("Reversed list: " + cloneL);
		
		
	}

}
