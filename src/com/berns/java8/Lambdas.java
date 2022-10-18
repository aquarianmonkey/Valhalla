package com.berns.java8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.berns.model.Egg;
import com.berns.model.Foo;
import com.berns.utils.Print;

class A{
	
}
class B extends A{
	
}
class C extends B{
	
}

public class Lambdas
{

	void look( A a){}
	
	void look (B b){}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		
		new Lambdas().look(new B());
		
		testPredicate("black");
		testPredicate("red");
		testSupplier();
		//testFlatMap();

		Egg scrambled = new Egg("Ben");
		scrambled.setFoo(new Foo("Enzo"));
		
		Print.out("Foo name is = " + testMethodRef( Egg::getFoo, scrambled).getName());
		
		try(InputStream is = new FileInputStream(new File("")); InputStream is2 = new FileInputStream(new File("")))
		{
			
		}catch(NullPointerException | ClassCastException  ex){
			
		}
		
		
	}

	
	static <T,R> R testMethodRef(Function<T,R> mapper, T scram)
	{
		return mapper.apply(scram);
	}
	
	static void testMethodRefAndSupplier()
	{
		// need to pass object instance to reference a method.
		//Supplier<Foo> doc = new Egg("xxx")::getFoo;
		Supplier<Foo> doc = () -> new Egg("xx").getFoo();
		
	}
	
	private static void testSupplier()
	{
		
		Supplier<Egg> creator = Egg::new;
		Supplier<Egg> creator2 = () -> new Egg();
		Egg omelette = creator.get();
		
	}

	static void testPredicate(String color)
	{
		Predicate<String> dark = c ->  c.equals("black");
		Predicate<String> bright = c ->  c.equals("red");
		
//		checkColor(dark,color);
		checkColor(bright, color);
		
	}
	
	static void checkColor(Predicate checker, String color)
	{
		
		if(checker.test(color))
		{
			System.out.println("Color accepted");
		}
		
	}
	
	static void testFunction()
	{
		Function<Integer,String> burian = age -> String.valueOf(age);
		Function<Integer,String> jm = age -> { 
				  int b = age*age;
			     return String.valueOf(b); 
		};
		call(burian, 20);
		call(jm, 20);	
	}
	
	
	static void call(Function<Integer,String> name, Integer age)
	{
		 System.out.println(">>>>>" + name.apply(age));
	}
	

	static void testFlatMap()
	{
		List<String> words = Arrays.asList("Hello", "World");

		 words.stream().map(w -> w.split("")).
		 flatMap(Arrays::stream).
		 distinct().
		 forEach(System.out::println);

		// ["helo", "world"]
		words.stream().map(w ->
		{

			return Arrays.stream(w.split("")).distinct().reduce((x, y) -> x + y).orElse("blah");

		}).peek(System.out::println).collect(Collectors.toList());

		// flatMap(Arrays::stream).
		// distinct().
		// forEach(System.out::println);

	}

}
