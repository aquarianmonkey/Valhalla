package com.berns.modules;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import com.berns.model.Egg;
import com.berns.utils.Factory;

public class CollectionsModule
{

	public static void main(String args[])
	{
		// testLinkedList();
		// testCopyOnWriteList();
		// testTreeSet();
		testListIterator();
	}

	private static void testListIterator()
	{
		List<String> listOfNames = Factory.createListOfNames();

		ListIterator<String> listIterator = listOfNames.listIterator();
		while (listIterator.hasNext())
		{

			String val = listIterator.next();
			val = listIterator.next();
			val = listIterator.previous();
			val.hashCode();

		}

	}

	private static void testCopyOnWriteList()
	{

		List<String> wishList = Collections.singletonList("Car");
		CopyOnWriteArrayList<String> wishList2 = new CopyOnWriteArrayList<>();
		wishList2.add("A");
		wishList2.add("B");

		for (String s : wishList2)
		{
			wishList2.add("C");
			System.out.println("wish: " + s);
		}

		System.out.println("wishlist: " + wishList2);
	}

	private static void testTreeSet()
	{

		Egg eggA = new Egg("A");
		Egg eggB = new Egg("B");
		Egg eggC = new Egg("C");

		// TreeSet<Egg> tree = new TreeSet<>(new Alphabetical());

		TreeSet<Egg> tree = new TreeSet<>((o1, o2) -> o1.name.compareTo(o2.name));
		tree.addAll(Arrays.asList(eggB, eggC, eggA));
		System.out.println(tree);
	}

	private static class Alphabetical implements Comparator<Egg>
	{

		@Override
		public int compare(Egg o1, Egg o2)
		{
			return o1.name.compareTo(o2.name);
		}

	}

	static void testLinkedList()
	{

		LinkedList<String> linkie = new LinkedList<>();
		linkie.addAll(Factory.createListOfNames());

		linkie.add(1, "Carol");

		String peek = linkie.peek();
		linkie.stream().reduce((n1, n2) -> n1 + "#" + n2).ifPresent(System.out::println);
		String poll = linkie.poll();
		linkie.stream().reduce((n1, n2) -> n1 + "#" + n2).ifPresent(System.out::println);
		String pop = linkie.pop();
		linkie.stream().reduce((n1, n2) -> n1 + "#" + n2).ifPresent(System.out::println);
		linkie.push("Jesus");
		linkie.stream().reduce((n1, n2) -> n1 + "#" + n2).ifPresent(System.out::println);

		// linkie.stream().map( name -> new Egg(name) ).forEach( eg ->
		// System.out.println(">>> egg name: " + eg.name));

	}

}
