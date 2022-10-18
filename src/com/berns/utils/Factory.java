package com.berns.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.berns.model.Person;

public class Factory
{

	public static List<Person> getPersons()
	{
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		return persons;
	}
	
	public static List<String> createRandomUUIDs(int count)
	{
		List<String> values = new ArrayList<>(count);
		for (int i = 0; i < count; i++)
		{
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		return values;
	}

	/**
	 * 
	 * @return {"Felisa", "Enzo", "Berns", "Celia", "Jovito","Allison", "Dave"}
	 */
	public static List<String> createListOfNames()
	{

		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("Felisa", "Enzo", "Berns", "Celia", "Jovito", "Allison", "Dave"));

		return list;
	}

	/**
	 * 
	 * @return {ddd2,aaa2,bbb1,aaa1...}
	 */
	public static List<String> createListOfStrings()
	{

		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		return stringCollection;
	}

}
