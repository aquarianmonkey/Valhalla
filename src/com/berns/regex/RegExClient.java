package com.berns.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.berns.model.Foo;

 interface IHowler{
	 void howl();
 }
abstract class Dog implements IHowler{
	Dog(){
		System.out.println("abs const");
	}
}


public class RegExClient {
	
	public static void main(String[] args) throws Throwable {

	   List<Foo> list = Foo.foos;
	   
	   
	   list.addAll(Arrays.asList(new Foo("fo"),new Foo("fo2")));
	   
//	   for(int i=0; i<3; i++)
//	   {
		   System.out.println("main> " + list);
		   list.clear();
		   System.gc();
		   Thread.sleep(100);
		   
		   
		   
	   //}
	   
	   
	   //	   Runtime.getRuntime().runFinalization();
		// System.out.println(Pattern.matches("b.*","boy"));

		//testPatterMatcher();
		//testCharClasses();
		//testReluctantQuantifier();
	}

	static void call() throws Throwable{
		
	}
	void testWait(){
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private static void testReluctantQuantifier() {
		String text = "1*11222*1";

		//String regex = "(\\d+[\\*]\\d+?)"; //reluctant
		String regex = "(\\d+[\\*]\\d+)"; //greedy, default
		
		Matcher matcher = Pattern.compile(regex).matcher(text);
		while (matcher.find()) {
			System.out.println("matches >" + matcher.group());
		}
	}

	private static void testPatterMatcher() {
		String text = "1*11+1";

		String regex = "(\\d+([\\*\\+])\\d+)";
		Matcher matcher = Pattern.compile(regex).matcher(text);
		while (matcher.find()) {
			System.out.println("start>" + matcher.start() + " end>" + matcher.end());
			System.out.println("group 1>" + matcher.group(1));
			System.out.println("group 2>" + matcher.group(2));
			matcher.reset(matcher.replaceFirst("11"));
			//			System.out.println("reg start> " + matcher.regionStart());
			
		}
	}

	static void testCharClasses() {

		String intersection = "[a-d&&[ade]]";
		CharSequence input = "edfdza";
		//System.out.println(Pattern.matches(intersection, input));

		Matcher matcher = Pattern.compile(intersection).matcher(input);
		
		while(matcher.find())
		{
			System.out.println("found = " + matcher.group());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
