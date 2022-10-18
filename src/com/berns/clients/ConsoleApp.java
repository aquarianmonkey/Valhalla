package com.berns.clients;

import java.util.List;
import java.util.Scanner;


 class Dog<T>{
	 
 }

public class ConsoleApp
{

	public static void main(String[] args)
	{

		//usingScanner();
		//askInputScanner();
		
		int[][] arr = new int[][]{{0,0},{1,2}};
		int x = -2;
		int y = 1;
		
		System.out.println(Math.max(-2,-3));
//		System.out.println(Arrays.toString(arr[1]));
		
		
	}

	private static void askInputScanner()
	{
		// create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);

	    //  prompt for the user's name
	    System.out.print("Enter your loop count: ");

	    // get their input as a String
	    int loopCount = scanner.nextInt();
	    
	    for(int i=0; i < loopCount; i++){
	    	
	    	// prompt for their text input
	    	System.out.print("Enter your text: ");
	    	System.out.printf("You entered %s\n",scanner.next());
	    	
	    }

	    System.out.print("I'm done, good bye! ");
	    
	    scanner.close();
	}
	
	
	private static void usingScanner()
	{
		// create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);

	    //  prompt for the user's name
	    System.out.print("Enter your name: ");

	    // get their input as a String
	    String username = scanner.next();

	    // prompt for their age
	    System.out.print("Enter your age: ");

	    // get the age as an int
	    int age = scanner.nextInt();

	    System.out.println(String.format("%s, your age is %d", username, age));
	    
	    scanner.close();
	}
	
	
}
