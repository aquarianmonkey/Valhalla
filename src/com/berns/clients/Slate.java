package com.berns.clients;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import com.berns.utils.Factory;

class Aa
{
	void show()
	{
		System.out.println("in Aa");
	}
}

public class Slate extends Aa
{
	
	public static void main(String[] args) throws FileNotFoundException, Exception
	{
		// testTreeSet();
		// testListIterator();
		// testRandomInt();
		// testStringSlicing();
		// int n = 20;
		// for (int i = 1; i <= n; i++)
		// printFibonacci(i);
		// String aa = "What's a lovely";
		// String bb = "What's";
		String aa = "Baaa";
		String bb = "baaaaaaaa";
		String cc = "aa";
		System.out.println(aa.compareTo(bb));
		// List<String> series = new ArrayList<>(Arrays.asList(aa, bb, cc));
		List<String> series = Arrays.asList(aa, bb, cc);
		Collections.sort(series);
		System.out.println(series);
		
	}

	// 0,1,1,2,3,5
	private static void printFibonacci(int n)
	{
		int x[] = new int[n];
		String buff = "";
		for (int i = 0; i < n; i++)
		{
			if (i > 1)
			{
				x[i] = x[i - 2] + x[i - 1];
			} else
			{
				x[i] = i;
			}
			buff += String.valueOf(x[i]);
			if (i != (n - 1))
			{
				buff += ",";
			}
		}
		System.out.println(buff);
		// }
	}

	private static void testStringSlicing()
	{
		// String warning = String.join("#","a","b");
		// warning.length();
		String collect = "foobar:foo:bar".chars().distinct().peek(s -> System.out.println(">>>" + (char) s))
				.mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining(":"));
		System.out.println("Collect = " + collect);
		// collect.length();
	}

	static <T> Optional<T> getNameOptional(T x)
	{
		return Optional.ofNullable(x);
	}

	private static void testRandomInt()
	{
		Random random = new Random();
		IntConsumer consumer = System.out::println;
		long start = System.nanoTime();
		random.ints(1, 1000).limit(5_000L).filter(num -> {
			System.out.format("filter: %s [%s]\n", num, Thread.currentThread().getName());
			return true;
		}).sorted().forEach(consumer);
		long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
		System.out.println("Total millis =" + millis);
	}

	private static void testListIterator()
	{
		List<String> family = Factory.createListOfNames();
		// ListIterator<String> listIterator = family.listIterator();
		Iterator<String> listIterator = family.iterator();
		while (listIterator.hasNext())
		{
			// family.add("Frank");
			// listI)terator.add("Caleb");
			// family.add("Frank");
			String nxtName = listIterator.next();
			// family.remove(0);
			listIterator.remove();
			// String prevName = listIterator.previous();
			nxtName.length();
		}
	}
}
