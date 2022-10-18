package com.berns.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStringStreams {

	public static void main(String[] args) {
		
		testMapMethod();
		
	}
	
	static void testMapMethod(){
		
		String family = String.join(":","felisa","berns","enzo");
		System.out.println("family is " + family);

		List<Integer> collect = Pattern.compile(":")
	    .splitAsStream(family)
	    .map(s -> s.length())
	    .peek(System.out::println)
	    .collect(Collectors.toList());
		
		List<String> east = Arrays.asList("miami", "new_york");
		List<String> west = Arrays.asList("los_angeles", "dallas");
		
		Set<String> set = Stream.of(east, west)
		.flatMap( elem -> elem.stream()) //merges the two list into one
		.map( s -> String.join("_","nba",s))
		.collect(Collectors.toSet());
		
		System.out.println(set);
		
		
		
	}

	
	static void testStringJoin(){
		
		String family = String.join(":","felisa","berns","enzo");
		System.out.println("family is " + family);
		
		String collect = Pattern.compile(":")
	    .splitAsStream("foobar:foo:bar")
	    //.forEach(System.out::println);
	    .filter(s -> s.contains("bar"))
	    .sorted()
	    .collect(Collectors.joining(":"));
		
		System.out.println("collect = " + collect);
		
		StringTokenizer tokenizer = new StringTokenizer("a:b:c",":",true);
		
		while(tokenizer.hasMoreTokens()){
			
			System.out.println("token> " + tokenizer.nextToken());
		}
	}
	
	
}
