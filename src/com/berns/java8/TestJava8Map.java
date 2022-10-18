package com.berns.java8;

import java.util.HashMap;
import java.util.Map;

public class TestJava8Map
{

	public static void main(String[] args)
	{
		//testComputeIfMethods();
		testPutIfAbsent();
	}
	
	static void testPutIfAbsent(){
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1,"felisa");
		
		map.putIfAbsent(1,callMe());
		
		printMap(map);
		
	}
	
	private static String callMe()
	{
		System.out.println("callMe() called");
		return "cowabunga";
	}

	static void testComputeIfMethods(){
		
		Map<Integer, String> map = new HashMap<>();
		
		for (int i=0; i< 10 ; i++)
		{
			map.putIfAbsent(i, "val"+i);
		}
		
		printMap(map);
		
		map.computeIfPresent(3,  (num,val) -> val + num);
		System.out.println(">>>"+map.get(3)); // val33
	
		//Removes the entry for key 9 since computed value is null
		map.computeIfPresent(9,  (num,val) -> null);
		System.out.println(">>>"+map.containsKey(9)); //false

		map.forEach((id,val) -> {
			System.out.println(val);
			}
		);
		
		map.computeIfAbsent(11, num -> "joy");
		map.containsKey(11); // true
		
		map.remove(3, "val3");
		map.get(3);             // val33

		map.remove(3, "val33");
		map.get(3);             // null
		
		System.out.println(map.getOrDefault(22, "no choice")); // no choice

		
	}

	private static <K,V> void printMap(Map<K,V> map)
	{
		map.forEach((id,val) -> System.out.printf("%s %s\n",id,val));
	}
	
	

}
