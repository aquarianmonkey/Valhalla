package com.berns.practice;

import java.util.Arrays;

public class BitManipulation
{
	public static void main(String[] args)
	{

		int numForLeftShift = 3;
		int bitsToShift = 2;
		//System.out.println(Integer.toBinaryString(numForLeftShift));
		int leftShiftMultBy2PowerOfKbits = numForLeftShift << bitsToShift;
		//System.out.printf(" %d << %d = %d\n",numForLeftShift,bitsToShift, leftShiftMultBy2PowerOfKbits);
		
//		int numForRightShift = 3;
//		System.out.println(Integer.toBinaryString(numForRightShift));
//		int rightShiftDivBy2PowerOfKbits = numForRightShift << 3;
//		System.out.println(" 3 >> 3 = " + rightShiftDivBy2PowerOfKbits);
		
	}
}
