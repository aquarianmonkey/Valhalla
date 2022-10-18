package com.berns.exercises.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.berns.exercises.MDASCalculator;

public class MDASCalculatorTest {

	private MDASCalculator uut = new MDASCalculator();
	
	@Test
	public void testCompute() {
//		fail("Not yet implemented");
		
//		String exp1 = "120*10+2"; 
//		assertEquals( uut.compute(exp1), 1202) ;
		
		String exp2 = "98*360/10+25-6*10";
		assertEquals( 3493, uut.compute(exp2)) ;

		
	}

}
