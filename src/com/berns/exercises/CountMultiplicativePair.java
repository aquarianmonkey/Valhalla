package com.berns.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class CountMultiplicativePair
{

	public static void main(String[] args)
	{
		int[] A = {0,1,2,2,3,5};
		int[] B = {500_000,500_000,0,0,0,20000};
		
		solution(A, B);
		
		
	}

	static int solution(int[] A, int[] B)
	{
		if( A.length == 0 || B.length == 0 )
		{
			throw new RuntimeException("Empty array!");
		}
		
		if(!isArrayValid(A, e -> e > 100_000) || !isArrayValid(B, e -> e > 999_999)  ){
			throw new RuntimeException("Invalid array!");
		}
		
		double C[] = new double[A.length];
		
		for(int i=0; i < A.length; i++)
		{
			double fraction = (double)(B[i])/1000000;
			C[i] = A[i] + fraction; 
		}

		String s = "";
		Arrays.stream(C).mapToObj( e -> String.valueOf(e)).
		reduce( (e1,e2) -> e1+ "," + e2).ifPresent(System.out::println);
			
		int pairs = 0;
		for(int p=0 ; p< A.length; p++)
		{
			for(int q= p+1; q < B.length; q++)
			{
				System.out.println("Evaluating: P="+p + "," + "q = " + q);
				
				 if(C[p] * C[q] >= C[p] + C[q])
				 {
					 ++pairs;
				 }
				
			}
		}

		System.out.println("Pairs found = " + pairs);
		
		return 0;
	}

	static boolean isArrayValid(int[] A, IntPredicate checkValSize)
	{
		return Arrays.stream(A).noneMatch(checkValSize);

	}

}
