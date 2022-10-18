package com.berns.clients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.berns.model.Egg;

@FunctionalInterface
interface Converter<F, T>
{

	T convert(F from);

}

public class LambdaEx
{
	volatile int s;

	public static void main(String[] args)
	{
		// testFuncInterfaces();
		// testPredicate();
		// testSupplier();
		// testFunctions();
		// testOptionals();
		//new LambdaEx().testFunctions2();
		
		
		// OK, array of unbounded wildcard type.
		List<?>[] lsa = new List<?>[10];
		Object o = lsa;
		Object[] oa = (Object[]) o;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		// Correct.
		oa[1] = li;
		// Run time error, but cast is explicit.
		String s = (String) lsa[1].get(0);
		
	}

	private void testFunctions2()
	{

		final int y = 5;

		Function<Integer, Function<Integer, Integer>> func1 = (i) -> (j) -> y + j * i;

		System.out.println(">>>>" + func1.apply(3).apply(5));

		// System.out.println(">>>>"+ func1.apply(3).apply(5));

	}

	private static void testOptionals()
	{

		Optional<String> actionWord = Optional.ofNullable("bam");

		// Optional<String> actionWord = Optional.ofNullable(null);

		actionWord.filter(str -> "bam".equals(str)).ifPresent(st -> System.out.println(">>> word = " + st));
		// Optional<String> optional = Optional.empty();

		// assert optional.isPresent() : "Optional is empty";

		// assert "bam".equals(optional.get()) : "Optional should be \"bam\"";
		boolean hey = false;

		hey = !actionWord.isPresent() ? actionWord.orElse("pow").equals("pow") : "bam".equals(actionWord.orElse("pow"));

		assert hey : "Optional value is wrong";

		actionWord.ifPresent(s -> System.out.println("optional value is: " + s));
	}

	private static void testFunctions()
	{

		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		String seven22 = backToString.apply("722");

		assert"722".equals(seven22) : "Value is not 722";
		System.out.println(" 722: expected value!!!");

	}
	

	private static void testPredicate()
	{

		Predicate<String> stringCheck = text -> Objects.nonNull(text);
		boolean isFalse = stringCheck.negate().test("Lorenzo");
		// boolean isTrue = stringCheck.negate().test("Lorenzo");
		assert!isFalse;
		// assert(isTrue == true) : "Should be true";

	}

	private static void testSupplier()
	{

		Supplier<Egg> maker = Egg::new;
		Egg egg = maker.get();

		assert egg != null;

	}

	public static void testFuncInterfaces()
	{

		Converter<String, Integer> converter = (from) ->
		{
			return Integer.valueOf(from);
		};
		Integer thirty = converter.convert("30");

		converter = Integer::valueOf;
		Integer forty = converter.convert("40");

	}

}
