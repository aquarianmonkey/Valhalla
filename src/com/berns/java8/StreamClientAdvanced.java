package com.berns.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.berns.model.Bar;
import com.berns.model.Foo;
import com.berns.model.Person;
import com.berns.utils.Factory;

public class StreamClientAdvanced
{

	private static final List<Person> PERSONS = Factory.getPersons();

	public static void main(String[] args)
	{

//		testCollect();
		testCollectsGroupingBy();
		
	}

	private static void testFlatMap()
	{
		// Stream<String> names = Stream.of("aBc", "d", "ef");
		List<Foo> foos = Arrays.asList(new Foo[] { new Foo("Obj1"), new Foo("Obj2") });
		foos.forEach(foo -> IntStream.range(1, 4).forEach(num -> foo.bars.add(new Bar("Bar" + num + ">" + foo.name))));

		foos.stream().flatMap(foo ->
		{
			System.out.println("foo> " + foo);
			return foo.bars.stream();
		})
				// .collect(Collectors.toList());
				.forEach(System.out::println);

	}
	
	static void testCollect()
	{
		List<Person> filtered =
			    PERSONS
			        .stream()
			        .filter(p -> p.getName().startsWith("P"))
			        .collect(Collectors.toList());

	    System.out.println(filtered);    // [Peter, Pamela]
	
	    Double averageAge = PERSONS
	    	    .stream()
	    	    .collect(Collectors.averagingInt(p -> p.getAge()));

	    System.out.println(averageAge);     // 19.0
	
	
	}
	
	static void testCollectsGroupingBy()
	{
		Map<Integer, List<Person>> personsByAge =
				  PERSONS
				 .stream()
				 .collect(Collectors.groupingBy( p -> p.getAge()));
		
		personsByAge
	    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	}
	
	
}
