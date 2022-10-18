package com.berns.exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringPractice
{

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{

		List<String> names = Arrays.asList("Ark", "Ball", "Cat");
		// System.out.println(names.indexOf("Cat"));
		//System.out.println(">>" + names);

		String[] sArr = new String[0];
			
		//System.out.println(Arrays.toString(names.toArray(sArr)));

		//reverseStrInPlace();

		// System.out.println(Integer.parseInt("0A0B0C0D",16));
		characterArrayToString();
		// substringToEnd();
		 //compareStrings();
		// isStringPairAnagrams("Mary","ArMy");
		// isStringPairAnagramsUsingArrays("Of","fo");
		// printDuplicateChars("Programming");
		// printDuplicateChars("wowoweep");
		// String input = "godzilla"; // allizdog

		// System.out.println(reverseStrRecursion(input));
		// String input = "inforAinfor";
		// String input = "inforinforB";
		// String input = "onetwoonetwothree";
		// String input = "infor";
		// System.out.println("repeated str is " + findRepeatedString(input));

	}

	private static void reverseStrInPlace()
	{
		String source = "workable";

		char[] letters = source.toCharArray();
		List<Character> loa = new ArrayList<>();

		for (int left = 0, right = (letters.length - 1); left < (letters.length / 2); left++, right--)
		{
			char tmp = letters[left];
			letters[left] = letters[right];
			letters[right] = tmp;
		}
		
		System.out.println(Arrays.toString(letters));
	}

	private static String findRepeatedString(String input)
	{
		if (input.length() == 1 || (input.indexOf(input.charAt(0), 1) < 0))
			return input;
		// String result = "";
		String buff = "";
		int matchIndex = 0;

		for (int i = 0; i < input.length(); i++)
		{
			buff += String.valueOf(input.charAt(i));
			int tempIndex = input.indexOf(buff, i + 1);

			if (tempIndex < 0)
			{
				if (i < matchIndex)
				{
					return input.substring(0, matchIndex);
				} else
				{
					return input.substring(matchIndex);
				}
				// break;
			} else
			{
				matchIndex = tempIndex;
			}
		}
		return "";
	}

	public static String reverseStrRecursion(String input)
	{

		if (input.length() == 1)
		{
			return input;
		}
		String lastChar = String.valueOf(input.charAt(input.length() - 1));
		return new StringBuilder(lastChar + reverseStrRecursion(input.substring(0, input.length() - 1))).toString();
	}

	private static void printDuplicateChars(String input)
	{
		// while(input.length() > 0)
		// {
		// char target = input.charAt(0);
		// int count = 0;
		//
		// for(char c: input.toCharArray())
		// {
		// if(c == target)
		// {
		// ++count;
		// }
		// }
		// input = input.replace(""+target,"");
		// if(count > 1)
		// System.out.println(target + ":" + count);
		//
		// }
		input = input.toLowerCase();
		char[] array = input.toCharArray();
		Arrays.sort(array);
		System.out.println(String.valueOf(array));

		int cnt = 1;
		for (int i = 0; i < array.length; i++)
		{
			if (i == (array.length - 1) || array[i] != array[i + 1])
			{
				if (cnt > 1)
					System.out.println(array[i] + ":" + cnt);
				cnt = 1;
			} else
			{
				++cnt;
			}
		}
	}

	private static void sortArraysInAscOrder(char[] uno, char[] dos)
	{
		Arrays.sort(uno);
		Arrays.sort(dos);
	}

	static void compareStrings()
	{

		System.out.println("M vs m, contains result: " + "M".contains(String.valueOf('m')));
		System.out.println("M vs m, indexOf result: " + "M".indexOf('m'));

	}

	static void characterArrayToString()
	{
		char[] uno = { 'u', 'n', 'o' };
		String[] sarr = {"hi","hey"};
		List<String> l1 = Arrays.asList(sarr);
		HashSet<String> hashSet = new HashSet<>(l1);
		
		System.out.println("> " + new String(uno));
		System.out.println("> " + Arrays.toString(uno));
		System.out.println("> " + String.valueOf(uno));

	}

	static void isStringPairAnagramsUsingArrays(String s1, String s2)
	{
		if (s1 != null && !s1.equals("") && s2 != null && !s2.equals(""))
		{
			throw new IllegalArgumentException("Invalid input parameters");
		}
		char[] uno = s1.toLowerCase().toCharArray();
		char[] dos = s2.toLowerCase().toCharArray();

		sortArraysInAscOrder(uno, dos);
		if (Arrays.equals(uno, dos))
		{
			System.out.printf("%s is an anagram of %s", s1, s2);
			return;
		}
		System.out.printf("%s is not an anagram of %s", s1, s2);
	}

	static boolean isStringPairAnagrams(String s1, String s2)
	{
		// Mary vs Army
		if (s1.length() != s2.length())
		{
			System.out.printf("%s length differs from %s", s1, s2);
			return false;
		}

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		for (int i = 0; i < s1.length(); i++)
		{
			String s1Char = Character.toString(s1.charAt(i));

			if (!s2.contains(s1Char))
			{
				System.out.println(">>char " + s1Char + " not found.");
				return false;
			}
		}
		System.out.printf("%s is an Anagram of %s\n", s1, s2);
		return true;

	}

	static void substringToEnd()
	{

		String input = "jellybean";

		System.out.println(input.substring(0, input.length()));

	}

	static void charArrayToString()
	{

		char[] helloArr = { 'h', 'e', 'l', 'l', 'o' };

		String greeting = new String(helloArr);
		System.out.println(greeting);

	}

}
