package com.berns.java8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.berns.model.Egg;
import com.berns.model.Foo;
import com.berns.model.Person;
import com.berns.utils.Factory;
import com.berns.utils.Print;


public class StreamClient
{

	/**
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		// testStream();
		// testStreamParallelStream();
		// testMaps();
		// testStreamOf();
		// testIntStream();
		// testParallelStream2();

//		URI uri = StreamClient.class.getResource("../resources/main.css").toURI();
//		Files.lines(Paths.get(uri)).limit(10).forEach( s-> System.out.println(">>>> " + s));

		
//		Stream.iterate(3, n -> n * 2).limit(3).forEach(System.out::println);

		int x = 1;
		
//		x += 1;
//		Print.out("x += > " + x);
		x =+ 2;
		
	}
	
	static void testParallelStream2()
	{

		// ForkJoinPool commonPool = ForkJoinPool.commonPool();
		// System.out.println(commonPool.getParallelism());

		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream()

		.filter(s ->
		{
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s ->
		{
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

	}

	static void testIntStream()
	{
		List<Foo> foos = new ArrayList<>();
		
		// IntStream
		// .range(1, 4)
		// .forEach(i -> foos.add(new Foo("Foo" + i)));

		IntStream.range(1, 4).mapToObj(i -> new Foo("Foo" + i)).peek(System.out::println).forEach(foo ->
		{
			foos.add(foo);
			System.out.println("for each");
		});

	}

	static void testStreamOf()
	{
		Egg[] eggArr = new Egg[] { new Egg("native"), new Egg("british"), new Egg("american") };
		Stream<Egg> eggies = Stream.of(eggArr);

		// Stream<Egg> eggies = Stream.of(new Egg[] { new Egg("native"), new
		// Egg("british"), new Egg("american") });

		eggies
				// .sorted( (e1,e2) -> e1.name.compareTo(e2.name))
				// .unordered()
				.filter(s ->
				{
					System.out.println("filter: " + s);
					return true;
				}).forEach(System.out::println);

	}

	static void testMaps()
	{
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++)
		{
			map.putIfAbsent(i, "val" + i);
		}

		// map.forEach((id, val) -> System.out.println(val));

		map.computeIfPresent(3, (key, val) -> "woo");

		assert map.get(3) == null : "3rd elem not null but " + map.get(3);

	}

	static void testStream()
	{
		Factory.createListOfStrings().stream().filter(s -> s.startsWith("b")).map(b -> Integer.valueOf(b.substring(3)))
				.sorted((num1, num2) -> num2.compareTo(num1)).forEach(System.out::println);
	}

	static void testStreamParallelStream()
	{
		List<String> values = Factory.createRandomUUIDs(900);

		long t0 = System.nanoTime();

		// long count = values.parallelStream().sorted().count();
		// System.out.println(count);
		values
				// .parallelStream()
				.stream().sorted().map(s ->
				{
					System.out.println(">>>" + s);
					return s;
				}
		// return s;
		).count();
		// .sorted().close();

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}

	static void printIt(String text, Consumer<String> action)
	{
		action.accept(text);
	}
}
