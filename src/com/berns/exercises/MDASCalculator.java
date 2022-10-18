package com.berns.exercises;

import java.util.List;
import java.util.Random;

class A {
}

interface B {
}

class C<T extends A & B> extends A implements B {

}

public class MDASCalculator {

	class Dog {
		String name;

		void call() {
		}

	}

	public static void main(String[] args) {

		List<? super Object> l = null;

		// int ans = 120 * 10+2;
		int ans = 120 * 36 / 563 + 2 + 202 * 10;
		// System.out.println("ans=" + ans);

		String exp = "120*36/563+2+202*10";
		// String exp = "120*10+2";

		// System.out.println("1*1".split("\\*").length);

		// System.out.println("Total is = " + new
		// MDASCalculator().compute(exp));

		float f = -3.4E3f;
		System.out.println(" >> " + (1.0*8.0));
		
		 System.out.println(new Random().nextInt(6) + 1);
		
		// System.out.print("The sum is: " + sum);

	}

	public int compute(String expression) {

		if (expression.matches("\\d+")) {
			return Integer.valueOf(expression);
		}

		char[] symbols = { '*', '/', '+', '-' };
		int operIndx = 0;
		int leftIndx = 0;
		int rightIndx = 0;

		for (int j = 0; j < symbols.length && operIndx <= 0; j++) {
			operIndx = expression.indexOf(symbols[j]);
		}

		leftIndx = operIndx - 1;
		rightIndx = operIndx + 1;
		while (Character.isDigit(expression.charAt(leftIndx))) {
			if (--leftIndx < 0)
				break;
		}
		while (Character.isDigit(expression.charAt(rightIndx))) {
			if (++rightIndx == expression.length())
				break;
		}

		String target = expression.substring(leftIndx + 1, rightIndx);
		String operator = String.valueOf(expression.charAt(operIndx));
		String[] tokens = target.split("\\" + operator);
		String subtotal = operate(tokens[0], operator, tokens[1]);

		return compute(expression.replace(target, subtotal));

	}

	private String operate(String left, String operator, String right) {

		int a = Integer.parseInt(left);
		int b = Integer.parseInt(right);

		switch (operator) {
		case "*":
			return String.valueOf(a * b);
		case "/":
			return String.valueOf(a / b);
		case "+":
			return String.valueOf(a + b);
		case "-":
			return String.valueOf(a - b);
		}
		return "0";
	}

}
