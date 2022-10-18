package com.berns.exercises.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.berns.exercises.StringPractice;

public class StringPracticeTest {

	private StringPractice uut;

	@Test
	public void testReverseStringRecursion() {
		// fail("Not yet implemented");
		// String input = "Lorenzo";
		// String input = "Lorenzo";
		String input = "Philippines";
		String expected = "senippilihP";
		assertEquals(expected, uut.reverseStrRecursion(input));

	}

	@Test
	public void addShudownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("Shutting down JVM at time: " + LocalDate.now());
			}
		});
	}

}
