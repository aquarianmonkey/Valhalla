package com.berns.collections;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;

import com.berns.model.Egg;
import com.berns.model.Egg.Size;

public class SortingPracticeJava8
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	static void testComparatorWithSet(){
		
		Egg e1 = new Egg("soft", BigDecimal.valueOf(7.25));
		e1.setSize(Size.XLARGE);
		Egg e2 = new Egg("hard", BigDecimal.valueOf(6.25));
		e2.setSize(Size.MEDIUM);
		Egg e3 = new Egg("chewy", BigDecimal.valueOf(4.25));
		e3.setSize(Size.SMALL);
		Egg e4 = new Egg("awful", BigDecimal.valueOf(4.25));
		e4.setSize(Size.SMALL);
		
		Function<Egg,String> nameBased = Egg :: getName;
		//SortedSet<Egg> ss = new TreeSet<Egg>((o1,o2)-> o1.name.compareTo(o2.name));
//		SortedSet<Egg> ss = new TreeSet<Egg>(Comparator.comparing(Egg::getName));
		//SortedSet<Egg> ss = new TreeSet<Egg>(Comparator.comparing(Egg::getSize).thenComparing(nameBased));
		SortedSet<Egg> orderedEggs = new TreeSet<Egg>(Comparator.comparing(Egg::getPrice));
		orderedEggs.add(e2);
		orderedEggs.add(e1);
		orderedEggs.add(e3);
		orderedEggs.add(e4);
		
		System.out.println(orderedEggs);
		
	}
	
}
